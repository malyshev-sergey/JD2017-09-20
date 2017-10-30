package by.it.govor.jd_01_06.taskB;


import java.util.Arrays;

import static by.it.govor.jd_01_06.Date.STR;

public class Task2 {
     static void task() {
        String[] str = STR.split("[\\.!//n]{1,}");


        for (int j = 0; j < str.length; j++) {

            for (int i = 0; i < str.length; i++) {
                if(i!=str.length-1){
                    String[] r = str[i].split(" ");
                    String[] y = str[i + 1].split(" ");
                    if (r.length > y.length) {
                        String com = str[i];
                        str[i] = str[i + 1];
                        str[i+1]=com;
                    }
                }
            }
        }
        System.out.println(Arrays.asList(str));
    

     }

}



