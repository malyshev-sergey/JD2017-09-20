package by.it.shelkovich.jd1_08;

public interface Fabric {
    void wash();
    void wear();
    void wear(boolean washBefore);
    void repair();
    void repair(String color);
    void recycle();
    void recycle(boolean washBefore);
}
