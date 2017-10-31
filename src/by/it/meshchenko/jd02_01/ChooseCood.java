package by.it.meshchenko.jd02_01;

public class ChooseCood {
    private String good;
    private Double price;

    public ChooseCood(String good, Double price) {
        this.good = good;
        this.price = price;
    }

    public String getGood() {
        return good;
    }

    public Double getPrice() {
        return price;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
