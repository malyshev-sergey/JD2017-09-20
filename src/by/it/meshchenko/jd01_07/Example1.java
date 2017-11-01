package by.it.meshchenko.jd01_07;

class Example1 extends AbstractExample1 {
    static int b ;
    static int a = 3 ;
    static void meth ( int x ){
        System.out.println ( " x = " + x ) ;
        System.out.println ( " a = " + a ) ;
        System.out.println ( " b = " + b ) ;
    }

    static {
        System.out.println ( " Cтaтичecкий блок инициализирован . " ) ;
        b = a * 4 ;
    }
    public static void main (){
        meth(42);
    }
    {
        System.out.println ( " Логический блок инициализирован . " + create ) ;
    }
}