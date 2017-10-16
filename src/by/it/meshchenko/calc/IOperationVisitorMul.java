package by.it.meshchenko.calc;

public interface IOperationVisitorMul {
    Var visitMul(VarF varF);
    Var visitMul(VarV varV);
    Var visitMul(VarM varM);
}
