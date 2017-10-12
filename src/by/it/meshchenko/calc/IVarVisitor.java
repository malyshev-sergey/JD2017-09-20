package by.it.meshchenko.calc;

interface IVarVisitor {
    Var visitAdd(VarD varD);
    Var visitAdd(VarV varV);
    Var visitAdd(VarM varM);
    Var visitSub(VarD varD);
    Var visitSub(VarV varV);
    Var visitSub(VarM varM);
    Var visitMul(VarD varD);
    Var visitMul(VarV varV);
    Var visitMul(VarM varM);
    Var visitDiv(VarD varD);
    Var visitDiv(VarV varV);
    Var visitDiv(VarM varM);
}
