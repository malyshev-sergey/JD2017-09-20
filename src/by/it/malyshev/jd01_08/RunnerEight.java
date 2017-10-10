package by.it.malyshev.jd01_08;

public class RunnerEight {

    public static void main(String[] args) {

        NeuroSurgeon neuroSurgeonA = new NeuroSurgeon();
        neuroSurgeonA.setStateDisease(true);
//        System.out.println(neuroSurgeon.showState());
        neuroSurgeonA.diagnoseDisease();
//        System.out.println(neuroSurgeon.showState());
        neuroSurgeonA.treatDisease();
//        System.out.println(neuroSurgeon.showState());
        neuroSurgeonA.makeOperation();
        neuroSurgeonA.receiveSalary();


        Surgeon neuroSurgeonB=new NeuroSurgeon(true);
        neuroSurgeonA.receiveSalary();

    }
}
