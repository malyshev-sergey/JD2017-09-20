package by.it.shelkovich.jd2_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BuyerQueue {


    static volatile int moneyTotal = 0;

    static Deque<Buyer> queue = new LinkedList<Buyer>(){
        @Override
        public synchronized Buyer poll() {
            return super.poll();
        }

        @Override
        public synchronized void addLast(Buyer buyer) {
            super.addLast(buyer);
        }
    };

    static Deque<Buyer> pensQueue = new LinkedList<Buyer>(){
        @Override
        public synchronized Buyer poll() {
            return super.poll();
        }

        @Override
        public synchronized void addLast(Buyer buyer) {
            super.addLast(buyer);
        }
    };
}
