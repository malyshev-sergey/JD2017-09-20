package by.it.meshchenko.calc;

public interface IOperationVisitorSub {
    Var visitSub(VarD varD);
    Var visitSub(VarV varV);
    Var visitSub(VarM varM);
}
