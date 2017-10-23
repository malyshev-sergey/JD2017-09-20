package by.it.shelkovich.calc.Exceptions;

public class MatrixMultiplyException extends ArithmeticException {
    public MatrixMultiplyException(){ super(); }
    public MatrixMultiplyException(String message) {
        super(message);
    }
}
