package by.it.mustaphin.jd01_08;

public abstract class Movie implements Productable {

    protected String name;

    protected int year;

    protected int duration;//minutes

    protected double imdb;

    protected String desc;

    @Override
    public String toString() {
        return String.format("Название: %-12s, год: %-4d, рейтинг: %-2.2g, продолжительность: %-3d минут", name, year, imdb, duration);
    }
}
