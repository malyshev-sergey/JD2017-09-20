package by.it.mustaphin.jd03_02;

public class Runner {
    public static void main(String[] args) {
        CreateConnection con = new CreateConnection();
        TaskA tA = new TaskA(con.connection);
        tA.findIdRole("mustaphin marat");
    }
}
