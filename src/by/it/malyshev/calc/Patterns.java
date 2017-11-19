package by.it.malyshev.calc;

interface Patterns {
    String exVal = "((-?)([0-9.])+)";                       //числа
    String exVec = "\\{((-?([0-9.])+),?)+}";                //вектора
    String exMat = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    String exOper = "(?<=[^+-/*=,{])[-+*/=]";                               //операция
    String exVar = "[A-Za-z][A-Za-z0-9]*";
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
//    String exFull= "("+exAny+")"+
//            "(" +exOper+")"+
//            "(" +exAny +")"; //выражение целиком

}