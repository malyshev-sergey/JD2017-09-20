package by.it.meshchenko.jd01_13;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TaskA {
    public static void example1() throws Exception {
        ArrayList<Double> arr = new ArrayList<>();
        boolean exit = true;
        while (exit){
            System.out.print("Введите число или 'end' для выхода: ");
            String str = Util.getOneLine();
            if(str.toLowerCase().compareTo("end") == 0) return;
            else {
                try{
                    printExample1(arr, str);
                }
                catch(NumberFormatException e){
                    System.out.println("NumberFormatException: " + str
                            + ": Недопустимое преобразование строки в числовой формат");
                }
                catch(IllegalArgumentException e){
                    System.out.println("IllegalArgumentException: Math.sqrt(" +str
                            + "): При вызове метода использован незаконный аргумент");
                }
                catch(Exception e){
                    Util.printException(e);
                }
            }
        }
    }

    private static void printExample1(ArrayList<Double> arr, String str){
        double d = Util.lineToDouble(str);
        double sum = 0;
        if(d < 0) {
            throw new IllegalArgumentException();
        }
        else {
            arr.add(d);
            for(Double i : arr){
                sum = sum + Math.sqrt(i);
            }
        }
        System.out.printf("%s  сумма корней - %-10.3f %n", str, sum);
    }
}
