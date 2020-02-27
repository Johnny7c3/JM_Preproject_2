package Dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    private Connection connection;

    public UsersDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(User user) {
        if (!userExist(user)) {
            try (PreparedStatement pStmt = connection.prepareStatement("INSERT INTO userslist(name, surname, password, birthday) VALUES(?, ?, ?, ?)")) {
                pStmt.setString(1, user.getName());
                pStmt.setString(2, user.getSurname());
                pStmt.setString(3, user.getPassword());
                pStmt.setString(4, user.getBirthday());
                pStmt.execute();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<User> getAllUser() {
        List<User> res = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM userslist");
            while (resultSet.next()) {
                res.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public boolean userExist(User user) {
        try (PreparedStatement pStmt = connection.prepareStatement("SELECT name, surname FROM userslist WHERE name = ? AND surname = ?")) {
            pStmt.setString(1, user.getName());
            pStmt.setString(2, user.getSurname());
            ResultSet resultSet = pStmt.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(long id) {
        try (PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM userslist WHERE id = ?")) {
            pStmt.setLong(1, id);
            ResultSet resultSet = pStmt.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateUser(User updateUser) {
        User oldUser = getUserById(updateUser.getId());
        if (oldUser != null) {
            try (PreparedStatement pStmt = 
                    connection.prepareStatement("UPDATE userslist SET name = ?, surname = ?, password = ?, birthday = ? WHERE id = ?")) {
                pStmt.setLong(5, updateUser.getId());
                if (updateUser.getName().length() == 0) {
                    pStmt.setString(1, oldUser.getName());
                } else {
                    pStmt.setString(1, updateUser.getName());
                }
                if (updateUser.getSurname().length() == 0) {
                    pStmt.setString(2, oldUser.getSurname());
                } else {
                    pStmt.setString(2, updateUser.getSurname());
                }
                if (updateUser.getPassword().length() == 0) {
                    pStmt.setString(3, oldUser.getPassword());
                } else {
                    pStmt.setString(3, updateUser.getPassword());
                }
                if (updateUser.getBirthday().length() == 0) {
                    pStmt.setString(4, oldUser.getBirthday());
                } else {
                    pStmt.setString(4, updateUser.getBirthday());
                }
                pStmt.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deletUser(long id) {
        try (PreparedStatement pStmt = connection.prepareStatement("DELETE FROM userslist WHERE id = ?")) {
            pStmt.setLong(1, id);
            pStmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletAllUsers() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DELETE FROM userslist");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS userslist (id BIGINT AUTO_INCREMENT, name VARCHAR(256)," +
                    "surname VARCHAR(256), password VARCHAR(256), birthday VARCHAR(64), PRIMARY KEY(id))");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void dropTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS userslist");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}















