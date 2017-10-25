package by.it.ali.calculator;

interface Patterns {
    String exVal="((-?)([0-9.])+)";                       //числа
    String exVec="\\{((-?([0-9.])+),?)+}";                //вектора
    String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
    String exOper="[-+*/=]";                               //операция
    String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")"; //выражение целиком
}