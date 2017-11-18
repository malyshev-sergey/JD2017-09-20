package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Vars.*;

public interface ISet {
    Var set(VarD v1);
    Var set(VarV v1);
    Var set(VarM v1);
    Var set(Var v1);
    Var set(VarS v1);
}
