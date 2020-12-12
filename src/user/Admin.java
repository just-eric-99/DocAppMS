package user;

public class Admin extends User {

    public Admin(String userID, String passwd, String fullname) {
        super(userID, passwd, "a", fullname);
    }
}
