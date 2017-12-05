package by.it.likhanau.jd03_03.beans;


public class User {
    private int idUser;
    private int idRole;
    private String password;
    private String login;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (idRole != user.idRole) return false;
        if (!password.equals(user.password)) return false;
        return login.equals(user.login);

    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idRole;
        result = 31 * result + password.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }

    public User() {

    }

    public User(String login, String password,  int idRole) {

        this.idUser = 0;
        this.idRole = idRole;
        this.password = password;
        this.login = login;
    }






    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", idRole=" + idRole +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
