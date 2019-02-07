package by.it.malyshev.project.java.beans.pojo;

public class MessageDTO {

    private int id;
    private String message;
    private int users_Id;
    private String username;
    private int books_Id;

    public MessageDTO(int id, String message, int users_Id, String username, int books_Id) {
        this.id = id;
        this.message = message;
        this.users_Id = users_Id;
        this.username = username;
        this.books_Id = books_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(int users_Id) {
        this.users_Id = users_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBooks_Id() {
        return books_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }


}
