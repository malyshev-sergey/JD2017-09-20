package by.it.malyshev.jd03_02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Runner03_02 {

    public static void main(String[] args) throws SQLException {

        System.out.println("Создали базу");
        DbInit.main(null);

        System.out.print("\n\nНажмите ВВОД, чтобы продолжить >");
        getCommandLine();

        System.out.println("\nЗаполняем таблицы данными из xml файлов");
        TaskC.addTableData();

        System.out.print("\n\nНажмите ВВОД, чтобы продолжить >");
        getCommandLine();

        System.out.println("\nВыводим ID ролей по имени");
        TaskA.main(null);

        System.out.println("\n\nПроверяем CRUD операции для таблицы Users");
        TaskA_UserTest.main(null);

        System.out.println("!!!Тестирование CRUD операции для всех таблиц реализовано через JUnit (класс CrudJUnitTests)");

        System.out.print("\n\nНажмите ВВОД, чтобы продолжить >");
        getCommandLine();

        System.out.println("\nВыводим пользователей и их роли на консоль");
        TaskB.main(null);

        System.out.print("\n\nНажмите ВВОД, чтобы продолжить >");
        getCommandLine();

        System.out.println("\nУдалили базу");
        DbReset.main(null);
    }


    private static void getCommandLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}