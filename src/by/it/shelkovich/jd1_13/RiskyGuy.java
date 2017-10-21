package by.it.shelkovich.jd1_13;

public class RiskyGuy {
    private String name;
    private Riskable risk;
    private int badAssLevel = 0;

    public String getName(){
        return name;
    }

    public RiskyGuy(String name, Riskable risk) {
        this.risk = risk;
        this.name = name;
    }

    public void setRisk(Riskable risk){
        this.risk = risk;
    }

    public void attemptRisk() throws DeadException {
        badAssLevel += risk.riskyMethod();
        System.out.println(name + ": Ха-ха, теперь у меня " + badAssLevel + " уровень крутизны!");
    }

}
