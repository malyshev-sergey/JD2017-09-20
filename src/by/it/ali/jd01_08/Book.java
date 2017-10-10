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
        edit = true;
        print = false;
    }

    @Override
    public void pr() {
        adv = true;
        edit = false;
        print = true;
    }

    public abstract String showState();
    public boolean isEditing(){return edit;}
    public boolean isAdvertising(){return adv;}
    public boolean isPrinting(boolean print){
        this.print = print;
        return print;}
}



