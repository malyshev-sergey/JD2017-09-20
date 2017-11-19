package by.it.malyshev.calc;

public class VarCreatorVarV extends VarCreator {
    @Override
    public Var factoryMethod(String name) {
        return new VarV(name);
    }

}