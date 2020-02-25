package model;

public class User {
    
    private long id;
    private String name;
    private String surname;
    private String password;
    private String birthday;

    public User() {}

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + password + " " + birthday;
    }

    public User(String name, String surname, String password, String birthday) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthday = birthday;
    }

    public User(long id, String name, String surname, String password, String birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}


















