package user;

public class Doctor extends User{
    public Doctor(String userID, String passwd, String fullname) {
        super(userID, passwd, "d", fullname);
    }

}
