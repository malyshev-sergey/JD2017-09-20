package by.it.mustaphin.jd03_03.dao;

import by.it.mustaphin.jd03_03.bean.Answer;
import by.it.mustaphin.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO extends AbstactDAO implements InterfaceDAO<Answer> {

    @Override
    public boolean create(Answer answer) throws SQLException {
        boolean correct = answer.isCorrect();
        int fk_question = answer.getFk_question();
        String text = answer.getText();
        answer.setId_answer(executeUpdate("INSERT INTO answers (correct, fk_question, text) VALUES ('" + correct + "', '" + fk_question + "', '" + text + "');"));
        return (0 < answer.getId_answer());
    }

    @Override
    public boolean update(Answer answer) throws SQLException {
        return (1 == executeUpdate("UPDATE answers SET correct='" + answer.isCorrect() + "', fk_question='" + answer.getFk_question() + "' WHERE id_answer='" + answer.getId_answer() + "';"));
    }

    @Override
    public boolean delete(Answer answer) throws SQLException {
        return (0 < executeUpdate("DELETE FROM answers WHERE id_answer='" + answer.getId_answer() + "';"));
    }

    @Override
    public Answer read(Answer answer) throws SQLException {
        try (Connection con = ConnectionCreator.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM answers WHERE id_answer='" + answer.getId_answer() + "';");
            if (rs.next()) {
                answer = new Answer(
                        rs.getBoolean("correct"),
                        rs.getInt("fk_question"),
                        rs.getString("text"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return answer;
    }

    @Override
    public List<Answer> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Answer> getAll(String condition) throws SQLException {
        List<Answer> answers = new ArrayList<>();
        try (Connection con = ConnectionCreator.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM answers" + condition + ";");
            while (rs.next()) {
                Answer answer = new Answer(
                        rs.getInt("id_answer"),
                        rs.getBoolean("correct"),
                        rs.getInt("fk_question"),
                        rs.getString("text"));
                answers.add(answer);
            }
        } catch (SQLException e) {
            throw e;
        }
        return answers;
    }
}
