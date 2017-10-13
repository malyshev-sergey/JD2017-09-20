package by.it.shelkovich.calc;

public class VarM extends Var {
    private double[][] value;

    double[][] getValue() {
        return value;
    }

    VarM(String value) {
        //this.value = Double.parseDouble(value);
    }

    VarM(double[][] value) {
        this.value = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = new double[value[i].length];
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    VarM(VarM v) {
        this(v.value);
    }

    public VarM add(VarD arg) {
        System.out.println("сложение матрицы с числом");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] + arg.getValue();
            }
        }
        return result;
    }

    public VarM mul(VarD arg) {
        System.out.println("Умножение матрицы на число");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] * arg.getValue();
            }
        }
        return result;
    }

    public VarM sub(VarD arg) {
        System.out.println("Разность матрицы с числом");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] - arg.getValue();
            }
        }
        return result;
    }

    public VarM div(VarD arg) {
        System.out.println("Деление матрицы на число");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] / arg.getValue();
            }
        }
        return result;
    }

    public VarV mul(VarV arg) {
        System.out.println("Умножение матрицы на вектор");
        VarV result;

        if (this.value[0].length == arg.getValue().length) {
            double argArray[] = new double[arg.getValue().length];
            result = new VarV(new double[this.value[0].length]);
            for (int i = 0; i < this.value.length; i++) {
                double res = 0;
                for (int j = 0; j < this.value[i].length; j++) {
                    res = res + this.value[i][j] * argArray[j];
                }
            }
        } else {
            System.out.println("Число столбцов матрицы не соответствует числу элементов в векторе!");
            result = null;
        }

        return result;
    }


    public VarM add(VarM arg) {
        System.out.println("сложение матрицы с матрицей");
        VarM result = new VarM(this);
        for (int i = 0; i < result.value.length; i++) {
            for (int j = 0; j < result.value[i].length; j++) {
                result.value[i][j] = result.value[i][j] + arg.value[i][j];
            }
        }
        return result;
    }

    public VarM mul(VarM arg) {
        System.out.println("Умножение матрицы на матрицу");
        VarM result;

        if (this.value[0].length == arg.value.length) {
            result = new VarM(new double[this.value.length][arg.value[0].length]);

            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < arg.value[i].length; j++) {
                    double res = 0;
                    for (int k = 0; k < arg.value.length; k++) {
                        res = res + this.value[i][k] * arg.value[k][j];
                    }
                    result.value[i][j] = res;
                }
            }
        } else {
            System.out.println("Число столбцов в первой матрице не соответствует числу строк во второй!");
            result = null;
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
