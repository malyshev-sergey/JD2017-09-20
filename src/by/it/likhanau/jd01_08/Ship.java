package by.it.likhanau.jd01_08;

/**
 * Created by NotePad.by on 22.10.2017.
 */
public interface Ship {
    void stop();
    void move();
    void startEngine();
    void stopEngine();
    void addWeapons();
    void addWeapons(String weapon);
    void makeSignal();
}
