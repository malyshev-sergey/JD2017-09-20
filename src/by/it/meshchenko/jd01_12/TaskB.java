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
        String[] strArray = text.trim().split("( |,\n|:\n|\\.\n|\\.|, )");
        System.out.println("Произвольный список чисел: " + MyCollect.collectionToString(strArray));
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        HashSet<String> temp = new HashSet<>();
        for(int i = 0; i < strArray.length; i++) {
            if(list..containsValue())
            int var = i.next();
            if(var < 0){
                newList.addFirst(var);
            }
            else {
                newList.addLast(var);
            }
        }
        list.keySet().keySet().entrySet().Arrays.asList(strArray));
        System.out.println("Произвольный список чисел: " + MyCollect.collectionToString(list));
        Deque<Integer> newList = new ArrayDeque<>();
        for(Iterator<Integer> i = list.iterator(); i.hasNext();){
            int var = i.next();
            if(var < 0){
                newList.addFirst(var);
            }
            else {
                newList.addLast(var);
            }
        }
        // Iterator<Map.EntrySet<key, value>> it = map.entrySet().iterator();
        System.out.println("Отрицательные в начале: " + MyCollect.collectionToString(newList));
    }
}
