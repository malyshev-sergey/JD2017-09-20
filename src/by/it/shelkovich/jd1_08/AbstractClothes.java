package by.it.shelkovich.jd1_08;

public abstract class AbstractClothes implements Fabric {
    private String name;
    private boolean isDirty;

    public AbstractClothes(String name) {
        isDirty = false;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected boolean isDirty() {
        return isDirty;
    }

    void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public void wash() {
        System.out.printf("%s был закинут в стиральную машину.\n", name);
    }

    public void repair() {
        repair("красный");
    }

    public void repair(String color) {
        System.out.printf("%s был зашит нитками с цветом %s\n", name, color);
    }

    public void wear() {
        wear(false);
    }

    public void wear(boolean washBefore) {
        if (washBefore && isDirty) wash();
        System.out.printf("%s был надет\n", name);
        isDirty = true;
    }

    public void recycle() {
        recycle(false);
    }

    public void recycle(boolean washBefore) {
        if (washBefore && isDirty) wash();
        System.out.printf("%s был выкинут в мусор\n", name);
    }
}
