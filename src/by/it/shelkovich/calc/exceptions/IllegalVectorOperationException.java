package by.it.shelkovich.calc.exceptions;

public class IllegalVectorOperationException extends ArithmeticException {

    public IllegalVectorOperationException(){ super(); }
    public IllegalVectorOperationException(String message) {
        super(message);
    }

}
