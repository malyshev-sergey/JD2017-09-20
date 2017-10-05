package by.it.malyshev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    static void taskC1(){

        System.out.println("\nЗадание C1:\n");

        StringBuilder sb = new StringBuilder(RunnerSix.LUKOMOR);
        int sbStartLength=sb.length();

        Pattern p = Pattern.compile("[^\n]+[\n\\.]");
        Matcher m = p.matcher(sb);

        int maxStringLength=0;
        while (m.find()) {
            if(maxStringLength < m.group().length()){
                maxStringLength=m.group().length();
            }
        }

        m.reset();
        while (m.find()) {
            StringBuilder a = new StringBuilder(m.group());
            Pattern space = Pattern.compile(" ");
            Matcher mSpace = space.matcher(a);
            for (int i = 0; i < (maxStringLength-m.group().length()); i++) {
                while (!mSpace.find((int)(Math.random()*m.group().length()))){
                    mSpace.reset();
                }
                a.insert(mSpace.start()," ");
            }
            sb.append(a.toString());
        }

        sb.delete(0,sbStartLength);
        System.out.println(sb);
    }
}
