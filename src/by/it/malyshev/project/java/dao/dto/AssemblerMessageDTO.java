package by.it.malyshev.project.java.dao.dto;

import by.it.malyshev.project.java.beans.Messages;
import by.it.malyshev.project.java.dao.DAO;
import by.it.malyshev.project.java.beans.pojo.MessageDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssemblerMessageDTO implements InterfaceDTO<MessageDTO> {

    @Override
    public List<MessageDTO> getAll(String whereAndOrder) throws SQLException {

        List<MessageDTO> messageDTOs = new ArrayList<>();
        DAO dao = DAO.getInstance();

        List<Messages> messages = dao.message.getAll(whereAndOrder);

        for (Messages message : messages) {

            MessageDTO tmpMessageDTO = new MessageDTO(
                    message.getId(),
                    message.getMessage(),
                    message.getUsers_Id(),
                    dao.user.read(message.getUsers_Id()).getLogin(),
                    message.getBooks_Id()
            );
            messageDTOs.add(tmpMessageDTO);
        }
        return messageDTOs;
    }
}


