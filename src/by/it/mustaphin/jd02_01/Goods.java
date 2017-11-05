package by.it.mustaphin.jd02_01;

public enum Goods {
    MEAT, OIL, MILK, TEA, NUTS;

    int getPrice() {
        switch (this) {
            case MEAT:
                return 10;
            case OIL:
                return 7;
            case MILK:
                return 5;
            case TEA:
                return 2;
            case NUTS:
                return 1;
            default:
                return 0;
        }
    }
}
