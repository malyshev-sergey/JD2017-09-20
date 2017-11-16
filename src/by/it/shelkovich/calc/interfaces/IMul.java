package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.*;

public interface IMul {
    Var mul(VarD v1);
    Var mul(VarV v1);
    Var mul(VarM v1);
    Var mul(Var v1);
    Var mul(VarS v1);
}
