package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Var;
import by.it.shelkovich.calc.VarD;
import by.it.shelkovich.calc.VarM;
import by.it.shelkovich.calc.VarV;

public interface IDiv {
    Var div(VarD v1);
    Var div(VarV v1);
    Var div(VarM v1);
    Var div(Var v1);
}
