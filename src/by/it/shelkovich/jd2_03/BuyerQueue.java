package by.it.shelkovich.jd2_03;

import java.io.BufferedReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class BuyerQueue {

    private final static ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque();
    private final static ConcurrentLinkedDeque<Buyer> pensQueue = new ConcurrentLinkedDeque();

    static AtomicInteger moneyTotal = new AtomicInteger(0);

    static void addLast(Buyer b){
        queue.addLast(b);
    }

    static void addLastPens(Buyer b){
        pensQueue.addLast(b);
    }

    static Buyer poll(){
        return queue.poll();
    }

    static Buyer pollPens(){
        return pensQueue.poll();
    }

    static int getSize(){
        return queue.size() + pensQueue.size();
    }

}
