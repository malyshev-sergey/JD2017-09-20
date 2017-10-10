package by.it.mustaphin.jd01_08;

public abstract class AdultOnly extends Movie implements Productable {

    public AdultOnly() {
        imdb = 0.0;
        desc = "";
    }

    @Override
    public int calcBudget() {
        return 0;
    }

    @Override
    public String[] invatedActors() {
        return null;
    }

    @Override
    public int timeWork() {
        return 1;
    }

    @Override
    public int honorarsTotal() {
        return 0;
    }

    @Override
    public String country() {
        return "Germany";
    }

    @Override
    public String getRights() {
        return "copy rights reserved";
    }

    @Override
    public int ageLimit() {
        return 18;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
