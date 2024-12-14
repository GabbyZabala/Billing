import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Patients_Database_Array {
    public List<Patients_Database> patients = new ArrayList<>();
    private int nextPatientID = 1; // Auto-increment for Patient IDs
    public int[] foundIndices = new int[10]; // To store indices of matching patients
    private int Found_Account;

    // Add a new patient
    public void addPatient(String last, String first, int age) {
        Patients_Database newPatient = new Patients_Database(last, first, age, nextPatientID++);
        patients.add(newPatient);
    }

    // Check for accounts with the same name
    public int checkSameAccount(String firstName, String lastName) {
        int output_found = -1;
        boolean found_passage = false;

        for (int i = 0; i < patients.size(); i++) {
            Patients_Database patient = patients.get(i);
            if (patient.firstname.equals(firstName) && patient.lastname.equals(lastName)) {
                output_found = i;// local output
                Found_Account = i;// global use
                found_passage = true;
            }
        }
        if (found_passage) {
            System.out.println("Duplicate accounts found!");
        } else {
            System.out.println("No duplicate accounts found!");
        }
        return output_found;
    }

    public boolean AskAgeData() {
        if (patients.get(Found_Account).age < 0)
            return false;
        else
            return true;
    }

    public int GetAge() {
        return patients.get(Found_Account).age;
    }

    public String Getfirstname() {
        return patients.get(Found_Account).firstname;
    }

    public String Getlastname() {
        return patients.get(Found_Account).lastname;
    }

    public int Getage() {
        return patients.get(Found_Account).age;
    }

    public void showAccount() {
        System.out.println(Found_Account);
    }

    // Clear found indices data
    public void clearFoundData() {
        Arrays.fill(foundIndices, -1);
        Found_Account = -1;
    }

    // Display all patients
    public void displayAllPatients() {
        System.out.println("All Patients:");
        for (Patients_Database patient : patients) {
            patient.show_PatientData();
        }
    }
}