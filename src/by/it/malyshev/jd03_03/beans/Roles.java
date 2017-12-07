package by.it.malyshev.jd03_03.beans;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "roles", propOrder = {
        "id",
        "role"
})
@XmlRootElement(name = "roles")
public class Roles {

    @XmlElement(name = "id", required = true)
    private int id;
    @XmlElement(name = "role", required = true)
    private String role;

    public Roles() {
    }

    public Roles(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles role1 = (Roles) o;

        if (id != role1.id) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nRoles{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
