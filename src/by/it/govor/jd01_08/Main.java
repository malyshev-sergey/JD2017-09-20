package by.it.govor.jd01_08;

/**
 * Created by User on 09.10.2017.
 */
public class Main {
    public static void main(String[] args) {
BuildingTheater building = new BuildingTheater();
        building.whatNowPlay();
        building.openTheater();
        building.play1();
        building.showState();
        building.play2();
        building.showState();
        building.whatNowPlay();
        building.play3();
        building.showState();
        building.play1("Мелодрама");
        building.closTheater();
        building.play3();
        building.showState();
        building.coolic();
        System.out.println( building.toString());

    }
}
