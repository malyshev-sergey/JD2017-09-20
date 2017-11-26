package by.it.shelkovich.jd3_01;

public class C_Reset {
    static void run(){
        DataBase.exeChangeQuery("DROP TABLE IF EXISTS comments");
        DataBase.exeChangeQuery("DROP TABLE IF EXISTS follow_links");
        DataBase.exeChangeQuery("DROP TABLE IF EXISTS posts");
        DataBase.exeChangeQuery("DROP TABLE IF EXISTS users");
        DataBase.exeChangeQuery("DROP TABLE IF EXISTS roles");
    }
}
