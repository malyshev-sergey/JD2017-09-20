package by.it.shelkovich.calc.Vars;

public class VarS extends Var {
    String name;
    VarS(String name){
        this.name = name;
    }

    public Var getValue(){
        return VarStorage.get(name);
    }

    @Override
    public void setFrom(String str) {
        this.name = str;
    }

    public String toString(){
        return name;
    }

    @Override
    public Var set(VarD v1) {
        VarStorage.put(name, v1);
        return v1;
    }

    @Override
    public Var set(VarV v1) {
        VarStorage.put(name, v1);
        return v1;
    }

    @Override
    public Var set(VarM v1) {
        VarStorage.put(name, v1);
        return v1;
    }

    @Override
    public Var set(VarS v1) {
        VarStorage.put(name, v1);
        return v1.getValue();
    }

    @Override
    public Var div(VarD v1) {
        return VarStorage.get(name).div(v1);
    }
    @Override
    public Var div(VarV v1) {
        return VarStorage.get(name).div(v1);
    }
    @Override
    public Var div(VarM v1) {
        return VarStorage.get(name).div(v1);
    }
    @Override
    public Var div(VarS v1) {
        return VarStorage.get(name).div(v1.getValue());
    }


    @Override
    public Var mul(VarD v1) {
        return VarStorage.get(name).mul(v1);
    }
    @Override
    public Var mul(VarV v1) {
        return VarStorage.get(name).mul(v1);
    }
    @Override
    public Var mul(VarM v1) {
        return VarStorage.get(name).mul(v1);
    }
    @Override
    public Var mul(VarS v1) {
        return VarStorage.get(name).mul(v1.getValue());
    }

    @Override
    public Var sub(VarD v1) {
        return VarStorage.get(name).sub(v1);
    }
    @Override
    public Var sub(VarV v1) {
        return VarStorage.get(name).sub(v1);
    }
    @Override
    public Var sub(VarM v1) {
        return VarStorage.get(name).sub(v1);
    }
    @Override
    public Var sub(VarS v1) {
        return VarStorage.get(name).sub(v1.getValue());
    }


    @Override
    public Var add(VarD v1) {
        return VarStorage.get(name).add(v1);
    }
    @Override
    public Var add(VarV v1) {
        return VarStorage.get(name).add(v1);
    }
    @Override
    public Var add(VarM v1) {
        return VarStorage.get(name).add(v1);
    }
    @Override
    public Var add(VarS v1) {
        return VarStorage.get(name).add(v1.getValue());
    }


    @Override
    public Var defaultOp(String type, Var v, boolean setUsed){
        if (!v.isUsed()) {
            if (setUsed) used = true;
            if("add".equals(type)) return v.add(this);
            else if ("mul".equals(type)) return v.mul(this);
            else if ("sub".equals(type)) return v.sub(this);
            else if ("div".equals(type)) return v.div(this);
            else if ("set".equals(type)) return v.set(this);
            return null;
        } else
            v.setUsed(false);
        return null;
    }
}
