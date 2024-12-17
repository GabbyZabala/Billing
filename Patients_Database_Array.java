import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Patients_Database_Array {
    public List<Patients_Database> patients = new ArrayList<>();
    private int nextPatientID = 1; // Auto-increment for Patient IDs
    public int[] foundIndices = new int[10]; // To store indices of matching patients
    private int Found_Account = -1; // Initialize Found_Account

    // Add a new patient (Modified to return the index)
    public int addPatient(String last, String first, int age) {
        Patients_Database newPatient = new Patients_Database(last, first, age, nextPatientID++);
        patients.add(newPatient);
        return patients.size() - 1; // Return the index of the newly added patient
    }

    // Check for accounts with the same name (Modified)
    public int checkSameAccount(String firstName, String lastName) {
        Found_Account = -1; // Reset Found_Account before searching

        for (int i = 0; i < patients.size(); i++) {
            Patients_Database patient = patients.get(i);
            if (patient.firstname.equalsIgnoreCase(firstName) && patient.lastname.equalsIgnoreCase(lastName)) {
                Found_Account = i;
                break; // Stop searching once a match is found
            }
        }

        if (Found_Account != -1) {
            System.out.println("Duplicate account found!");
        } else {
            System.out.println("No duplicate accounts found!");
        }

        return Found_Account;
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