package user;

public class User {
    private String userID;
    private String passwd;
    private String userType;
    private String fullname;

    public User(String userID, String passwd, String userType, String fullname) {
        this.userID = userID;
        this.passwd = passwd;
        this.userType = userType;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUserID() {
        return userID;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        String type= "";
        switch (userType) {
            case "a":
                type = "Admin";
                break;
            case "d":
                type = "Doctor";
                break;
            case "p":
                type = "Patient";
                break;
        }

        System.out.printf("\t%-12s", userID);
        System.out.printf("\t%-12s", passwd);
        System.out.printf("\t%-12s", type);
        System.out.print(fullname);
        return "";
    }
}
