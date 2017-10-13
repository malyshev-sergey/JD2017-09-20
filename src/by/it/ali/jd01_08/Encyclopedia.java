package by.it.ali.jd01_08;

public class Encyclopedia  extends Book {

    @Override
    public void edit() {
        System.out.println("Энциклопедия редактируется");
    }

    @Override
    boolean isAdvertising() {
        System.out.println("Энциклопедия демонстрируется в учебных заведениях");
        return super.isAdvertising();
    }

    @Override
    public void pr() {
        System.out.println("Энциклопедия издаётся");
    }

    @Override
    public String showState() {
        return null;
    }
}
