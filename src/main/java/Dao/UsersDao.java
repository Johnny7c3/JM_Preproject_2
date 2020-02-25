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
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userslist (name, surname, password, birthday) VALUES(?, ?, ?, ?)")) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getBirthday());
                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<User> getAllUser() {
        List<User> res = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM userslist");
            while (resultSet.next()) {
                res.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean userExist(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, surname FROM userslist WHERE name = ? and surname = ?")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userslist WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
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
            try (PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE userslist set name = ?, surname = ?, password = ?, birthday = ? where id = ?")) {
                preparedStatement.setLong(5, updateUser.getId());
                if (updateUser.getName().length() == 0) {
                    preparedStatement.setString(1, oldUser.getName());
                } else {
                    preparedStatement.setString(1, updateUser.getName());
                }
                if (updateUser.getSurname().length() == 0) {
                    preparedStatement.setString(2, oldUser.getSurname());
                } else {
                    preparedStatement.setString(2, updateUser.getSurname());
                }
                if (updateUser.getPassword().length() == 0) {
                    preparedStatement.setString(3, oldUser.getPassword());
                } else {
                    preparedStatement.setString(3, updateUser.getPassword());
                }
                if (updateUser.getBirthday().length() == 0) {
                    preparedStatement.setString(4, oldUser.getBirthday());
                } else {
                    preparedStatement.setString(4, updateUser.getBirthday());
                }
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletUser(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userslist WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletAllUsers() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM userslist");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS userslist (id bigint auto_increment, name varchar(256), surname varchar(256), password varchar(256), birthday varchar (64), primary key (id))");
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















