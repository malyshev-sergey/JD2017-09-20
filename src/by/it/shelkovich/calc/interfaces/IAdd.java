package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Vars.*;

public interface IAdd {
    Var add(VarD v1);
    Var add(VarV v1);
    Var add(VarM v1);
    Var add(Var v1);
    Var add(VarS v1);

}
