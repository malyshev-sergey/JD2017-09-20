package by.it.shelkovich.jd1_12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskC {

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
