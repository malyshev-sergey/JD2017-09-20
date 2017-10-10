package by.it.malyshev.jd01_08;

import java.util.Random;

public abstract class Surgeon implements Doctor {

    private boolean stateDisease;
    private boolean stateCognac;
    private boolean stateRest;
    private boolean stateNeedOperation;
    private boolean stateDiagnose;

    Surgeon() {
        this.stateDisease=false;
        this.stateCognac = false;
        this.stateRest = true;
        this.stateDiagnose=false;
    }

    Surgeon(boolean stateDisease){
        this();
        this.setStateDisease(stateDisease);
    }

    public void setStateDisease(boolean stateDisease) {
        this.stateDisease = stateDisease;
    }

    private static boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public void diagnoseDisease() {
        if (stateDisease) {
            System.out.println("Пациент болен");
            stateDiagnose=true;
            stateRest=false;
        } else {
             System.out.println("Пациент здоров");
             stateDiagnose=false;
             stateRest=true;
        }
    }

    @Override
    public boolean treatDisease() {
        if (stateDiagnose) {
            stateNeedOperation = true;
            System.out.println("Делаю хирургическую операцию");
        } else System.out.println("Хирургическое вмешательство не требуется");
        return stateNeedOperation;

    }

    @Override
    public void writeReport() {
        System.out.println("Пишем отчет");
    }

    @Override
    public void haveARest() {
        if(!stateDisease) {
            stateRest = true;
            System.out.println("Отдыхаю");
            drinkCognac();
        } else System.out.println("Нет отдыха.Есть больной пациент");
    }

    @Override
    public void receiveSalary() {
        System.out.println("Получаю зарплату");
    }

    @Override
    public void receiveCognac() {
        stateCognac = true;
        System.out.println("Получен коньяк в подарок");

    }

    @Override
    public void drinkCognac() {
        if (stateCognac) {
            System.out.println("Пью коньяк");
            stateCognac = false;
        } else System.out.println("Коньяка нет, сижу на воде");

    }
    public boolean makeOperation() {
        boolean res=false;
        if (stateNeedOperation) {
            if (randomBoolean()) {
                System.out.println("Операция прошла удачно.");
                res= true;
             } else {
                System.out.println("Операция прошла неудачно.");
            }
        }
        return res;
    }


    public abstract String showState();

    public boolean isStateDisease() {
        return stateDisease;
    }

    public boolean isStateRest() {
        return stateRest;
    }



}
