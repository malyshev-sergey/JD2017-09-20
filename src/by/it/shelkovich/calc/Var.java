package by.it.shelkovich.calc;

import by.it.shelkovich.calc.interfaces.*;

public abstract class Var implements IAdd, IMul, ISub, IDiv, StringCompatible {
    protected boolean used = false;

    protected boolean printed = false;

    boolean isUsed() {
        return used;
    }

    void setUsed(boolean used) {
        this.used = used;
    }

    Var getVar() {
        return this;
    }

    void printErr(String err) {
        if (!printed && !used) {
            System.out.printf("Операция %s невозможна\n", err);
            printed = true;
        } else if (printed) printed = false;
    }

    /**
     * Ключевой метод класса. Действует в связке с defaultOp, перекрытым в классе-наследнике. Вызывается по-умолчанию, у всех перегруженных методов для того, чтобы попытаться найти реализацию
     * арифметического действия в классе-аргументе (только для операций умножения и сложения). Если тип аргумента не известен, то при помощи метода recall вызывает метод defaultOp не сам, а просит это сделать
     * класс-аргумент, который знает, какого он типа и может вызвать перегруженный метод. Итого: если арифметическая операция реализована в потомке, то не вызывается вообще. Если не реализована, то проверяет,
     * нет ли реализации в аргументе. Если тип аргумента не известен, то сначала определяет тип, потом смотрит, есть ли реализация, если нет, то смотрит в потомке.
     *
     * @param type Тип выполняемой арифмитической задачи (add, mul, sub, div)
     * @param errType Арифмитическая операция прописью в винительном падеже что ли
     * @param v класс-аргумент арифметичекой операции
     * @param recall нужно ли предварительно определить тип аргумента
     * @param swapable можно ли менять вызывающий класс и класс-аргумент местами в арифметической операции без изменения результата операции
     * @return возвращает объект типа Var
     */
    private Var defaultWrap(String type, String errType, Var v, boolean recall, boolean swapable) {
        Var result;
        if (!recall) {
            if (swapable)
                result = defaultOp(type, v, true);
            else result = null;
        } else result = recall(type, v);
        used = false;
        if (result != null) {
            return result;
        } else {
            printErr(errType);
            return null;
        }
    }

    Var defaultOp(String type, Var v, boolean setUsed) {
        return null;
    }


    public Var recall(String op, Var v) {
        return v.defaultOp(op, this, false);
    }

    //########################################.Сложение.##################################################

    @Override
    public Var add(VarD v1) {
        return defaultWrap("add", "сложения", v1, false, true);
    }

    @Override
    public final Var add(Var v1) {
        return defaultWrap("add", "сложения", v1, true, true);
    }

    @Override
    public Var add(VarV v1) {
        return defaultWrap("add", "сложения", v1, false, true);
    }

    @Override
    public Var add(VarM v1) {
        return defaultWrap("add", "сложения", v1, false, true);
    }


    //########################################.Умножение.##################################################
    @Override
    public Var mul(VarD v1) {
        return defaultWrap("mul", "умножения", v1, false, true);
    }

    @Override
    public final Var mul(Var v1) {
        return defaultWrap("mul", "умножения", v1, true, true);
    }

    @Override
    public Var mul(VarV v1) {
        return defaultWrap("mul", "умножения", v1, false, true);
    }

    @Override
    public Var mul(VarM v1) {
        return defaultWrap("mul", "умножения", v1, false, true);
    }

    //########################################.Разность.##################################################
    @Override
    public Var sub(VarD v1) {
        return defaultWrap("sub", "разности", v1, false, false);
    }

    @Override
    public final Var sub(Var v1) {
        return defaultWrap("sub", "разности", v1, true, false);
     }

    @Override
    public Var sub(VarV v1) {
        return defaultWrap("sub", "разности", v1, false, false);
    }

    @Override
    public Var sub(VarM v1) {
        return defaultWrap("sub", "разности", v1, false, false);
    }

    //########################################.Деление.##################################################
    @Override
    public Var div(VarD v1) {
        return defaultWrap("div", "деления", v1, false, false);
    }

    @Override
    public final Var div(Var v1) {
        return defaultWrap("div", "деления", v1, true, false);
     }

    @Override
    public Var div(VarV v1) {
        return defaultWrap("div", "деления", v1, false, false);
    }

    @Override
    public Var div(VarM v1) {
        return defaultWrap("div", "деления", v1, false, false);
    }

}
