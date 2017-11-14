package by.it.govor.jd02_02;


import java.util.Deque;
import java.util.LinkedList;

public class Dispatcher {
   static final Integer maxBuyer =30;
  static  volatile int nowBuyer=0;
    static final Deque<Buyer> buyerQueue=new LinkedList<>();
}
