package by.it.meshchenko.calc;

public interface IOperationVisitorMul {
    Var visitMul(VarD varD);
    Var visitMul(VarV varV);
    Var visitMul(VarM varM);
}
