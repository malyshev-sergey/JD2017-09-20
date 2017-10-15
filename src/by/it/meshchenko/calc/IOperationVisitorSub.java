package by.it.meshchenko.calc;

public interface IOperationVisitorSub {
    Var visitSub(VarF varF);
    Var visitSub(VarV varV);
    Var visitSub(VarM varM);
}
