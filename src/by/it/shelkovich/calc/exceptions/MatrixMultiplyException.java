package by.it.shelkovich.calc.exceptions;

public class MatrixMultiplyException extends ArithmeticException {
    public MatrixMultiplyException(){ super(); }
    public MatrixMultiplyException(String message) {
        super(message);
    }
}
