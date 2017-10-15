package by.it.meshchenko.calc;

public interface IOperationVisitorAdd {
    Var visitAdd(VarF varF);
    Var visitAdd(VarV varV);
    Var visitAdd(VarM varM);
}
