import java.util.Scanner;

public class Main_Grilling extends ui {
    // DEbugg purposes
    public static boolean DEbuggMode = true;

    class Patients_Action {
        private static Patients_Database[] patients = new Patients_Database[99];
        private int available_patients = 0;

        public void add_newPatient(String name) {
            patients[available_patients] = new Patients_Database(null, null, available_patients, available_patients);
        }
    }

    public static class Pricing {// Pricing Properties
        double Hospital_bill = 0.0, // for getting the total
                // Consultation Fee
                OPD = 100.9,
                ER = 109.0,
                // Lab testign Divider
                Blood_Chemistry = 10.9,
                Hematology = 100,
                Clinical_Microscopy = 210,
                Bacteriology = 190,
                BloodBankAndSerology = 10,
                // Room Service Divider
                Service_Ward = 100.0,
                SemiPrivate_Room = 90.9,
                Private_Room = 100;
    }

    public static boolean notError_Display = true;// display catcher in case of error
    public static int locale = 0;// display location handler

    public static void Display_Screen(int screen) {// This void is for display Properties
        boolean tring;
        tring = Display_Properties(screen); // ang haba kasi nung display_propeties kaya ginawan ko ng paraan
        notError_Display = tring;
    }

    public static void main(String[] args) {
        do {
            clear();
            header();
            Display_Screen(locale);
            try (Scanner command = new Scanner(System.in)) {
                String Terminal = command.nextLine();
                try {
                    int Data_Changer = Integer.parseInt(Terminal);
                    switch (Data_Changer) {
                        case 1:

                            break;

                        default:
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error Conversion");
                }

            }
        } while (true);
    }

}
