import java.util.Scanner;

public class Main_Grilling extends ui {

    public static boolean DEbuggMode = true;// must be false when presenting
    public static int praccout = 0;
    /*
     * .^ . . . . . . . . . . . ^.
     * / \ DEbugger Parts here / \
     * .| . . . . . . . . . . . |.
     */
    int Found[] = new int[10];
    int foundnum = 0;
    public static Patients_Database[] patients = new Patients_Database[10];
    public int available_patients = 0;

    class Patients_Action {

        public void check_same_account(String Name, String Lance) {
            for (int i = 0; i > available_patients; i++) {
                if (patients[i].firstname.equals(Name)) {
                    Found[foundnum] = i;
                    foundnum++;
                }
            }
            if (foundnum != 0) {
                for (int f = 0; f > Found.length; f++) {
                    System.out.print("[ " + f + " ]");
                    patients[Found[f]].show_PatientsData();
                }
            }
        }

        public void add_newPatient(String firstname, String lastname) {
            patients[available_patients] = new Patients_Database(lastname, firstname, available_patients);
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
    public static int Remstart = 0;

    public static void Display_Screen(int screen) {// This void is for display Properties
        boolean tring;
        tring = Display_Properties(screen); // ang haba kasi nung display_propeties kaya ginawan ko ng paraan
        notError_Display = tring;
    }

    public static Scanner command = new Scanner(System.in);
    public static int Data_Changer;

    public static void main(String[] args) {
        do {
            String Terminal = "";
            clear();
            if (locale != 5) {
                System.out.println((!DEbuggMode ? "\n"
                        : "DataList: " + "Locale:/" + locale + "/Rem:/" + Remstart + "/" + "Acc:" + praccout + ""));
                // for debugging purposes
                try {
                    header();
                    Display_Screen(locale);
                    if (Remstart % 10 != 0 || Remstart == 0) {
                        System.out.print("[]--->:\t");
                        Terminal = command.nextLine();
                        Data_Changer = Integer.parseInt(Terminal);
                    }
                    switch (Remstart) {
                        case 0 -> Main_Menu(Data_Changer);
                        case 1 -> ConsultationService(Data_Changer);// 1.Consultation Services
                        case 2 -> LaboratoryServices(Data_Changer);// 2.Laboratory Services
                        case 3 -> RoomandAdmissionServices(Data_Changer);// 3.Room and Admission Services
                        // 4.Transaction Records
                        case 10 -> ConsultationServiceFunctions(Data_Changer);
                        case 20 -> LaboratoryServicesFunctions(Data_Changer);
                        case 30 -> RoomandAdmissionServicesFunctions(Data_Changer);
                        default -> System.out.print("Error Reload page");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error Conversion");
                }
            } else {
                break;
            }
        } while (true);
        loading_Animation();
        clear();
    }

    public static void Main_Menu(int number) {
        switch (number) {
            case 1, 2, 3, 4 -> locale = Remstart = number;
            case 5 -> locale = number;// exit
        }
    }

    public static void ConsultationService(int MultiShot) {
        int Id = 10;
        switch (MultiShot) {
            case 1, 2, 3 -> {
                Data_Changer = MultiShot;
                Remstart = Id;
            }
            case 4 -> locale = Remstart = 0;// back to main menu
        }
    }

    public static void LaboratoryServices(int MultiShot) {
        int Id = 20;
        switch (MultiShot) {
            case 1, 2, 3 -> {
                Data_Changer = MultiShot;
                Remstart = Id;
            }
            case 4 -> locale = Remstart = 0;// back to main menu
        }
    }

    public static void RoomandAdmissionServices(int MultiShot) {
        int Id = 30;
        switch (MultiShot) {
            case 1, 2, 3 -> {
                Data_Changer = MultiShot;
                Remstart = Id;
            }
            case 4 -> locale = Remstart = 0;// back to main menu
        }
    }

    public static void ConsultationServiceFunctions(int MultiShot) {
        int Id = 1;
        switch (MultiShot) {
            case 1 -> line();// RegisterNewConsultation();
            case 2 -> line();// EditConsultationFees()
            case 3 -> line();// ViewConsultationRecords();
        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void EditConsultationFees() {

    }

    public static void LaboratoryServicesFunctions(int MultiShot) {
        int Id = 2;
        switch (MultiShot) {
            case 1 -> line();// RegisterNewLaboratoryTest();
            case 2 -> line();// LaboratoryPricing();
            case 3 -> line();// ViewLaboratoryRecords();
        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void RoomandAdmissionServicesFunctions(int MultiShot) {
        int Id = 3;
        switch (MultiShot) {
            case 1 -> line();// RegisterNewAdmission();
            case 2 -> line();// EditRoomInformation();
            case 3 -> line();// ViewRoomRecords();
        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }
}
