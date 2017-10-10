package by.it.dubrova.jd01_07.TaskC;

public abstract class AEngineer implements IPerson {
    protected String name;
    protected String surname;
    protected int age;
    protected boolean sex;
    protected String address;
    protected String telephoneNumber;
    protected String expirence;

    public abstract void getName();
    public abstract void getSurname();
    public abstract void getAge();
    public abstract void getSex();
    public abstract void getAddress();
    public abstract void getTelephoneNumber();
    public abstract void getExpirence();

    public void setName(String name){
        this.name = name;
    };
    public void setSurname(String surname){
        this.surname = surname;
    };
    public void setAge(int age){
        this.age = age;
    };
    public void setSex(boolean sex){
        this.sex = sex;
    };
    public void setAddress(String address){
        this.address = address;
    }
    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    };
    public void setExpirence(String expirence){
        this.expirence = expirence;
    }

    public void isEngineer(){
        System.out.println("Дейсвительно Инженер!");
    };
    public void isWorked(){
        System.out.println("Дейсвительно Работал!");
    };

    AEngineer(){
        this.name = "Петя";
        this.surname = "Пупкин";
        this.address = "Скрыганова 4А";
        this.age = 29;
        this.expirence = "2 года";
        this.sex = true;
        this.telephoneNumber = "102";

    }
    AEngineer(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
}
