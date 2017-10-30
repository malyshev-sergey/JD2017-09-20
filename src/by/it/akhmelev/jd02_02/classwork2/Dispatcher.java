package by.it.akhmelev.jd02_02.classwork2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Dispatcher {

    static final Integer planBuyer=30;
    volatile static int countBuyer=0;
    static final Deque<Buyer> buyerQueue=new LinkedList<>();
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

}
