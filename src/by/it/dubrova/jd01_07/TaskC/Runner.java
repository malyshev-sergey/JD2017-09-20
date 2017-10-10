package by.it.dubrova.jd01_07.TaskC;

public class Runner {
    public static void main(String[] args) {
        Boss b = new Boss();
        b.isEngineer();
        b.isEngineer("Вася");

        IPerson c = new Boss("Андрей", "Попкин");
        c.getName();
        c.getSurname();
        ((AEngineer)c).setAge(64);
        ((Boss)c).isEngineer();


    }
}
