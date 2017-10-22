package by.it.malyshev.jd01_08;

import java.util.Random;

public class NeuroSurgeon extends Surgeon {
    private boolean stateSquareHead;
    private boolean twoManyThoughts;

    public NeuroSurgeon() {
        super();
        super.setDoctorName("Нейрохирург_" + randomInt());
        this.stateSquareHead = false;
        this.twoManyThoughts = false;
    }

    public NeuroSurgeon(String doctorName, boolean stateDisease, boolean stateSquareHead, boolean twoManyThoughts) {
        this();
        super.setDoctorName(doctorName);
        super.setStateDisease(stateDisease);
        this.stateSquareHead = stateSquareHead;
        this.twoManyThoughts = twoManyThoughts;
    }

    public void setStateSquareHead(boolean stateSquareHead) {
        this.stateSquareHead = stateSquareHead;
        if (this.stateSquareHead || this.twoManyThoughts) {
            super.setStateDisease(true);
        } else {
            super.setStateDisease(false);
        }
    }

    public void setTwoManyThoughts(boolean twoManyThoughts) {
        this.twoManyThoughts = twoManyThoughts;
        if (this.twoManyThoughts || this.stateSquareHead) {
            super.setStateDisease(true);
        } else {
            super.setStateDisease(false);
        }
    }

    @Override
    public boolean treatDisease() {
        boolean res = false;
        if (super.treatDisease() && (stateSquareHead || twoManyThoughts)) {
            System.out.println("Нужно исправить мозг");
            res = true;
        } else if (isStateNeedOperation()) {
            System.out.println("Вам нужен хирург другого профиля");
            this.setStateDisease(false);
        }
        return res;
    }

    @Override
    public int makeOperation() throws MedicalOperationException {
        int res = 0;
        try {
            int temp = super.makeOperation();
            if (temp == 0) {
                res = 0;
            } else if (temp == 1) {
                if (twoManyThoughts && !stateSquareHead) {
                    System.out.println("Пациент скорее жив. Все извилины выпрямлены");
                    res = 1;
                }
                if (stateSquareHead && !twoManyThoughts) {
                    System.out.println("Пациент скорее жив. Сделана лоботомия");
                    res = 2;
                }
                if (stateSquareHead && twoManyThoughts) {
                    System.out.println("Пациент скорее жив. Мозг успешно удален");
                    res = 3;
                }
                this.receiveCognac();

            }
        } catch (MedicalOperationException e){
            throw e;
        }

//        else if (temp == 2) {
//            System.out.println("Пациент скорее мертв");
//            res = 4;
//        }
        return res;
    }

    @Override
    public void makeOperationWithExcCatch(){
        try {
            makeOperation();
        } catch (MedicalOperationException e){
            System.out.println(e.getMessage()+" Пациент скорее мертв!");
        }
    }

    @Override
    public String showState() {
        String state = "";
        if (this.isStateNeedOperation() || this.isStateDiagnose() || this.isStateDisease()) {
            state = "Нейрохирург работает";
        } else if (this.isStateRest()) {
            state = "Нейрохирург отдыхает";
        }
        return state;
    }

    private int randomInt() {
        Random random = new Random();
        return random.nextInt(999) + 1;
    }


}



