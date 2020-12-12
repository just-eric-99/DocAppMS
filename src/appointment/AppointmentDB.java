package appointment;

import Util.Tokenizer;
import application.TimetableDB;
import user.UserDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentDB {
    private List<Appointment> appointmentList = new ArrayList<>();

    public AppointmentDB() {
    }

    public void loadAppointment(String filename) {
        System.out.print("Loading appointment db from " + filename + "...");
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

                for (int i = 0; i < this.appointmentList.size(); i++) {
                    if (tokens[0].equals(appointmentList.get(i).getDoctorID()) && tokens[2].equals(appointmentList.get(i).getTimeslot())) {
                        System.out.println("\nAppointmentDB.loadDB: error adding record at line " + lineNum + " of " + filename + " -- Doctor appointment time clash (" + tokens[0] + ", " + tokens[2] + ")");
                        duplicate = true;
                    } else if (tokens[1].equals(appointmentList.get(i).getPatientID()) && tokens[2].equals(appointmentList.get(i).getTimeslot())) {
                        System.out.println("\nAppointmentDB.loadDB: error adding record at line " + lineNum + " of " + filename + " -- Patient appointment time clash (" + tokens[1] + ", " + tokens[2] + ")");
                        duplicate = true;
                    }
                }

                if (!duplicate) {
                    appointmentList.add(new Appointment(tokens[0], tokens[1], tokens[2]));
                    cnt++;
                }
            }
            System.out.println(cnt + " appointment records loaded.\n");

        } catch (FileNotFoundException e) {
            System.out.println("\nAppointmentDB.loadDB failed: File not found (" + filename + ")!\n");
        }


    }

    public void toReminder(UserDB userDB, String userID) {
        String fullname = userDB.getFullname(userID);
        int cnt = 0;
        int pos = 0;
        boolean userExist = false;
        for (int i = 0; i < userDB.getUserList().size(); i++) {
            if (userDB.getUserList().get(i).getUserID().equals(userID)) {
                userExist = true;
                pos = i;
                break;
            }
        }
        String type = userDB.getUserList().get(pos).getUserType();

        if (userExist && type.equals("d")) {
            System.out.println(fullname + " (" + userID + ") is a doctor, and has the following appointments:");
            for (int i = 0; i < this.appointmentList.size(); i++) {
                if (appointmentList.get(i).getDoctorID().equals(userID)) {
                    System.out.println("\t" + appointmentList.get(i).getTimeslot() + " -- Patient: " + userDB.getFullname(appointmentList.get(i).getPatientID()) + " (" + appointmentList.get(i).getPatientID() + ")");
                    cnt++;
                }
            }
            System.out.println(cnt + " appointments found.\n");
        } else if (userExist && type.equals("p")) {
            System.out.println(fullname + " (" + userID + ") is a patient, and has the following appointments:");
            for (int i = 0; i < this.appointmentList.size(); i++) {
                if (appointmentList.get(i).getPatientID().equals(userID)) {
                    System.out.println("\t" + appointmentList.get(i).getTimeslot() + " -- Doctor: " + userDB.getFullname(appointmentList.get(i).getDoctorID()) + " (" + appointmentList.get(i).getDoctorID() + ")");
                    cnt++;
                }
            }
            System.out.println(cnt + " appointments found.\n");
        } else {
            System.out.println("No such user (" + userID + ")\n");
        }
    }

    public void toTimetable(UserDB userDB, String userID) {
        String fullname = userDB.getFullname(userID);
        int cnt = 0;
        int pos = 0;
        boolean userExist = false;
        for (int i = 0; i < userDB.getUserList().size(); i++) {
            if (userDB.getUserList().get(i).getUserID().equals(userID)) {
                userExist = true;
                pos = i;
                break;
            }
        }

        String type = userDB.getUserList().get(pos).getUserType();

        List<Appointment> newAppointmentList = new ArrayList<>();

        if (userExist && type.equals("d")) {
            for (int i = 0; i < this.appointmentList.size(); i++) {
                if (appointmentList.get(i).getDoctorID().equals(userID)) {
                    newAppointmentList.add(appointmentList.get(i));
                    cnt++;
                }
            }
        } else if (userExist && type.equals("p")) {
            for (int i = 0; i < this.appointmentList.size(); i++) {
                if (appointmentList.get(i).getPatientID().equals(userID)) {
                    newAppointmentList.add(appointmentList.get(i));
                    cnt++;
                }
            }
        }

        String[][] clientInfo = new String[cnt][2];

        if (userExist && type.equalsIgnoreCase("d")) {
            for (int i = 0; i < newAppointmentList.size(); i++) {
                clientInfo[i][0] = newAppointmentList.get(i).getPatientID();
                clientInfo[i][1] = newAppointmentList.get(i).getTimeslot();
            }
            System.out.println("Time Table for " + fullname + " (" + userID + "):");
            new TimetableDB().timetable(clientInfo);
            System.out.println(fullname + " (" + userID + ") has " + cnt + " appointments.\n");

        } else if (userExist && type.equals("p")) {
            for (int i = 0; i < newAppointmentList.size(); i++) {
                clientInfo[i][0] = newAppointmentList.get(i).getDoctorID();
                clientInfo[i][1] = newAppointmentList.get(i).getTimeslot();
            }
            System.out.println("Time Table for " + fullname + " (" + userID + "):");
            new TimetableDB().timetable(clientInfo);

            System.out.println(fullname + " (" + userID + ") has " + cnt + " appointments.\n");
        } else {
            System.out.println("No such user (" + userID + ")\n");
        }
    }

    public void listAppointment() {
        System.out.println("Listing all appointments: ");

        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println(appointmentList.get(i).toString());
        }

        System.out.println(appointmentList.size() + " appointments in found.\n");
    }

    public void saveAppointmentDB(String filename) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);

        for (int i = 0; i < this.appointmentList.size(); i++) {
            out.printf("%-10s  ", appointmentList.get(i).getDoctorID());
            out.printf("%-10s  ", appointmentList.get(i).getPatientID());
            out.printf("%-1s", appointmentList.get(i).getTimeslot());
            out.println();
        }
        out.close();

        System.out.println(appointmentList.size() + " appointment records saved to " + filename + "\n");
    }

    public void addAppointment(Appointment appointment) {
        boolean duplicate = false;
        for (int i = 0; i < this.appointmentList.size(); i++) {
            if (appointmentList.get(i).getDoctorID().equalsIgnoreCase(appointment.getDoctorID()) && appointmentList.get(i).getTimeslot().equalsIgnoreCase(appointment.getTimeslot())) {
                System.out.println("Adding new appointment, (" + appointment.getDoctorID() + ", " + appointment.getPatientID() + ", " + appointment.getTimeslot() + "): failed!");
                System.out.println("Doctor appointment time clash (" + appointment.getDoctorID() + ", " + appointment.getTimeslot() + ")\n");
                duplicate = true;
                break;
            } else if (appointmentList.get(i).getPatientID().equalsIgnoreCase(appointment.getPatientID()) && appointmentList.get(i).getTimeslot().equalsIgnoreCase(appointment.getTimeslot())) {
                System.out.println("Adding new appointment, (" + appointment.getDoctorID() + ", " + appointment.getPatientID() + ", " + appointment.getTimeslot() + "): failed!");
                System.out.println("Patient appointment time clash (" + appointment.getPatientID() + ", " + appointment.getTimeslot() + ")\n");
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            appointmentList.add(appointment);
            System.out.println("Adding new appointment, (" + appointment.getDoctorID() + ", " + appointment.getPatientID() + ", " + appointment.getTimeslot() + "): done!\n");
        }
    }

    public void deleteAppointment(String doctorID, String patientID, String timeslot) {
        boolean exist = false;
        int pos = 0;

        for (int i = 0; i < this.appointmentList.size(); i++) {
            if (appointmentList.get(i).getDoctorID().equalsIgnoreCase(doctorID) && appointmentList.get(i).getPatientID().equalsIgnoreCase(patientID) && appointmentList.get(i).getTimeslot().equalsIgnoreCase(timeslot)) {
                exist = true;
                pos = i;
                break;
            }
        }

        if (exist) {
            this.appointmentList.remove(pos);
            System.out.println("Delete appointment (" + doctorID + ", " + patientID + ", " + timeslot + "): done!\n");
        } else {
            System.out.println("Delete appointment (" + doctorID + ", " + patientID + ", " + timeslot + "): failed!");
            System.out.println("Delete appointment failed: Appointment (" + doctorID + ", " + patientID + ", " + timeslot + ") not found in Appointment DB\n");
        }
    }

    public void deleteEveryAppointment(String userID, String type) {
        int[] pos = new int[0];
        if (type.equalsIgnoreCase("d")) {
            for (int i = 0; i < this.appointmentList.size(); i++) {
                if (appointmentList.get(i).getDoctorID().equalsIgnoreCase(userID)) {
                    pos = addToNumArray(pos, i);
                }
            }
        } else if (type.equalsIgnoreCase("p")) {
            for (int i = 0; i < this.appointmentList.size(); i++) {
                if (appointmentList.get(i).getPatientID().equalsIgnoreCase(userID)) {
                    pos = addToNumArray(pos, i);
                }
            }
        }

        for (int i = pos.length - 1; i >= 0; i--) {
            appointmentList.remove(pos[i]);
        }
    }

    private int[] addToNumArray(int[] oldNumArray, int newNum) {
        int[] newNumArray = new int[oldNumArray.length + 1];

        for (int i = 0; i < oldNumArray.length; i++) {
            newNumArray[i] = oldNumArray[i];
        }

        newNumArray[oldNumArray.length] = newNum;

        return newNumArray;
    }
}

















