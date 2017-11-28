package by.it.meshchenko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddData {
    public static void main(String[ ] args) {
//        //наболее надежный способ загрузки драйвера
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error loading driver: " + e);
//        }
//        //второй способ загрузки драйвера
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {e.printStackTrace();}
        //в некоторых случаях можно вообще ничего не загружать
        // (например при запуске в IDEA)
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            // addr_countries - добавляем страны
            int country = statement.executeUpdate(
                    "insert into addr_countries(`Name`) values('Belarus');"
            );

            // addr_cities - добавляем города
            int city = statement.executeUpdate(String.format("insert into addr_cities(`Name`,`CounrtyId`)"+
                    " values('Minsk','%d');", country)
            );

            // addr_cities - добавляем улицы
            //Pobeditelei
            //Prititskogo
            int street1 = statement.executeUpdate(String.format("insert into addr_streets(`Name`,`CityId`)"+
                    " values('Pobeditelei','%d');", city)
            );
            int street2 = statement.executeUpdate(String.format("insert into addr_streets(`Name`,`CityId`)"+
                    " values('Prititskogo','%d')", city)
            );

            // addr_addresses - добавляем адреса
            //Pobeditelei 65
            //Prititskogo 29
            int addr1 = statement.executeUpdate(String.format("insert into addr_addresses(`BuildingNumberStr`,`StreetId`)"+
                            " values('65','%d')", street1)
            );
            int addr2 = statement.executeUpdate(String.format("insert into addr_addresses(`BuildingNumberStr`,`StreetId`)"+
                            " values('29','%d')", street2)
            );

            // ls_shoppingcenters - добавляем торговые центры
            // Zamok //53.9307475,27.5178348
            // Tivalli 53.908061, 27.484856
            int sc1 = statement.executeUpdate(String.format("insert into ls_shoppingcenters(`Name`,`AddressId`," +
                    "`Lat`,`Lng`,`Description` ) " +
                    "values('Zamok','%d', '53.9307475','27.5178348'," +
                    "'Торговый центр Замок – новый уровень шопинга и развлечений! К вашим услугам - магазины, " +
                    "кафе и рестораны, ледовый каток, кинотеатр, детский зал.');", addr1)
            );
            int sc2 = statement.executeUpdate(String.format("insert into ls_shoppingcenters(`Name`,`AddressId`," +
                    "`Lat`,`Lng`,`Description` )"+
                    " values('Tivalli','%d', '53.908061','27.484856'," +
                    "'Современный Многофункциональный Торгово-Развлекательный Бизнес Комплекс. " +
                    "Представляет собой мощный проект, подчёркивающий современный этап развития Минска в качестве " +
                    "столицы европейского государства.');", addr2)
            );

            // ls_shoppingcenters - добавляем помещения
            statement.executeUpdate(String.format("insert into ls_rooms(`Name`,`Square`,`ShoppingCenterId`)"+
                    " values('A24','524.6','%d');", sc1)
            );
            statement.executeUpdate(String.format("insert into ls_rooms(`Name`,`Square`,`ShoppingCenterId`)"+
                    " values('B67','324.4','%d');", sc1)
            );
            statement.executeUpdate(String.format("insert into ls_rooms(`Name`,`Square`,`ShoppingCenterId`)"+
                    " values('C31','724.4','%d');", sc2)
            );
            statement.executeUpdate(String.format("insert into ls_rooms(`Name`,`Square`,`ShoppingCenterId`)"+
                    " values('D15','224.4','%d');", sc2)
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
