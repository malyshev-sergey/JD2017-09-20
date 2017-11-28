package by.it.govor.jd03_01;




import java.sql.*;

public class Insert {
    public static void main(String[] args) {

        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);

             Statement statement=connection.createStatement();) {

            statement.executeUpdate(
                    "INSERT INTO ad (processor, video_card, motherboard,ram,power_supply,HDD,user_ID)"+
                            "VALUES ('Intel i5 8600k','GTX 1080 TI','Z 270','32,3200','700W','3Tb',1);"
            );

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    }

