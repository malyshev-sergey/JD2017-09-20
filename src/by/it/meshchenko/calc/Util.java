package by.it.meshchenko.calc;

public class Util {
    static void printException(Exception e){
        System.out.println("|e|="+e);
        System.out.println("|e.getMessage()|="          +e.getMessage());
        System.out.println("|e.getStackTrace.length|="  +e.getStackTrace().length);
        System.out.println("|e.getStackTrace|="         +e.getStackTrace());
        for (int j = 0; j < e.getStackTrace().length; j++) {
            System.out.println("|e.getStackTrace["+j+"]|="+e.getStackTrace()[j]);
        }
        System.out.println("|e.printStackTrace|");
        e.printStackTrace();
    }
}
