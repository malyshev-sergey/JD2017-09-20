package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Vars.*;

public interface ISub {
    Var sub(VarD v1);
    Var sub(VarV v1);
    Var sub(VarM v1);
    Var sub(Var v1);
    Var sub(VarS v1);
}
