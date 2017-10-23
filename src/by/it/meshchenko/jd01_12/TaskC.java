package by.it.meshchenko.jd01_12;

import java.util.*;

public class TaskC {

    public static void exampleС1(Student[] listStudents, int capacity){
        LinkedHashMap<Integer, Student> c1 = new LinkedHashMap<>();
        HashSet<Student> hsStudents = new HashSet<>();
        ArrayList<Integer> keyRemove = new ArrayList<>();
        // Добавляем наименования объектов в список из массива listStudents случайным
        // образом, формируя 'capacity' записей
        for(int i = 0; i < capacity; i++){
            c1.put(i, listStudents[Util.randomInt(listStudents.length - 1)]);
        }
        // Выводим на экран с1 (так как в массиве listStudents всего 10 записей, а
        // с1 мы добавляем 14, то какие-то записи повторятся)
        System.out.println("c1 (LinkedHashMap<Integer, Student>) с повторяющими записями: ");
        Iterator<Map.Entry<Integer, Student>> itM = c1.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<Integer, Student> temp = itM.next();
            // Формируем массив ключей, которые в с1 имеют не уникальные записи
            if(!hsStudents.add(temp.getValue())){
                keyRemove.add(temp.getKey());
            }
            System.out.printf("%-3d  %-8s %-2s %n", temp.getKey(),
                    temp.getValue().getFirstName(),
                    temp.getValue().getLastName());
        }
        itM.remove();
        // Очищаем временное хранилище
        hsStudents.clear();
        // Удаляем из с1 не уникальные записи
        if(keyRemove.size() > 0){
            System.out.print("Ключи с повторяющими записями: ");
            for(Integer st : keyRemove){
                System.out.print(" " + st.toString());
                c1.remove(st);
            }
        }

        System.out.println("\n c1 (LinkedHashMap<Integer, Student>) с уникальными записями: ");
        itM = c1.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<Integer, Student> temp = itM.next();
            System.out.printf("%-3d  %-8s %-2s %n", temp.getKey(),
                    temp.getValue().getFirstName(),
                    temp.getValue().getLastName());
        }
    }

    public static void exampleС2(Student[] listStudents, int capacity){
        LinkedHashSet<Student> studA = new LinkedHashSet<>();
        LinkedHashSet<Student> studB = new LinkedHashSet<>();
        LinkedHashSet<Student> studC = new LinkedHashSet<>();
        // Добавляем наименования объектов в список из массива listStudents случайным
        // образом, формируя 'capacity' записей
        for(int i = 0; i < capacity; i++){
            studA.add(listStudents[Util.randomInt(listStudents.length - 1)]);
            studB.add(listStudents[Util.randomInt(listStudents.length - 1)]);
        }

        // выводим на экран studA
        Iterator<Student> itA = studA.iterator();
        System.out.println("Множество студентов А:");
        while (itA.hasNext()){
            Student temp = itA.next();
            System.out.printf("%-7s %-2s;  ", temp.getFirstName(), temp.getLastName());
        }
        // выводим на экран studB
        Iterator<Student> itB = studB.iterator();
        System.out.println("\nМножество студентов В:");
        while (itB.hasNext()){
            Student temp = itB.next();
            System.out.printf("%-7s %-2s;  ", temp.getFirstName(), temp.getLastName());
        }

        studC = MyCollect.getCross(studA, studB);
        // выводим на экран A cross B
        Iterator<Student> itC = studC.iterator();
        System.out.println("\nМножество студентов A cross B:");
        while (itC.hasNext()){
            Student temp = itC.next();
            System.out.printf("%-7s %-2s;  ", temp.getFirstName(), temp.getLastName());
        }
        studC = MyCollect.getUnion(studA, studB);
        // выводим на экран A union B
        itC = studC.iterator();
        System.out.println("\nМножество студентов A union B:");
        while (itC.hasNext()){
            Student temp = itC.next();
            System.out.printf("%-7s %-2s;  ", temp.getFirstName(), temp.getLastName());
        }

    }

    public static void exampleС3(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case '{': stack.push('{'); break;
                case '(': stack.push('('); break;
                case '[': stack.push('['); break;
                case '}':
                    if(!stack.isEmpty() && stack.pop().compareTo('{') == 0){ break; }
                    else{ strError(str); return;}
                case ')':
                    if(!stack.isEmpty() && stack.pop().compareTo('(') == 0){ break; }
                    else{ strError(str); return; }
                case ']':
                    if(!stack.isEmpty() && stack.pop().compareTo('[') == 0){ break; }
                    else{ strError(str); return; }
                default: break;
            }

        }
        if(stack.isEmpty()) strSuccess(str);
    }
    private static void strSuccess(String str){
        System.out.println("Расстановка скобок в строке '" + str + "' корректна");
    }
    private static void strError(String str){
        System.out.println("Расстановка скобок в строке '" + str + "' не корректна");
    }
}
