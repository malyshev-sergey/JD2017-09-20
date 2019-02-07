package by.it.malyshev.project.java.dao.dto;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDTO<T> {
    List<T> getAll(String WhereAndOrder) throws SQLException;
}
