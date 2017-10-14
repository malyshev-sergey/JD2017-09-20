package by.it.meshchenko.calc;

public interface IOperationVisitorDiv {
    Var visitDiv(VarF varF);
    Var visitDiv(VarV varV);
    Var visitDiv(VarM varM);
}
