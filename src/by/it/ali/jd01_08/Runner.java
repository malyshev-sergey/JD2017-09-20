package by.it.ali.jd01_08;

public class Runner {
    public static void main(String[] args) {
    Catalog catalog = new Catalog();
    catalog.edit();
        System.out.println(catalog.showState());
    catalog.adv();
        System.out.println(catalog.showState());
    catalog.pr();
        System.out.println(catalog.showState());
    }
}
