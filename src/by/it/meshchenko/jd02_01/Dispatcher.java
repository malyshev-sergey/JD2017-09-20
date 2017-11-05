package by.it.meshchenko.jd02_01;

import java.util.Comparator;
import java.util.PriorityQueue;

class Dispatcher {
    // Время работы магазина
    static final int storeTimeWork = 120;

    //Выручка магазина
    static final Integer totalSynchr = 0;
    static double total = 0;

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
    static final PriorityQueue<Buyer> buyerQueue = new PriorityQueue<>(5, idComp);

    // Главный метод диспетчера, управляет кассирами
    static void run(){
        //Открываем магазин
        storeOpen();
        // Создаём 5 кассиров и 5 потоков для них
        Thread [] arrThreadCas = new Thread[5];
        Cashier [] arrCas = new Cashier[5];
        for (int i = 0; i < arrThreadCas.length; i++) {
            arrCas[i] = new Cashier(i+1);
            arrThreadCas[i] = new Thread(arrCas[i]);
        }
        //Создаём поток имитирующий покупателей
        ImitationFlowBuyers ifB = new ImitationFlowBuyers(Dispatcher.storeTimeWork);
        Thread th_ifB = new Thread(ifB);
        th_ifB.start();

        int listB = 0;
        int queueB = 0;
        while( (th_ifB.getState() != Thread.State.TERMINATED) || listB > 0 ) {
            //Определяем сколько нужно кассиров
            if(queueB < 1){
                runCashier(0, arrCas, arrThreadCas);
            }
            else if(queueB <=5){
                runCashier(1, arrCas, arrThreadCas);
            }else if(queueB <=10){
                runCashier(2, arrCas, arrThreadCas);
            }else if(queueB <=15){
                runCashier(3, arrCas, arrThreadCas);
            }else if(queueB <=20){
                runCashier(4, arrCas, arrThreadCas);
            }else {
                runCashier(5, arrCas, arrThreadCas);
            }

            //люди в магазине
            synchronized (Buyer.listBuyers) {
                listB = Buyer.listBuyers.size();
            }
            //количество людей в кассу
            synchronized (buyerQueue) {
                queueB = buyerQueue.size();
            }
            try{
                Thread.sleep(400);
            }
            catch (InterruptedException e){

            }
        }
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
    static private void runCashier(int num, Cashier [] arrCas, Thread[] arrThreadCas){
        for (int i = 0; i < arrCas.length; i++) {
            try{
                arrCas[i].lockCashier.lock();
                if(i >= num && arrCas[i].isOpen()) {
                    arrCas[i].setOpen(false);
                }
                else if(i < num && !arrCas[i].isOpen()) {
                    arrCas[i].setOpen(true);
                    synchronized (arrCas[i]) {
                        if(arrThreadCas[i].getState() == Thread.State.NEW) {
                            arrThreadCas[i].start();
                        }
                        else if(arrThreadCas[i].getState() == Thread.State.TERMINATED) {
                            arrThreadCas[i] = new Thread(arrCas[i]);
                            arrThreadCas[i].start();
                        }
                    }
                }
            }
            finally {
                arrCas[i].lockCashier.unlock();
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
