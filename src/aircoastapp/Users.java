package aircoastapp;

public class Users {
    private String firstName;
    private String lastName;
    private String loginName;
    private String passwordUser;
    private String emailUser;

    public Users(String firstName, String lastName, String loginName, String passwordUser, String emailUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginName = loginName;
        this.passwordUser = passwordUser;
        this.emailUser = emailUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
