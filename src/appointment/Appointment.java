package appointment;

import user.UserDB;

public class Appointment {
    private final String doctorID;
    private final String patientID;
    private final String timeslot;

    public Appointment(String doctorID, String patientID, String timeslot) {
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.timeslot = timeslot;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getTimeslot() {
        return timeslot;
    }

    @Override
    public String toString() {
        System.out.printf("\t%-10s  ", doctorID);
        System.out.printf("\t%-10s  ", patientID);
        System.out.printf("\t%-1s", timeslot);
        return "";
    }


}
