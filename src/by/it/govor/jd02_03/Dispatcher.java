package by.it.govor.jd02_03;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
   static final AtomicInteger maxBuyer = new AtomicInteger(30);
    static  AtomicInteger  nowBuyer= new AtomicInteger(0);
    static final LinkedBlockingDeque<Buyer> buyerQueue=new LinkedBlockingDeque<>();
}
