package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Var;
import by.it.shelkovich.calc.VarD;
import by.it.shelkovich.calc.VarM;
import by.it.shelkovich.calc.VarV;

public interface ISub {
    Var sub(VarD v1);
    Var sub(VarV v1);
    Var sub(VarM v1);
    Var sub(Var v1);
}
