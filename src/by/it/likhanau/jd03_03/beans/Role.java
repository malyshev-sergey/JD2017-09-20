package by.it.likhanau.jd03_03.beans;


public class Role {
    private int idRole;
    private String role;

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (idRole != role1.idRole) return false;
        return role.equals(role1.role);

    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + role.hashCode();
        return result;
    }

    public int getIdRole() {

        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role() {

    }

    public Role( String role) {

        this.idRole = 0;
        this.role = role;
    }
}
