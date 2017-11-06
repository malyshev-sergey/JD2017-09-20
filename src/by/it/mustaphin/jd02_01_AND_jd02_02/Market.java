package by.it.mustaphin.jd02_01_AND_jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Market extends ArrayList {

    static Queue<Buyer> buyersQueue = new LinkedList<>();

    void letIn() {
        for (int i = 0; i < 60; i++) {
            for (int k = (int) (Math.random() * 3); k > 0; k--) {
                add(new Buyer(i + ":" + k));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void moveToQueue(Buyer buyer) {
        synchronized (buyersQueue) {
            buyersQueue.offer(buyer);
        }
    }

}
