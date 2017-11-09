package by.it.shelkovich.jd2_03;

public class Product {
    private final String name;
    private final int price;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    String getName(){
        return name;
    }

    int getPrice(){
        return price;
    }

    public String toString(){
        return name+" ("+price+"р.)";
    }
}
