package by.it.malyshev.project.java.beans.pojo;

public class AuthorBookDTO {

    private int id;
    private int author_Id;
    private int book_Id;
    private int position;
    private String authorName;

    public AuthorBookDTO(int id, int author_Id, int book_Id, int position, String authorName) {
        this.id = id;
        this.author_Id = author_Id;
        this.book_Id = book_Id;
        this.position = position;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor_Id() {
        return author_Id;
    }

    public void setAuthor_Id(int author_Id) {
        this.author_Id = author_Id;
    }

    public int getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "AuthorBookDTO{" +
                "id=" + id +
                ", author_Id=" + author_Id +
                ", book_Id=" + book_Id +
                ", position=" + position +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
