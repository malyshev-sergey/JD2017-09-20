package by.it.malyshev.project.java.beans;


//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "messages", propOrder = {
//        "id",
//        "message",
//        "users_Id",
//        "books_Id"
//})
public class Messages {

//    @XmlElement(name = "id", required = true)
    private int id;
//    @XmlElement(name = "message", required = true)
    private String message;
//    @XmlElement(name = "users_Id", required = true)
    private int users_Id;
//    @XmlElement(name = "books_Id", required = true)
    private int books_Id;

    public Messages() {
    }

    public Messages(int id, String message, int users_Id, int books_Id) {
        this.id = id;
        this.message = message;
        this.users_Id = users_Id;
        this.books_Id = books_Id;
    }

    public Messages(String message, int users_Id, int books_Id) {
        this.id = 0;
        this.message = message;
        this.users_Id = users_Id;
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

    public int getBooks_Id() {
        return books_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", users_Id=" + users_Id +
                ", books_Id=" + books_Id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messages messages = (Messages) o;

        if (id != messages.id) return false;
        if (users_Id != messages.users_Id) return false;
        if (books_Id != messages.books_Id) return false;
        return message != null ? message.equals(messages.message) : messages.message == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + users_Id;
        result = 31 * result + books_Id;
        return result;
    }
}
