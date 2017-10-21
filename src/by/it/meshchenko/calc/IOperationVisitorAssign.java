package by.it.meshchenko.calc;

public interface IOperationVisitorAssign {
    boolean visitAssign(VarF varF);
    boolean visitAssign(VarV varV);
    boolean visitAssign(VarM varM);
}
