package by.it.dubrova.jd01_07.TaskC;

public class Boss extends AEngineer {

    @Override
    public void getName() {
        System.out.println("Имя: "+super.name);
    }

    @Override
    public void getSurname() {
        System.out.println("Фамилия: "+super.surname);
    }

    @Override
    public void getAge() {
        System.out.println("Возраст: "+super.age);
    }

    @Override
    public void getSex() {
        if (super.sex)
            System.out.println("Пол: Мужской");
        else   System.out.println("Пол: Женский");

    }

    @Override
    public void getAddress() {
        System.out.println("Адрес: "+super.address);
    }

    @Override
    public void getTelephoneNumber() {
        System.out.println("Телефонный номер: "+super.telephoneNumber);
    }

    @Override
    public void getExpirence() {
        System.out.println("Опыт: "+super.expirence);
    }

    @Override
    public void isEngineer(){
        System.out.println("Дейсвительно Инженер! Перегруженный метод");
    }

// нужно ли тут ставить аннотацию????
    public void isEngineer(String name){
        super.name = name;
        System.out.println("Дейсвительно Инженер! Перегруженный метод. Его зовут: " + super.name);
    }

    Boss(){
        //перегрузка чтобы не было ошибки, при вызове без параметров
    }
    Boss(String name,String surname){
        super(name, surname);
    }
}
