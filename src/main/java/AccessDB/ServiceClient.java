package AccessDB;

import Dao.UsersDao;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ServiceClient {
    private static Connection connection = null;

    public void addUser(User user) {
        getUserDao().addUser(user);
    }

    public List<User> getAllUser() {
        return getUserDao().getAllUser();
    }

    public User getUserById(long id) {
        return getUserDao().getUserById(id);
    }

    public boolean userExist(User user) {
        return getUserDao().userExist(user);
    }

    public void updateUser(User user) {
        getUserDao().updateUser(user);
    }

    public void deletUser(long id) {
        getUserDao().deletUser(id);
    }

    public void deletAllUsers() {
        getUserDao().deletAllUsers();
    }

    public void createTable() {
        getUserDao().createTable();
    }

    public void dropTable() {
        getUserDao().dropTable();
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url
                    .append("jdbc:mysql://")         // db type
                    .append("localhost:")            // host name
                    .append("3306/")                 // port
                    .append("preproject?")           // db name
                    .append("user=root&")            // login
                    .append("password=admin")        // password
                    .append("&serverTimezone=UTC");  // setup server time
            System.out.println("URL: " + url + "\n");
            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UsersDao getUserDao() {
        return new UsersDao(getMysqlConnection());
    }
}




















