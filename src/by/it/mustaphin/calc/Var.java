package by.it.mustaphin.calc;

abstract class Var implements MathOperations, Variable {

    StoreData storeData = new StoreData();
    String varName;

    @Override
    public Var add(Var var) {
//        System.out.println("Сложение не возможно");
        return null;
    }

    @Override
    public Var sub(Var var) {
//        System.out.println("Вычитние не возможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
//        System.out.println("Умножение не возможно");
        return null;
    }

    @Override
    public Var div(Var var) {
//        System.out.println("Деление не возможно");
        return null;
    }

    @Override
    public void assignment(String name, Var var) {
        storeData.store(name, var);
    }
}
