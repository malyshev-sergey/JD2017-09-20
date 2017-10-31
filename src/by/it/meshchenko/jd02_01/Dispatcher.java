package by.it.meshchenko.jd02_01;

import java.util.Deque;
import java.util.LinkedList;

class Dispatcher {

    private static boolean storeStatus = false;
    static final int storeTimeWork = 120;

    private static int totalBuyer = 1;
    static final Deque<Buyer> buyerQueue = new LinkedList<>();
//    {
//        @Override
//        public boolean add(Buyer buyer) {
//            synchronized (buyerQueue){
//            return super.add(buyer);
//            }
//        }
//
//        @Override
//        public Buyer poll() {
//            synchronized (this){
//            return super.poll();
//            }
//        }
//    };

    static boolean storeOpen(){
        System.out.println("The store is open");
        return storeStatus = true;
    }
    static boolean storeClosed(){
        System.out.println("The store is closed");
        return storeStatus = false;
    }
    static boolean storeBlocked(){
        return !storeStatus;
    }

    static boolean isStoreStatus() {
        return storeStatus;
    }


}
