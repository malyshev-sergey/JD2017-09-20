package by.it.malyshev.calc;

public class VarCreatorVarD extends VarCreator {
    @Override
    public Var factoryMethod(String name) {
        return new VarD(name);
    }

}
