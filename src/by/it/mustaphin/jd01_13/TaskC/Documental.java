package by.it.mustaphin.jd01_13.TaskC;

import by.it.mustaphin.jd01_13.MyExceptioin;

public class Documental extends AdultOnly implements ISale {
    @Override
    public String director() {
        return null;
    }


    @Override
    public boolean blueray() {
        return true;
    }

    @Override
    public boolean cinema() {
        try {
            throw new MyException("Not for theatre distribution");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean cabelChannel() {
        return true;
    }

    @Override
    public boolean free() {
        try {
            throw new MyException("Not for free access");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return false;
    }
}
