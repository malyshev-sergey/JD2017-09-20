package by.it.mustaphin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    Connection con;

    public C_Init(Connection con) {
        this.con = con;
    }

    void initDB() {
        try {
            Statement st = con.createStatement();
//            st.executeUpdate("CREATE SCHEMA IF NOT EXISTS 'mustaphin' DEFAULT CHARACTER SET utf8;");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS 'mustaphin'.'answers_catalog' (\n" +
                    "  'id_answer' INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  'text' VARCHAR(45) NOT NULL,\n" +
                    "  'fk_question' INT NOT NULL,\n" +
                    "  'correct' TINYINT(1) NULL DEFAULT 0,\n" +
                    "  PRIMARY KEY ('id_answer'));");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS 'mustaphin'.'questions' (\n" +
                    "  'id_question' INT NOT NULL AUTO_INCREMENT,\n" +
                    "  'theme' VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY ('id_question'));");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS 'mustaphin'.'roles' (\n" +
                    "  'id_role' INT NOT NULL AUTO_INCREMENT,\n" +
                    "  'type' VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY ('id_role'));n");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS 'mustaphin'.'users' (\n" +
                    "  'id_user' INT NOT NULL AUTO_INCREMENT,\n" +
                    "  'name' VARCHAR(45) NOT NULL,\n" +
                    "  'login' VARCHAR(45) NOT NULL,\n" +
                    "  'password' VARCHAR(45) NOT NULL,\n" +
                    "  'fk_question' INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY ('id_user'));\n");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS 'mustaphin'.'users_has_roles' (\n" +
                    "  'id_user' INT NOT NULL,\n" +
                    "  'id_role' INT NOT NULL),\n" +
                    "  PRIMARY KEY ('id_user','id_role'),\n" +
                    "  KEY 'fk_users_has_roles_roles1_idx' ('id_role'),\n" +
                    "  KEY 'fk_users_has_roles_users1_idx' ('id_user'),\n" +
                    "  CONSTRAINT 'fk_users_has_roles_roles1' FOREIGN KEY ('id_role') REFERENCES 'roles' ('id_role') ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT 'fk_users_has_roles_users1' FOREIGN KEY ('id_user') REFERENCES 'users' ('id_user') ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
