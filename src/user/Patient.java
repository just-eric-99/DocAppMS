package user;

public class Patient extends User{
    public Patient(String userID, String passwd, String fullname) {
        super(userID, passwd, "p", fullname);
    }
}
