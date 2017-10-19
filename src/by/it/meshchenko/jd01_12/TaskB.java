package by.it.meshchenko.jd01_12;

import java.util.*;

public class TaskB {
    private static final String text = "From fairest creatures we desire increase,\n"+
            "That thereby beauty's rose might never die,\n"+
            "But as the riper should by time decease,\n"+
            "His tender heir might bear his memory:\n"+
            "But thou, contracted to thine own bright eyes,\n"+
            "Feed'st thy light's flame with self-substantial fuel,\n"+
            "Making a famine where abundance lies,\n"+
            "Thyself thy foe, to thy sweet self too cruel.\n"+
            "Thou that art now the world's fresh ornament\n"+
            "And only herald to the gaudy spring,\n"+
            "Within thine own bud buriest thy content,\n"+
            "And, tender churl, mak'st waste in niggarding:\n"+
            "Pity the world, or else this glutton be,\n"+
            "To eat the world's due, by the grave and thee.";

    public static void exampleB1(){
        System.out.println("text = '" + text + "'");
        String[] strArray = text.trim().split("( |,\n|:\n|\\.\n|\\.|, )");
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        //HashSet<String> temp = new HashSet<>();
        for(int i = 0; i < strArray.length; i++) {
            if(list.containsKey(strArray[i])){
                list.replace(strArray[i], list.get(strArray[i]) + 1);
            }
            else {
                list.put(strArray[i], 1);
            }
        }
        System.out.println("Кол-во различных слов: ");
        System.out.println(MyCollect.mapToString(list));
    }

    public static void processArray(int capacity){
        List<Integer> arrList = new ArrayList<>();
        long start, end;

        System.out.println("ArrayList: ");
        start = System.currentTimeMillis();
        addElem(arrList, capacity);
        end = System.currentTimeMillis();
        System.out.printf("   Time add: %d %n", end - start);
        start = System.currentTimeMillis();
        delTwo(arrList);
        end = System.currentTimeMillis();
        System.out.println("   Win Element: " + MyCollect.collectionToString(arrList));
        System.out.printf("   Time remove: %d %n", end - start);
    }

    public static void prоcessLinked(int capacity){
        List<Integer> linkList = new LinkedList<>();
        long start, end;

        System.out.println("LinkedList: ");
        start = System.currentTimeMillis();
        addElem(linkList, capacity);
        end = System.currentTimeMillis();
        System.out.printf("   Time add: %d %n", end - start);
        start = System.currentTimeMillis();
        delTwo(linkList);
        end = System.currentTimeMillis();
        System.out.println("   Win Element: " + MyCollect.collectionToString(linkList));
        System.out.printf("   Time remove: %d %n", end - start);

    }

    private static void delTwo(List<Integer> list){
        int i = 1;
        while (list.size() > 1){
            for(;i < list.size(); i++){
                list.remove(i);
            }
            i = i - list.size();
        }
    }

    private static void addElem(List<Integer> list, int capacity){
        for(int i = 0; i < capacity; i++){
            list.add(i);
        }
    }
}
