package by.it.shelkovich.calc.interfaces;

public interface Patterns {
    //возможные примеры регулярных выражений (конечно лучше составить свои).
    String exName="(([A-Za-z]+[])+)";                       //имена переменных
    String exVal="((-?)([0-9.])+)";                       //числа
    String exVec="\\{((-?([0-9.])+),?)+}";                //вектора
    String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    String exVarAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
    String exAny = "("+exMat+")|("+exVec+")|("+exVal+")|("+exName+")";
    String exOper="[-+*/=]";                               //операция
    String exFull= "[ ]?(?<first>"+exAny+")[ ]?"+
                   "(?<op>" +exOper+")[ ]?"+
                   "(?<second>" +exVarAny +")[ ]?"; //выражение целиком

}
