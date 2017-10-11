package by.it.ali.jd01_08;

public abstract class Book implements Izdan {
    private boolean adv = true;
    private boolean edit = true;
    public boolean print = false;


    @Override
    public void edit() {
        adv = false;
        edit = true;
        print = false;
    }

    @Override
    public void adv() {
        adv = true;
        edit = false;
        print = false;
    }

    @Override
    public void pr() {
        adv = false;
        edit = false;
        print = true;
    }

    public abstract String showState();
    boolean isEditing(){return edit;}
    boolean isAdvertising(){return adv;}
    boolean isPrinting(){ return print;}
}



