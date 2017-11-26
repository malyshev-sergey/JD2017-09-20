package by.it.dubrova.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.util.Date;
import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new FabricMySQLDriver();

            //регистрируем драйвер
            DriverManager.registerDriver(driver);
            // получаем коннекшн
            connection = DriverManager.getConnection("jdbc:mysql://localhost:2016/dubrova","root","");
            if(!connection.isClosed())
                System.out.println("Конекшн создан!");

            Statement statement = connection.createStatement();
            A_AddUser.add(statement, "sup@mail.ru","Denis","Password999",1);

            // русские буквы не пишутся верно... видимо не указал юникод в создании таблицы
            java.sql.Date date = new java.sql.Date(1);
            A_AddData.add(statement,2,"Заголовок","я продаю мяч",200, date);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
