package by.it.shelkovich.jd1_13;

public class RussianRoulette implements Riskable {

    @Override
    public int riskyMethod() throws DeadException {
        System.out.println("Крутим барабан!");
        if(Math.round(Math.random()*5)+1 == 1) throw new DeadException("Летальный выстрел в голову!");
        System.out.println("Вы подняли свою крутизну на 5 баллов!");
        return 5;
    }
}
