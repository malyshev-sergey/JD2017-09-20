package by.it.meshchenko.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

public class ImitationFlowBuyers implements Runnable {
    private int goTime = 0;
    private int timeWork;
    private boolean createBuyer = false;
    private int aBMF = 10;                           // 'amountBuyerMaxFirst' N >= t+10
    private int aBMS = 70;                           // 'amountBuyerMaxSecond' N <= 40+(30-t)
    private int tempNumberBuyer = 0;                 // N
    private final Lock lockBuyers = new ReentrantLock();
    List<Buyer> listBuyers = new ArrayList<>();

    public ImitationFlowBuyers(int timeWork){
        this.timeWork = timeWork;
    }

    @Override
    public void run()  {
        try{
            while(flowBuyers()){
                Thread.sleep(1000);
                goTime++;
            }
        }
        catch (InterruptedException e){

        }
    }

    boolean flowBuyers(){
        boolean isWork = false;
        if(goTime <= timeWork){                                     // магазин работает 0...120 сек
            isWork = true;
            if(( goTime <= 30                                       // первые 30 сек в минуте N <= t+10
                    || (goTime >= 60 && goTime <= 90))
                    && (tempNumberBuyer-2 <=  goTime + aBMF)){
                createBuyer = true;
            } else if(( goTime > 30 && goTime < 60                  // вторые 30 сек в минуте N <= 40+(30-t)
                    || (goTime > 90 && goTime < 120))
                    && (tempNumberBuyer-2 <=  aBMS - goTime))
                createBuyer = true;
            else {
                createBuyer = false;
            }

            if(createBuyer){                                        // Создаём покупателя
                int currentBuyerCount = Helper.random(0, 2);
                boolean isPensioner = (Helper.random(0, 3) == 0);
                for (int j = 0; j < currentBuyerCount; j++){
                    Buyer b = new Buyer(tempNumberBuyer++, isPensioner);
                    b.start();
                    try{
                        lockBuyers.lock();
                        listBuyers.add(b);
                    }
                    finally {
                        lockBuyers.unlock();
                    }
                }
            }
        }
        return isWork;
    }
}
