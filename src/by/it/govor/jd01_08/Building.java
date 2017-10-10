package by.it.govor.jd01_08;

/**
 * Created by User on 09.10.2017.
 */
abstract class Building implements In {
    @Override
    public boolean play1() {
        return true;

    }

    @Override
    public boolean play2() {
        return true;
    }

    @Override
    public boolean play3() {
        return true;
    }

    @Override
    public String whatNowPlay() {
        return null;
    }

    @Override
    public void stopPlay() {

    }

    @Override
    public boolean closTheater() {
        return false;
    }

    @Override
    public boolean openTheater() {
        return false;
    }
}
