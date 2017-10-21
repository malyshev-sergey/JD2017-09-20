package by.it.malyshev.jd01_12;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author Sergey Malyshev
 */

public class TaskC3 {

    public static void main(String[] args) {

        System.out.println();
        printBracketsCheck("{[{(-1),2}],{8,-3}}*{{-1,2},{8,-3}}");
        printBracketsCheck("[{(-1),2}],{8,-3}}*{{-1,2},{8,-3}}");
        printBracketsCheck("{[{(-1),2}],{8,-3}}*{{-1,2},{8,-3}");
        printBracketsCheck("{[{(-1),2}],{8,-3}}*{{-1,2),{8,-3}}");
        printBracketsCheck("{[{(-1,2)}],{8,-3}}*{-1,2,8,-3}()");

    }

    private static boolean bracketsCheck(String str) {

        try {
            char[] strToChar = str.toCharArray();
            LinkedList<Character> a = new LinkedList<>();
            for (char s : strToChar) {
                switch (s) {
                    case '{':
                        a.push('{');
                        break;
                    case '[':
                        a.push('[');
                        break;
                    case '(':
                        a.push('(');
                        break;
                    case '}':
                        if (a.pop() != '{') return false;
                        break;
                    case ']':
                        if (a.pop() != '[') return false;
                        break;
                    case ')':
                        if (a.pop() != '(') return false;
                        break;
                }
            }
            return a.isEmpty();
        } catch (NoSuchElementException e) { return false; }

    }

    private static void printBracketsCheck(String s){
        if (bracketsCheck(s)) {
            System.out.println("Скобки в выражении "+s+" расставлены корректно");
        } else {
            System.out.println("Скобки в выражении "+s+" расставлены некорректно");
        }
    }



}
