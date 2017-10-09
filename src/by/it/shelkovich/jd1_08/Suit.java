package by.it.shelkovich.jd1_08;

class Suit extends AbstractClothes {
    public Suit(){
        super("Костюм");
    }

    @Override
    public void wash(){
        System.out.printf("%s отправлен в химчистку\n", getName());
        setDirty(false);
    }

    @Override
    public void repair() {
        super.repair("Серый");
    }

}
