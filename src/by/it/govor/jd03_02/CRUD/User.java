package by.it.govor.jd03_02.CRUD;


public class User {  private int ID;
    private String Name;
    private String Nick;
    private int Telephone;
    private int role_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (Telephone != user.Telephone) return false;
        if (role_ID != user.role_ID) return false;
        if (Name != null ? !Name.equals(user.Name) : user.Name != null) return false;
        return Nick != null ? Nick.equals(user.Nick) : user.Nick == null;

    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Nick='" + Nick + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", role_ID=" + role_ID +
                '}';
    }



    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Nick != null ? Nick.hashCode() : 0);
        result = 31 * result + Telephone;
        result = 31 * result + role_ID;
        return result;
    }

    public User(int ID, String name, String nick, int telephone, int role_ID) {
        this.ID = ID;
        Name = name;
        Nick = nick;
        Telephone = telephone;
        this.role_ID = role_ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public void setTelephone(int telephone) {
        this.Telephone=telephone;
    }

    public void setRole_ID(int role_ID) {
        this.role_ID = role_ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getNick() {
        return Nick;
    }

    public int getTelephone() {
        return Telephone;
    }

    public int getRole_ID() {
        return role_ID;
    }
}
