package by.it.meshchenko.calc;

public class OperationCore {
    // Объявляем методы операций для различных типов переменных
    // Правило именования методов:
    // add_DD - сложение двух скалярных типов, _DD - единственный метод
    // add_D_V - сложение скаляра с вектором, _D_V - будет вызываться как D+V, так и для V+D

    // Add: VarD + VarD
    public static Var add_DD(VarD v1, VarD v2){
        return new VarD(v1.getValue() + v2.getValue());
    }
    // Add: VarD + VarV  <--> VarV + VarD
    public static Var add_D_V(VarD v1, VarV v2){
        VarV result = new VarV(v2.getValue());
        double[] resultVal = result.getValue();
        double operand2 = v1.getValue();
        for (int i = 0; i < resultVal.length; i++) {
            resultVal[i] += operand2;
        }
        return result;
    }

    // Add: VarD + VarM <---> VarM + VarD
    public static Var add_D_M(VarD v1, VarM v2){
        VarM result = new VarM(v2.getValue());
        double[][] resultVal = result.getValue();
        double operand2 = v1.getValue();
        for (int i = 0; i < resultVal.length; i++) {
            for (int j = 0; j < resultVal[i].length; j++) {
                resultVal[i][j] += operand2;
            }
        }
        return result;
    }
    // Add: VarV + VarM

    // Add: VarM + VarV

    // Add: VarM + VarM

    // Div: VarD / VarD

    // Div: VarV / VarD

    // Div: VarM / VarD

    // Mul: VarD * VarD

    // Mul: VarD * VarV <---> VarV * VarD

    // Mul: VarD * VarM <---> VarM * VarD

    // Mul: VarV * VarV

    // Mul: VarV * VarM

    // Mul: VarM * VarV

    // Mul: VarM * VarM

    // Sub: VarD - VarD

    // Sub: VarV - VarD

    // Sub: VarM - VarD

    // Sub: VarV - VarV
}
