package by.it.shelkovich.calc.interfaces;

import by.it.shelkovich.calc.Var;
import by.it.shelkovich.calc.VarD;
import by.it.shelkovich.calc.VarM;
import by.it.shelkovich.calc.VarV;

public interface IMul {
    Var mul(VarD v1);

    Var mul(VarV v1);

    Var mul(VarM v1);

    Var mul(Var v1);
}
