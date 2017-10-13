package by.it.shelkovich.calc;

public class VarV extends Var {
    private double[] value;

    double[] getValue() {
        return value;
    }

    VarV(String value) {
        this(new double[1]);
    }

    VarV(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    VarV(VarV v) {
        this(v.value);
    }

    @Override
    public Var add(VarD v1) {
        System.out.println("сложение вектора с числом");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] + v1.getValue();
        }
        return result;
    }

    @Override
    public Var mul(VarD v1) {
        System.out.println("умножение вектора на число");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] * v1.getValue();
        }
        return result;
    }

    @Override
    public Var sub(VarD v1) {
        System.out.println("разность вектора с числом");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] - v1.getValue();
        }
        return result;
    }

    @Override
    public Var div(VarD v1) {
        System.out.println("деление вектора на число");
        VarV result = new VarV(this);
        for (int i = 0; i < result.value.length; i++) {
            result.value[i] = result.value[i] / v1.getValue();
        }
        return result;
    }


    @Override
    public Var add(VarV v1) {
        System.out.println("сложение вектора с вектором");
        VarV result = new VarV(this);
        if (value.length == v1.value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + v1.value[i];
            }
        } else {
            System.out.println("векторы разной длинны");
            return null;
        }
        return result;
    }

    @Override
    public Var mul(VarV v1) {
        System.out.println("умножение вектора на вектор");
        VarV result = new VarV(this);
        if (value.length == v1.value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] * v1.value[i];
            }
        } else {
            System.out.println("векторы разной длинны");
            return null;
        }
        return result;
    }

    @Override
    public Var sub(VarV v1) {
        System.out.println("разность вектора с вектором");
        VarV result = new VarV(this);
        if (value.length == v1.value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - v1.value[i];
            }
        } else {
            System.out.println("векторы разной длинны");
            return null;
        }
        return result;
    }

    @Override
    public Var defaultOp(String type, Var v, boolean setUsed) {
        if (!v.isUsed()) {
            if (setUsed) used = true;
            if ("add".equals(type)) return v.add(this);
            else if ("mul".equals(type)) return v.mul(this);
            else if ("sub".equals(type)) return v.sub(this);
            else if ("div".equals(type)) return v.div(this);
            return null;
        } else
            v.setUsed(false);
        return null;
    }


}
