package by.it.mustaphin.jd03_03.dao;

import by.it.mustaphin.jd03_03.bean.Right;
import by.it.mustaphin.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RightDAO extends AbstactDAO implements InterfaceDAO<Right> {

    @Override
    public boolean create(Right right) throws SQLException {
        int id_user = right.getId_user();
        boolean admin = right.getCouples().get("admin");
        boolean user = right.getCouples().get("user");
        boolean guest = right.getCouples().get("guest");
        return (0 < executeUpdate("INSERT INTO rights (id_user, admin, user, guest) VALUES ('" + id_user + "', '" + admin + "', '" + user + "', '" + guest + "');"));
    }

    @Override
    public boolean update(Right right) throws SQLException {
        int id_user = right.getId_user();
        boolean admin = right.getCouples().get("admin");
        boolean user = right.getCouples().get("user");
        boolean guest = right.getCouples().get("guest");
        return (1 == executeUpdate("UPDATE rights SET admin='" + admin + "', user='" + user + "', guest='" + guest + "' WHERE id_user='" + id_user + "';"));
    }

    @Override
    public boolean delete(Right right) throws SQLException {
        int id_user = right.getId_user();
        return (0 < executeUpdate("DELETE FROM rights WHERE id_user='" + id_user + "';"));
    }

    @Override
    public Right read(Right right) throws SQLException {
        try (Connection con = ConnectionCreator.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM rights WHERE id_user='" + right.getId_user() + "';");
            if (rs.next()) {
                right = new Right();
            }
        } catch (SQLException e) {
            throw e;
        }
        return right;
    }

    @Override
    public List<Right> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Right> getAll(String condition) throws SQLException {
        List<Right> rights = new ArrayList<>();
        try (Connection con = ConnectionCreator.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM rights" + condition + ";");
            while (rs.next()) {
                Right right = new Right();
                rights.add(right);
            }
        } catch (SQLException e) {
            throw e;
        }
        return rights;
    }
}
