package by.it.govor.jd01_12.TaskB;

import java.util.TreeMap;

/**
 * Created by User on 24.10.2017.
 */
public class Task1 {
    public static void task1() {
        TreeMap<String,Integer> map = new TreeMap<>();
        String s = "There are many big and small libraries everywhere in our country They have millions of books in different languages You can find there the oldest and the newest booksEvery school has a library. Pupils come to the library to take books on different subjects.The school library where Oleg studies is good It is a large clean room There are four big windows in it The walls are light blue There are a lot of shelves full of books You can find books on literature physics history chemistry geography biology and other subjects There are books in English too On the walls you can see pictures of some great writers and poets On the table near the window you can always see beautiful spring and autumn flowers Oleg likes to go to the library He can always find there something new something he needs";
        String[] masString = s.split(" ");
        for (String a:masString) {
        if  (map.containsKey(a)){
            Integer b =map.get(a);
            b++;
            map.put(a,b);
        }else{map.put(a,1);}

            }
        System.out.println(map);
        }
    }

