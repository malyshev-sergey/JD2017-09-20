package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public class ADD extends Var implements IOperations {

    //Сложение числа с числом
    public Var add(VarD v1, VarD v2) {
        return new VarD(v1.getValue() + v2.getValue());
    }

    //Сложение числа с вектором
    public Var add(VarD v1, VarV v2) {
        for (int i = 0; i < v2.getValue().length; i++)
            v2.getValue()[i] += v1.getValue();
        return v2;
    }

    //Сложение числа с матрицей
    public Var add(VarD v1, VarM v2) {
        new CalcError("Сумма числа и матрицы");//получаем абстрактную сумму
        return null;
    }

    //Сложение вектора с числом
    public Var add(VarV v1, VarD v2) {
        return new ADD().add(v2, v1);
    }

    //Сложение вектора с вектором
    public Var add(VarV v1, VarV v2) {
        for (int i = 0; i < v1.getValue().length; i++)
            v1.getValue()[i] += v2.getValue()[i];
        return v1;
    }

    //Сложение матрицы с числом
    public Var add(VarM v1, VarD v2) {
        return new ADD().add(v2, v1);
    }//отправляем к сложению числа и матрицы

    //Сложение матриц
    public Var add(VarM v1, VarM v2) {
        new CalcError("Сумма матриц");
        return null;
    }
}
