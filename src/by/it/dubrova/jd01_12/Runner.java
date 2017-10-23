package by.it.dubrova.jd01_12;

import java.util.*;

public class Runner {

    public static void TaskA1(){
        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            score.add((int)(Math.random() * 9 + 1)); // заполняем так, чтобы не получилось 0

        System.out.print("Оценки учеников: ");
        System.out.println(score);
        System.out.print("Удаляем с низким баллом: ");

        //создаем указатель
        Iterator<Integer> itr = score.iterator();
        //удаляем
        while (itr.hasNext()){
            if (itr.next() < 5)
                itr.remove();
        }
        System.out.println(score);
    }

    public static void TaskA2(){
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        // заполняем рандомными значениями
        for (int i = 0; i < 10; i++) {
            a.add((int) (Math.random() * 100));
            b.add((int) (Math.random() * 100));
        }
        Set<Integer> result =  new HashSet<>();
        //объединяем два множества и выводим на экран
        result = MyCollect.getUnion(a,b); // теперь в A у нас обединенное множество
        System.out.println(result);
        //а теперь найдем перекрестные
        result = MyCollect.getCross(a,b);
        System.out.println(result);

    }

    public static void TaskA3(){
        Integer[] i = {1,2,4,5,-2,-6,-8,9,10,12};
        // создать из массива множество TreeSet и отсортировать его, используя свой компоратор (возможно анонимным классом перегрузив)
        List<Integer> list = Arrays.asList(i);
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        ts.addAll(list);
        System.out.println(ts);

    }

    public static void main(String[] args) {
        TaskA1();
        TaskA2();
        TaskA3();
    }
}
