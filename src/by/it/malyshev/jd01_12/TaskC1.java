package by.it.malyshev.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergey Malyshev
 */

public class TaskC1 {

    public static void main(String[] args) {
        System.out.println("\nМоделируем исходный текст под усдовия задачи:\n");

        String input=inputTxtModelling(Data.TXT, 50);
        System.out.println(input);

        Random r = new Random();
        Pattern val = Pattern.compile("NAME[0-9]+");
        Matcher mVal = val.matcher(input);

        Map<Integer, String> c1=new TreeMap<>();
        while(mVal.find()) {
            int a=r.nextInt(2000)+1000;
            while(c1.containsKey(a)) a=r.nextInt(2000)+1000;
            c1.put(a,mVal.group());
        }

        System.out.println("Создаем список С1:");
        for (Map.Entry<Integer, String> entry : c1.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());

        List<String> temp = new ArrayList<>();
        Iterator<Map.Entry<Integer, String>> itr = c1.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer, String> entry = itr.next();
            if(temp.contains(entry.getValue())) itr.remove();
            else temp.add(entry.getValue());
        }

        System.out.println("\nСжимаем список С1");
        for (Map.Entry<Integer, String> entry : c1.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());

    }

    private static String inputTxtModelling(String str, int n) {
        StringBuilder sb = new StringBuilder(str);
        Random r = new Random();
        Pattern space = Pattern.compile(" ");
        Matcher mSpace = space.matcher(sb);
        for (int i = 0; i < n; i++) {
            while (!mSpace.find(r.nextInt(sb.length()))) {
                mSpace.reset();
            }
            sb.insert(mSpace.start(), " NAME" + (r.nextInt(10)+1));
        }
        return sb.toString();
    }


}
