package by.it.akhmelev.calc;

class MathException extends Exception{
    MathException(String msg) {
        super("error:"+msg);
    }
}
