package by.it.likhanau.jd02_10;


public class POJOClass {
    public POJOClass(int number, String string) {
        this.number = number;
        this.string = string;
    }

    private int number;
    private String string;

    @Override
    public String toString() {
        return "POJOClass{" + "number=" + number + ", string='" + string + '\'' + '}';
    }
}
