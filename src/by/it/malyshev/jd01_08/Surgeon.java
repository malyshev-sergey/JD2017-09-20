package by.it.malyshev.jd01_08;

import java.util.Random;

public abstract class Surgeon implements IDoctor {

    private boolean stateDisease;
    private boolean stateCognac;
    private boolean stateRest;
    private boolean stateNeedOperation;
    private boolean stateDiagnose;
    private String doctorName;

    Surgeon() {
        this.stateDisease = false;
        this.stateCognac = false;
        this.stateRest = true;
        this.stateDiagnose = false;
        this.doctorName = "Хирург";
    }

    void setStateDisease(boolean stateDisease) {
        this.stateDisease = stateDisease;
        this.stateRest = false;
        this.stateDiagnose = false;
        this.stateNeedOperation = false;
    }

    void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }


    @Override
    public void diagnoseDisease() {
        if (this.stateDisease) {
            System.out.println("Пациент болен");
            this.stateDiagnose = true;
            this.stateRest = false;
            this.stateNeedOperation = false;
        } else {
            System.out.println("Пациент здоров");
            this.stateDiagnose = false;
            this.stateRest = true;
            this.stateNeedOperation = false;
        }
    }

    @Override
    public boolean treatDisease() {
        if (this.stateDiagnose) {
            this.stateNeedOperation = true;
            System.out.println("Нужна хирургическая операция");
        } else {
            System.out.println("Сперва нужен диагноз");
        }
        return stateNeedOperation;

    }

    @Override
    public void writeReport() {
        System.out.println("Пишу отчет");
    }

    @Override
    public void haveARest() {
        if (!this.stateDisease) {
            this.stateRest = true;
            System.out.println("Отдыхаю");
            drinkCognac();
        } else System.out.println("Нет отдыха.Есть больной пациент");
    }

    @Override
    public String getDoctorName() {
        return this.doctorName;
    }

    @Override
    public void receiveCognac() {
        this.stateCognac = true;
        System.out.println("Получен коньяк в подарок");

    }

    @Override
    public void drinkCognac() {
        if (this.stateDisease) {
            System.out.println("Нет, не пью на работе");
        } else if (this.stateCognac) {
            System.out.println("Пью коньяк");
            this.stateCognac = false;
        } else System.out.println("Коньяка нет, сижу на воде");

    }

    public int makeOperation() {
        int res = 0;
        if (!this.stateNeedOperation) {
            System.out.println("Пациенту не назначена операция");
        } else if (randomBoolean()) {
            System.out.println("Операция прошла удачно.");
            res = 1;
        } else {
            System.out.println("Операция прошла неудачно.");
            res=2;
        }
        this.stateDisease = false;
        this.stateNeedOperation = false;
        this.stateDiagnose = false;
        this.stateRest = true;
        return res;
    }


    public abstract String showState();

    boolean isStateRest() {
        return this.stateRest;
    }

    boolean isStateDisease() {
        return this.stateDisease;
    }

    boolean isStateDiagnose() {
        return this.stateDiagnose;
    }

    boolean isStateNeedOperation() {
        return this.stateNeedOperation;
    }

    private boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }


}
