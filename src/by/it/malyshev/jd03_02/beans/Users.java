package by.it.malyshev.jd03_02.beans;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "users", propOrder = {
        "id",
        "login",
        "password",
        "email",
        "roles_Id"
})
public class Users {

    @XmlElement(name = "id", required = true)
    private int id;
    @XmlElement(name = "login", required = true)
    private String login;
    @XmlElement(name = "password", required = true)
    private String password;
    @XmlElement(name = "email", required = true)
    private String email;
    @XmlElement(name = "roles_Id", required = true)
    private int roles_Id;

    public Users() {
    }

    public Users(int id, String login, String password, String email, int roles_Id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_Id = roles_Id;
    }

    public Users(String login, String password, String email, int roles_Id) {
        this.id = 0;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_Id = roles_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoles_Id() { return roles_Id; }

    public void setRoles_Id(int roles_Id) {
        this.roles_Id = roles_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (roles_Id != users.roles_Id) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + roles_Id;
        return result;
    }

    @Override
    public String toString() {
        return "\nUsers{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_ID=" + roles_Id +
                '}';
    }
}
