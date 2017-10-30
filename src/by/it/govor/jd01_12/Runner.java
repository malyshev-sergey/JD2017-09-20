package by.it.govor.jd01_12;



import by.it.govor.jd01_12.TaskB.Task2;

import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {

      //  Task1.task1();
     ArrayList<Integer> a = new ArrayList<>(RandomArray.randomArrayInt());
     ArrayList<Integer> b = new ArrayList<>(RandomArray.randomArrayInt());
     //  MyCollect.getCross(a,b);
     //   MyCollect.getUnion(a,b);
      //  Task3.task3();
        Task2.task2();
      //  Task1.task1();
    }

}
