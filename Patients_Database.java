import java.util.ArrayList;
import java.util.List;

class Patients_Database {
    public boolean AccountisUsed = false;
    public int PatientID;
    public String lastname;
    public String firstname;
    public String fullname;
    public int age = -1;
    public String Bloodtype;

    public List<String[]> account_lodge = new ArrayList<>(); // Changed to String array
    public List<String> consultation_data = new ArrayList<>();

    // Constructor
    public Patients_Database(String last, String first, int Patientage, int id) {
        this.lastname = last;
        this.firstname = first;
        this.fullname = last + ", " + first;
        this.age = Patientage;
        this.PatientID = id;
        this.AccountisUsed = true;
    }

    // Method to display patient data
    public void show_PatientData() {
        System.out.println("PATIENT'S FULL NAME:\t" + fullname);
        System.out.println("PATIENT'S ID:\t" + PatientID);
        System.out.println("\t---Details: First Name [ " + firstname + " ] Last Name [ " + lastname + " ]");
        System.out.println("-- AGE:\t\t" + (age == 0 ? "[ NO DATA ]" : age));
        System.out.println("-- BLOOD TYPE:\t" + (Bloodtype == null ? "[ NO DATA ]" : Bloodtype));
    }

    // Add blood type
    public void addBloodtype(String Blood) {
        this.Bloodtype = Blood;
    }

    // Add account activity (Modified to accept type and date)
    public void addAccountLodge(String type, String date) {
        this.account_lodge.add(new String[] { type, date });
    }

    // Add consultation data
    public void addConsultation(String date) {
        this.consultation_data.add(date);
    }

    // View consultations (Modified to display type and date)
    public void viewConsultations() {
        System.out.println("Consultation History:");
        for (String[] entry : account_lodge) {
            System.out.println("Type: " + entry[0] + " - Date: " + entry[1]);
        }
    }
}