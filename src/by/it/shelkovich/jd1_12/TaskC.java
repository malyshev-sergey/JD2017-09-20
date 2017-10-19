package by.it.shelkovich.jd1_12;

import java.util.*;

public class TaskC {

    static void Part2(){
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            setA.add((int)Math.round(Math.random()*30));
            setB.add((int)Math.round(Math.random()*30));
        }
        System.out.println("Исходное множество А:");
        System.out.println(setA);
        System.out.println("Исходное множество B:");
        System.out.println(setB);
        System.out.println("Пересечение множеств:");
        System.out.println(MyCollectMultiType.getCross(setA, setB));
        System.out.println("Объединение множеств:");
        System.out.println(MyCollectMultiType.getUnion(setA, setB));
    }

    static void Part3(){
        String line1 = "((){()[{1,2,3,(1+1)[15]}]})";
        String line2 = "(((){()[{()[])}])";

        System.out.printf("Результат проверки строки %s: %s\n", line1, isBracersCorrect(line1));
        System.out.printf("Результат проверки строки %s: %s\n", line2, isBracersCorrect(line2));

    }

    static boolean isBracersCorrect(String line){
        Deque<Character> stack = new LinkedList<>();
        char[] chars = line.toCharArray();
        for(char ch: chars){
            switch(ch){
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.pop() != '{') return false;
            }
        }
        return true;
    }
}
