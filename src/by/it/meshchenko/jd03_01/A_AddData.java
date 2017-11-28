package by.it.meshchenko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

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

            int country = 0, city = 0 , street1 = 0, street2 = 0, addr1 = 0, addr2 = 0, sc1 = 0, sc2 = 0;

            // addr_countries - добавляем страны
            if(1 == statement.executeUpdate("insert into addr_countries(`Name`) values('Belarus');", RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    country = key.getInt(1);
                }
            }

            // addr_cities - добавляем города
            if(1 == statement.executeUpdate(String.format("insert into addr_cities(`Name`,`CounrtyId`) values('Minsk','%d');", country), RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    city = key.getInt(1);
                }
            }

            // addr_cities - добавляем улицы
            //Pobeditelei
            //Prititskogo
            if(1 == statement.executeUpdate(String.format("insert into addr_streets(`Name`,`CityId`)"+
                    " values('Pobeditelei','%d');", city), RETURN_GENERATED_KEYS
            )) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    street1 = key.getInt(1);
                }
            }
            if(1 == statement.executeUpdate(String.format("insert into addr_streets(`Name`,`CityId`)"+
                    " values('Prititskogo','%d')", city), RETURN_GENERATED_KEYS
            )) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    street2 = key.getInt(1);
                }
            }

            // addr_addresses - добавляем адреса
            //Pobeditelei 65
            //Prititskogo 29
            if(1 == statement.executeUpdate(String.format("insert into addr_addresses(`BuildingNumberStr`,`StreetId`)"+
                    " values('65','%d')", street1), RETURN_GENERATED_KEYS
            )) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    addr1 = key.getInt(1);
                }
            }
            if(1 == statement.executeUpdate(String.format("insert into addr_addresses(`BuildingNumberStr`,`StreetId`)"+
                    " values('29','%d')", street2), RETURN_GENERATED_KEYS
            )) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    addr2 = key.getInt(1);
                }
            }

            // ls_shoppingcenters - добавляем торговые центры
            // Zamok //53.9307475,27.5178348
            // Tivalli 53.908061, 27.484856
            if(1 == statement.executeUpdate(String.format("insert into ls_shoppingcenters(`Name`,`AddressId`," +
                    "`Lat`,`Lng`,`Description` ) " +
                    "values('Zamok','%d', '53.9307475','27.5178348'," +
                    "'Торговый центр Замок – новый уровень шопинга и развлечений! К вашим услугам - магазины, " +
                    "кафе и рестораны, ледовый каток, кинотеатр, детский зал.');", addr1), RETURN_GENERATED_KEYS
            )) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    sc1 = key.getInt(1);
                }
            }
            if(1 == statement.executeUpdate(String.format("insert into ls_shoppingcenters(`Name`,`AddressId`," +
                    "`Lat`,`Lng`,`Description` )"+
                    " values('Tivalli','%d', '53.908061','27.484856'," +
                    "'Современный Многофункциональный Торгово-Развлекательный Бизнес Комплекс. " +
                    "Представляет собой мощный проект, подчёркивающий современный этап развития Минска в качестве " +
                    "столицы европейского государства.');", addr2), RETURN_GENERATED_KEYS
            )) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    sc2 = key.getInt(1);
                }
            }

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
