package by.it.likhanau.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Init {

    Connection con;

    public C_Init(Connection con) {
        this.con = con;
    }

    void initDB() {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `likhanau` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `likhanau` DEFAULT CHARACTER SET utf8 ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `likhanau`.`roles` (  `id_role` int(11) NOT NULL AUTO_INCREMENT,   `role` varchar(45) NOT NULL,  PRIMARY KEY (`id_role`),   UNIQUE KEY `id_role_UNIQUE` (`id_role`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;"
            );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `likhanau`.`users` (\n" +
                    "  `id_user` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `id_role` int(11) NOT NULL,\n" +
                    "  `login` varchar(45) NOT NULL,\n" +
                    "  `password` varchar(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id_user`),\n" +
                    "  UNIQUE KEY `id_user_UNIQUE` (`id_user`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");


             statement.executeUpdate("INSERT INTO `likhanau`.`roles` (`id_role`, `role`) VALUES ('1', 'administrator');");
            statement.executeUpdate("INSERT INTO `likhanau`.`roles` (`id_role`, `role`) VALUES ('2', 'tour_agent');");
             statement.executeUpdate("INSERT INTO `likhanau`.`users` (`id_user`, `id_role`, `login`, `password`) VALUES ('1', '1', 'admin1', 'qwerty');");
            statement.executeUpdate("INSERT INTO `likhanau`.`users` (`id_user`, `id_role`, `login`, `password`) VALUES ('2', '2', 'Kate17', '12345');");
            statement.executeUpdate("INSERT INTO `likhanau`.`users` (`id_user`, `id_role`, `login`, `password`) VALUES ('3', '2', 'Lila1', 'qwe123');");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
