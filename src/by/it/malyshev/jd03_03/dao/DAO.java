package by.it.malyshev.jd03_03.dao;

public class DAO {

    private static DAO dao;

    public RolesDAO role; // UniversalDAO<Roles> role;
    public UsersDAO user;
    public BooksDAO book;
    public AuthorsDAO author;
    public AuthorsBooksDAO authorBook;
    public MessagesDAO message;
    public OrdersDAO order;
    public StoreDAO store;


    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.role = new RolesDAO(); // UniversalDAO<>(new Roles(), "roles");
                    dao.user = new UsersDAO();
                    dao.book=new BooksDAO();
                    dao.author=new AuthorsDAO();
                    dao.authorBook=new AuthorsBooksDAO();
                    dao.message=new MessagesDAO();
                    dao.order=new OrdersDAO();
                    dao.store=new StoreDAO();
                }
            }
        }
        return dao;
    }
}
