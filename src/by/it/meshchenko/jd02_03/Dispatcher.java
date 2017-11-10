package by.it.meshchenko.jd02_03;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.DoubleAdder;

class Dispatcher {
    // Время работы магазина
    static final int storeTimeWork = 120;
    // Количество корзинок в магазине
    static final Semaphore countBasketSemaphore = new Semaphore(30);
    // Вместимость зала магазина
    static final Semaphore hallCapacitySemaphore = new Semaphore(20);

    static ExecutorService executCashier = Executors.newFixedThreadPool(5);

    //Выручка магазина
    static DoubleAdder total = new DoubleAdder();

    //Анонимный класс компаратора
    static Comparator<Buyer> idComp = new Comparator<Buyer>(){

        @Override
        public int compare(Buyer c1, Buyer c2) {
            if(c1.isPensioner == c2.isPensioner) return 0;
            else if(c1.isPensioner && !c2.isPensioner) return -1;
            return 1;
        }
    };

    //Очередь покупателей c пенсионерами (которые обслуживаются первыми) на обслуживание в кассе
    static final PriorityBlockingQueue<Buyer> buyerBlockQueue = new PriorityBlockingQueue<>(40, idComp);

    // Главный метод диспетчера, управляет кассирами
    static void run(){
        //Открываем магазин
        storeOpen();
        // Создаём 5 кассиров
        Cashier[] arrCas = new Cashier[5];
        for (int i = 0; i < arrCas.length; i++) {
            arrCas[i] = new Cashier(i+1);
            executCashier.execute(arrCas[i]);
        }

        //Создаём поток имитирующий покупателей
        ImitationFlowBuyers ifB = new ImitationFlowBuyers(Dispatcher.storeTimeWork);
        Thread th_ifB = new Thread(ifB);
        th_ifB.start();

        int listB = 0;
        int queueB = 0;
        while((th_ifB.getState() != Thread.State.TERMINATED) || listB > 0 ) {
            //Определяем сколько нужно кассиров
            if(queueB < 1) runCashier(0, arrCas);
            else if(queueB <=5) runCashier(1, arrCas);
            else if(queueB <=10) runCashier(2, arrCas);
            else if(queueB <=15) runCashier(3, arrCas);
            else if(queueB <=20) runCashier(4, arrCas);
            else runCashier(5, arrCas);

            //люди в магазине
            listB = Buyer.listBlockingBuyers.size();

            //количество людей в кассу
            queueB = buyerBlockQueue.size();

            try{
                Thread.sleep(400);
            }
            catch (InterruptedException e){

            }
        }

        executCashier.shutdown();
        //Отпускаем кассиров домой
        goHomeCashiers(arrCas);
        //Закрываем магазин
        storeClosed();
    }

    private static void storeOpen(){
        System.out.println("The store is open\n");
        System.out.println("Time - Время \n" +
                        "# B - число покупателей в магащине\n" +
                        "Cashier_1, Cashier_2, Cashier_3, Cashier_4, Cashier_5 - номера кассиров\n" +
                        "Queue - очередь в кассу\n" +
                        "TotalSumma - выручка магазина\n" +
                        "Buyer State - действия покупателей\n");
        //Таблица работы магазина
        System.out.printf("%-4s| %-4s| %-25s| %-25s| %-25s| %-25s| %-25s|%-5s|%-10s| %s %n"
                , "Time", "# B", "   Cashier_1", "   Cashier_2", "   Cashier_3"
                , "   Cashier_4", "   Cashier_5", "Queue", "TotalSumma", "Buyer State");
    }

    private static void storeClosed(){
        System.out.println("The store is closed");
    }

    //Запустить кассира в работу, в зависимости от числа покупателей в очереди в кассу
    static private void runCashier(int num, Cashier[] arrCas){
        for (int i = 0; i < arrCas.length; i++) {
            if(i >= num) arrCas[i].setIsOpen(false);
            else {
                arrCas[i].setIsOpen(true);
                synchronized (arrCas[i]) {
                    arrCas[i].notify();
                }
            }
        }
    }

    //Кассиры заканчивают работу
    static private void goHomeCashiers(Cashier[] arrCas){
        for (int i = 0; i < arrCas.length; i++) {
            arrCas[i].setIsWork(false);
            synchronized (arrCas[i]) {
                arrCas[i].notify();
            }
        }
    }

    //Отображение в консоли работы магазина
    static void printWork(PrintView pv){
        //Замена на пустую строку, переменных Number
        String tStr = pv.getTime() == -1 ? "" : Integer.toString(pv.getTime());
        String cbStr = pv.getCountBuyer() == -1 ? "" : String.format("%4d", pv.getCountBuyer());
        String qStr = pv.getQueueSize() == -1 ? "" : String.format("%4d",pv.getQueueSize());
        String totalStr = pv.getTotal() == -1 ? "" : String.format("%7.1f",pv.getTotal());

        StringBuilder strP = new StringBuilder();

        //Строки, печатающие кассирами, могут содержать символ '\n', для этого
        // формируем корректный вывод в консоль
        // Делаем это только в том случае, если метод печати вызывается для кассира
        if(pv.isCashier()) {

            String[][] strCashierFormat = new String[5][];
            for(int i = 0; i < strCashierFormat.length; i++){
                strCashierFormat[i] = pv.getCashiers(i).split("\\n");
            }
            for(int i = 0; i < strCashierFormat.length; i++){
                for(int j = 0; j < strCashierFormat[i].length; j++){
                    if(!strCashierFormat[i][j].isEmpty()) {
                        String cashier1 = i == 0 ? strCashierFormat[i][j] : "";
                        String cashier2 = i == 1 ? strCashierFormat[i][j] : "";
                        String cashier3 = i == 2 ? strCashierFormat[i][j] : "";
                        String cashier4 = i == 3 ? strCashierFormat[i][j] : "";
                        String cashier5 = i == 4 ? strCashierFormat[i][j] : "";
                        strP.append(String.format("%-4s| %-4s| %-25s| %-25s| %-25s| %-25s| %-25s| %-4s| %-9s| %s %n"
                            , tStr, cbStr, cashier1, cashier2, cashier3, cashier4, cashier5
                            , qStr, totalStr, pv.getBuyerState()));
                    }
                }
            }
        }
        else {
            strP.append(String.format("%-4s| %-4s| %-25s| %-25s| %-25s| %-25s| %-25s| %-4s| %-9s| %s %n"
                    , tStr, cbStr, pv.getCashiers(0), pv.getCashiers(1), pv.getCashiers(2)
                    , pv.getCashiers(3), pv.getCashiers(4), qStr, totalStr, pv.getBuyerState()));
        }
        System.out.printf(strP.toString());
    }
}
