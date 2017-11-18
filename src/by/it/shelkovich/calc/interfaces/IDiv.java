package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Vars.*;

public interface IDiv {
    Var div(VarD v1);
    Var div(VarV v1);
    Var div(VarM v1);
    Var div(Var v1);
    Var div(VarS v1);
}
