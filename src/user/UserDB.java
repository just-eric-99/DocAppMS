package user;

import Util.Tokenizer;
import appointment.AppointmentDB;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDB {
    private List<User> userList = new ArrayList<>();

    public UserDB() {
    }

    public void loadUser(String filename) {
        System.out.print("Loading user db from " + filename + "...");
        try {
            File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
            int cnt = 0;
            int lineNum = 0;
            boolean duplicate;

            while (in.hasNextLine()) {
                duplicate = false;
                lineNum++;
                String line = in.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                String[] tokens = Tokenizer.getTokens(line);
                String name = "";
                for (int i = 3; i < tokens.length; i++) {
                    if (i == tokens.length - 1) {
                        name += tokens[i];
                    } else {
                        name += tokens[i] + " ";
                    }
                }

                for (int i = 0; i < this.userList.size(); i++) {
                    if (tokens[0].equals(userList.get(i).getUserID())) {
                        System.out.println("\nUserDB.loadDB: error adding record on line " + lineNum + " of " + filename + " -- Duplicated user record (" + tokens[0] + ")");
                        duplicate = true;
                    }
                }

                if (!duplicate) {
                    switch (tokens[2]) {
                        case "a":
                            userList.add(new Admin(tokens[0], tokens[1], name));
                            cnt++;
                            break;
                        case "d":
                            userList.add(new Doctor(tokens[0], tokens[1], name));
                            cnt++;
                            break;
                        case "p":
                            userList.add(new Patient(tokens[0], tokens[1], name));
                            cnt++;
                            break;
                    }
                }
            }
            System.out.println(cnt + " user records loaded.\n");

        } catch (FileNotFoundException e) {
            System.out.println("\nUserDB.loadDB failed: File not found (" + filename + ")!\n");
        }
    }

    public void saveUserDB(String filename) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);

        for (int i = 0; i < this.userList.size(); i++) {
            out.printf("%-10s  ", userList.get(i).getUserID());
            out.printf("%-10s  ", userList.get(i).getPasswd());
            out.printf("%-10s  ", userList.get(i).getUserID());
            out.printf("%-1s", userList.get(i).getFullname());
            out.println();
        }
        out.close();

        System.out.println(userList.size() + " user records saved to " + filename + "\n");

    }

    public boolean loginUser(String userID, String passwd) {
        boolean login = false;
        for (int i = 0; i < this.userList.size(); i++) {
            if (userID.equals(this.userList.get(i).getUserID()) && passwd.equals(this.userList.get(i).getPasswd())) {
                login = true;
                System.out.println();
                System.out.println("Login success! Welcome to Doctor Appointment Management System.");
                System.out.println();
                break;
            }
        }

        if (!login) {
            System.out.println("Invalid UserID or Password\n");
        }
        return login;
    }

    public void listUser() {
        System.out.println("Listing all users: ");

        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }

        System.out.println(userList.size() + " user(s) in found.\n");
    }

    public String getUserType(String userID) {
        int pos = 0;

        for (int i =0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getUserID().equals(userID)) {
                pos = i;
                break;
            }
        }
        return userList.get(pos).getUserType();
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getFullname(String userID) {
        String name = "";
        for (int i = 0; i < userList.size(); i ++) {
            if (userList.get(i).getUserID().equals(userID)) {
                name = userList.get(i).getFullname();
            }
        }
        return name;
    }

    public void addUser(User user) {
        boolean duplicate = false;
        for (int i = 0; i < this.userList.size(); i++) {
            if (user.getUserID().equalsIgnoreCase(userList.get(i).getUserID())) {
                duplicate = true;
                break;
            }
        }

        String type = "";
        switch (user.getUserType()) {
            case "a":
                type = "admin";
                break;
            case "d":
                type = "doctor";
                break;
            case "p":
                type = "patient";
                break;
        }

        if (duplicate) {
            System.out.println("Adding new user, " + user.getFullname() + " (" + user.getUserID() + ") as " + type + ": failed!");
            System.out.println("Duplicated user record (" + user.getUserID() + ")\n");
        } else {
            userList.add(user);
            System.out.println("Adding new user, " + user.getFullname() + " (" + user.getUserID() + ") as " + type + ": done!\n");
        }
    }

    public void deleteAdmin(String userID, AppointmentDB appointmentDB) {
        boolean exist = false;
        int pos = 0;
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getUserID().equalsIgnoreCase(userID) && this.userList.get(i).getUserType().equalsIgnoreCase("a")) {
                pos = i;
                exist = true;
            }
        }

        if (exist) {
            this.userList.remove(pos);
            System.out.println("Delete admin (" + userID + "): done!\n");
        } else {
            System.out.println("Delete admin (" + userID + "): failed!");
            System.out.println("Delete user failed: User (" + userID + ") not found in User DB\n");
        }
    }

    public void deletePatient(String userID, AppointmentDB appointmentDB) {
        boolean exist = false;
        int pos = 0;
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getUserID().equalsIgnoreCase(userID) && this.userList.get(i).getUserType().equalsIgnoreCase("p")) {
                pos = i;
                exist = true;
            }
        }

        if (exist) {
            this.userList.remove(pos);
            appointmentDB.deleteEveryAppointment(userID, "p");
            System.out.println("Delete patient (" + userID + "): done!\n");
        } else {
            System.out.println("Delete patient (" + userID + "): failed!");
            System.out.println("Delete user failed: User (" + userID + ") not found in User DB\n");
        }
    }

    public void deleteDoctor(String userID, AppointmentDB appointmentDB) {
        boolean exist = false;
        int pos = 0;
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getUserID().equalsIgnoreCase(userID) && this.userList.get(i).getUserType().equalsIgnoreCase("d")) {
                pos = i;
                exist = true;
                break;
            }
        }

        if (exist) {
            this.userList.remove(pos);
            appointmentDB.deleteEveryAppointment(userID, "d");
            System.out.println("Delete doctor (" + userID + "): done!\n");
        } else {
            System.out.println("Delete doctor (" + userID + "): failed!");
            System.out.println("Delete user failed: User (" + userID + ") not found in User DB\n");
        }
    }
}





