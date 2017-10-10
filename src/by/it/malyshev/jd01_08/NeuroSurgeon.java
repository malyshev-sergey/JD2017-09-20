package by.it.malyshev.jd01_08;

public class NeuroSurgeon extends Surgeon {
    private boolean stateSquareHead;
    private boolean twoManyThoughts;

    NeuroSurgeon() {

    }

    NeuroSurgeon(boolean stateDisease) {
        super();
        super.setStateDisease(stateDisease);
    }



    public boolean treatDisease() {
        if (super.treatDisease()) System.out.println("Нужно удалить мозг");
        return true;
    }

    public boolean makeOperation() {
        boolean res;
        if (super.makeOperation()) {
            if (twoManyThoughts) {
                System.out.println("Пациент скорее жив. Все извилины выпрямлены.");
            }
            if (stateSquareHead) {
                System.out.println("Пациент скорее жив. Сделана лоботомия.");
            }
            res=true;
        } else {
            System.out.println("Пациент скорее мертв");
            res=false;
        }
        return res;
    }

    @Override
    public String showState() {
        String state = "Нейрохирург";
        return state;
    }


}



