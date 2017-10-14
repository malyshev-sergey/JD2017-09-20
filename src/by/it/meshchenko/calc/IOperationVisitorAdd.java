package by.it.meshchenko.calc;

public interface IOperationVisitorAdd {
    Var visitAdd(VarD varD);
    Var visitAdd(VarV varV);
    Var visitAdd(VarM varM);
}
