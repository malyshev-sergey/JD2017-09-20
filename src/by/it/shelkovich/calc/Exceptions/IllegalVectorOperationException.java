package by.it.shelkovich.calc.Exceptions;

public class IllegalVectorOperationException extends ArithmeticException {

    public IllegalVectorOperationException(){ super(); }
    public IllegalVectorOperationException(String message) {
        super(message);
    }

}
