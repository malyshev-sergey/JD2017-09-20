package by.it.shelkovich.jd1_08;

public class Runner_08 {

    public static void main(String[] args) {
        AbstractClothes clothes = new Suit();
        clothes.wear();
        clothes.repair();
        clothes.recycle(true);
    }

}
