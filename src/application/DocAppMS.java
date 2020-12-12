package application;

import Util.Tokenizer;
import appointment.Appointment;
import appointment.AppointmentDB;
import user.Admin;
import user.Doctor;
import user.Patient;
import user.UserDB;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocAppMS {
    public static void main(String[] args) throws FileNotFoundException {
        new DocAppMS().runApp(args[0], args[1]);
    }

    void runApp(String userFile, String AppointmentFile) throws FileNotFoundException {
        UserDB userDB = new UserDB();
        AppointmentDB appointmentDB = new AppointmentDB();

        System.out.println("*** System Startup: begin ***");
        userDB.loadUser(userFile);
        appointmentDB.loadAppointment(AppointmentFile);
        System.out.println("*** System Startup: done! ***");
        System.out.println();


        boolean login = false;
        Scanner in = new Scanner(System.in);
        String line = "";
        String type = "";
        String userID = "";

        do {
            System.out.println("\n+------------------------------------------+");
            System.out.println("|                                          |");
            System.out.println("|   Doctor Appointment Management System   |");
            System.out.println("|                                          |");
            System.out.println("+------------------------------------------+");
            System.out.println();
            System.out.println("Available commands: ");
            System.out.println(" Login User");
            System.out.println(" Quit");
            System.out.println();
            System.out.print("ready> ");
            if (!login) {
                line = in.nextLine();
                String[] tokens = Tokenizer.getTokens(line);
                if (tokens[0].equalsIgnoreCase("Login")) {
                    System.out.print("Password: ");
                    userID = tokens[1];
                    String passwd = in.nextLine();
                    login = userDB.loginUser(tokens[1], passwd);
                    type = userDB.getUserType(tokens[1]);

                } else if (tokens[0].equalsIgnoreCase("quit")) {
                    System.out.println("Goodbye~~");
                    System.exit(0);
                }
            }
            while (login) {
                System.out.print("ready> ");
                line = in.nextLine();
                String[] tokens = Tokenizer.getTokens(line);
                if (tokens[0].equalsIgnoreCase("logout")) {
                    login = false;
                    break;
                }

                switch (tokens[0]) {
                    case "show":
                        if (tokens[1].equalsIgnoreCase("reminder")) {
                            try {
                                if (type.equals("a")) {
                                    appointmentDB.toReminder(userDB, tokens[2]);
                                } else {
                                    appointmentDB.toReminder(userDB, userID);
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Invalid number of arguments for Show.\n");
                            }
                        } else if (tokens[1].equalsIgnoreCase("timetable")) {
                            try {
                                if (type.equals("a")) {
                                    appointmentDB.toTimetable(userDB, tokens[2]);
                                } else {
                                    appointmentDB.toTimetable(userDB, userID);
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Invalid number of arguments for Show.\n");
                            }
                        }
                        break;
                    case "list": // dummy
                        try {
                            if (tokens[1].equalsIgnoreCase("user") && type.equalsIgnoreCase("a")) {
                                userDB.listUser();
                            } else if (tokens[1].equalsIgnoreCase("appointment") && type.equalsIgnoreCase("a")) {
                                appointmentDB.listAppointment();
                            } else if (tokens.length >= 3) {
                                System.out.println("Invalid number of arguments for List.\n");
                            } else {
                                System.out.println("Unknown option, \"" + tokens[1] + "\", for List\n");
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            if (type.equalsIgnoreCase("a")) {
                                System.out.println("Invalid number of arguments for List.\n");
                            } else {
                                System.out.println("Unknown command: " + tokens[0] + "\n");
                            }
                        }
                        break;
                    case "load":
                        try {
                            if (tokens.length >= 4 && type.equalsIgnoreCase("a")) {
                                System.out.println("Invalid number of arguments for Load.\n");
                                break;
                            }
                            if (type.equalsIgnoreCase("a") && tokens[1].equalsIgnoreCase("user")) {
                                userDB.loadUser(tokens[2]);
                            } else if (type.equalsIgnoreCase("a") && tokens[1].equalsIgnoreCase("appointment")) {
                                appointmentDB.loadAppointment(tokens[2]);
                            } else {
                                System.out.println("Unknown command: " + tokens[0] + "\n");
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid number of arguments for Load.\n");
                        }
                        break;
                    case "help":
                        System.out.print("User: " + userID + " ");
                        if (type.equalsIgnoreCase("a")) {
                            System.out.println("*** Admin ***");
                            System.out.println();
                            System.out.println("Available commands:");
                            System.out.println("  load   [ user | appointment ]");
                            System.out.println("  save   [ user | appointment ]");
                            System.out.println("  list   [ user | appointment ]");
                            System.out.println("  show   [ reminder | timetable ]");
                            System.out.println("  add    [ user | appointment ]");
                            System.out.println("  delete [ user | appointment ]");
                            System.out.println("  help   [ command ]");
                            System.out.println("  logout");
                            System.out.println();
                        } else if (type.equalsIgnoreCase("d")) {
                            System.out.println("*** Doctor ***");
                            System.out.println();
                            System.out.println("Available commands:");
                            System.out.println("  show   [ reminder | timetable ]");
                            System.out.println("  add    appointment");
                            System.out.println("  delete appointment");
                            System.out.println("  help   [ command ]");
                            System.out.println("  logout");
                            System.out.println();
                        } else if (type.equalsIgnoreCase("p")) {
                            System.out.println("*** Patient ***");
                            System.out.println();
                            System.out.println("Available commands:");
                            System.out.println("  show   [ reminder | timetable ]");
                            System.out.println("  add    appointment");
                            System.out.println("  delete appointment");
                            System.out.println("  help   [ command ]");
                            System.out.println("  logout");
                            System.out.println();
                        }
                        break;
                    case "save":
                        if (type.equalsIgnoreCase("a")) {
                            if (tokens.length == 3) {
                                if (tokens[1].equalsIgnoreCase("user")) {
                                    userDB.saveUserDB(tokens[2]);
                                } else if (tokens[1].equalsIgnoreCase("appointment")) {
                                    appointmentDB.saveAppointmentDB(tokens[2]);
                                } else {
                                    System.out.println("Unknown option, \"" + tokens[2] + "\", for Save.\n");
                                }
                            } else {
                                System.out.println("Invalid number of arguments for Save.\n");
                            }
                        } else {
                            System.out.println("Unknown command: " + tokens[0] + "\n");
                        }
                        break;
                    case "add":
                        String name = "";
                        try {
                            for (int i = 4; i < tokens.length; i++) {
                                if (i == tokens.length - 1) {
                                    name += tokens[i];
                                } else {
                                    name += tokens[i] + " ";
                                }
                            }

                            if (type.equalsIgnoreCase("a") && tokens.length >= 5) {
                                switch (tokens[1]) {
                                    case "admin":
                                        userDB.addUser(new Admin(tokens[2], tokens[3], name));
                                        break;
                                    case "doctor":
                                        userDB.addUser(new Doctor(tokens[2], tokens[3], name));
                                        break;
                                    case "patient":
                                        userDB.addUser(new Patient(tokens[2], tokens[3], name));
                                        break;
                                    case "appointment":
                                        appointmentDB.addAppointment(new Appointment(tokens[2], tokens[3], tokens[4]));
                                        break;
                                    default:
                                        System.out.println("Unknown option, \"" + tokens[1] + "\", for Add.\n");
                                        break;
                                }
                            } else if (type.equalsIgnoreCase("d") && tokens.length == 3) {
                                appointmentDB.addAppointment(new Appointment(userID, tokens[1], tokens[2]));
                            } else if (type.equalsIgnoreCase("p") && tokens.length == 3) {
                                appointmentDB.addAppointment(new Appointment(tokens[1], userID, tokens[2]));
                            } else {
                                System.out.println("Invalid number of arguments for Add.\n");
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid number of arguments for Add.\n");
                        }
                        break;
                    case "delete":
                        if (type.equalsIgnoreCase("a") && tokens.length == 3) {
                            switch (tokens[1]) {
                                case "admin":
                                    userDB.deleteAdmin(tokens[2], appointmentDB);
                                    break;
                                case "doctor":
                                    userDB.deleteDoctor(tokens[2] , appointmentDB);
                                    break;
                                case "patient":
                                    userDB.deletePatient(tokens[2], appointmentDB);
                                    break;
                                default:
                                    System.out.println("Unknown option, \"" + tokens[1] + "\", for Delete.\n");
                                    break;
                            }
                        } else if (tokens[1].equalsIgnoreCase("appointment") && tokens.length == 5) {
                            appointmentDB.deleteAppointment(tokens[2], tokens[3], tokens[4]);

                        } else if (type.equalsIgnoreCase("a") && tokens.length > 3 && !tokens[1].equalsIgnoreCase("appointment")) {
                            System.out.println("Invalid number of arguments for Delete.\n");
                        } else if (type.equalsIgnoreCase("d") && tokens.length == 3) {
                            appointmentDB.deleteAppointment(userID, tokens[1], tokens[2]);
                        } else if (type.equalsIgnoreCase("p") && tokens.length == 3) {
                            appointmentDB.deleteAppointment(tokens[1], userID, tokens[2]);
                        } else {
                            System.out.println("Invalid number of arguments for Delete.\n");
                        }

                        break;
                    default:
                        System.out.println("Unknown command: " + tokens[0] + "\n");

                }

            }
        } while (!line.equalsIgnoreCase("quit") && !login);


    }


}
