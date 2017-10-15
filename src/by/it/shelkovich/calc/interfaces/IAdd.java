package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Var;
import by.it.shelkovich.calc.VarD;
import by.it.shelkovich.calc.VarM;
import by.it.shelkovich.calc.VarV;

public interface IAdd {
    Var add(VarD v1);
    Var add(VarV v1);
    Var add(VarM v1);
    Var add(Var v1);
}
