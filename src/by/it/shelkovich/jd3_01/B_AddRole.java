package by.it.shelkovich.jd3_01;

public class B_AddRole {
    static void run(){
        DataBase.exeChangeQuery("INSERT INTO roles (role) VALUES ('Администратор')");
        DataBase.exeChangeQuery("INSERT INTO roles (role) VALUES ('Модератор')");
        DataBase.exeChangeQuery("INSERT INTO roles (role) VALUES ('Пользователь')");
    }
}
