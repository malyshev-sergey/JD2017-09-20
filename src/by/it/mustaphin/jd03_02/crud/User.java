package by.it.mustaphin.jd03_02.crud;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private int fk_question;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fk_question=" + fk_question +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFk_question() {
        return fk_question;
    }

    public void setFk_question(int fk_question) {
        this.fk_question = fk_question;
    }

    public User(String name, String login, String password, int fk_question) {

        this.name = name;
        this.login = login;
        this.password = password;
        this.fk_question = fk_question;
    }

    public User(int id, String name, String login, String password, int fk_question) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.fk_question = fk_question;
    }

    public User() {

    }
}
