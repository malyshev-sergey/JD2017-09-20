package by.it.malyshev.calc;

public class VarCreatorVarM extends VarCreator {
    @Override
    public Var factoryMethod(String name) {
        return new VarM(name);
    }
}
