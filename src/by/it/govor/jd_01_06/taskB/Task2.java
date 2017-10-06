package by.it.govor.jd_01_06.taskB;



        import java.util.Arrays;


public class Task2 {
     static void task() {


        String s = by.it.govor.jd_01_06.Date.STR;
        String[] str = s.split("//.");


        for (int j = 0; j < str.length; j++) {


            for (int i = 0; i < str.length - j; i++) {
                if(i!=str.length-j-1){
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



