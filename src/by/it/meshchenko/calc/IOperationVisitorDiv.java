package by.it.meshchenko.calc;

public interface IOperationVisitorDiv {
    Var visitDiv(VarD varD);
    Var visitDiv(VarV varV);
    Var visitDiv(VarM varM);
}
