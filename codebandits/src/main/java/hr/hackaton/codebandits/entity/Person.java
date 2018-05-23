package hr.hackaton.codebandits.entity;

public abstract class Person {
    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String userName;

    private int password;

    public Person(String name, String surname, String email, String phoneNumber, String userName, int password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }
}
