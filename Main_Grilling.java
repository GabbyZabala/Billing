import java.util.ArrayList;
import java.util.Scanner;
//  just the code history in my github account
//      https://github.com/GabbyZabala/Billing
//  too tired to explain T^T

public class Main_Grilling extends ui {

    public static boolean DEbuggMode = true;// must be false when presenting
    public static int praccout = 0;
    /*
     * .^ . . . . . . . . . . . ^.
     * / \ DEbugger Parts here / \
     * .| . . . . . . . . . . . |.
     */

    public static class Pricing {// Pricing Properties
        double// for getting the total
              // Consultation Fee
        OPD = 100.9,
                ER = 109.0,
                // Lab testing Divider
                // Blood Chemistry
                Bua = 160,
                Bun = 160,
                Cholesterol = 160,
                Creatine = 195,
                FBS_RBS = 160,
                Triglycerides = 250,
                AST_GOT = 200,
                AST_GPT = 200,
                HDL_LDL = 300,
                // Hematology
                CBC = 250,
                CT_BT = 100,
                Hgb_Hct = 100,
                Peripheral_Smear_Staining = 100,
                Peripheral_Smear_Reading = 300,
                Platelet_Count = 250,
                // Clinical Microscopy
                Fecalysis = 100,
                Occult_Blood_Test = 100,
                Pregnancy_Test = 150,
                Urinalysis = 125,
                // Bacteriology
                Sputum_Exam_AFB = 130,
                Slit_Skin_Smear = 130,
                Gram_Stain = 130,
                KOH_Mount = 130,
                RF_Igm = 450,
                Typhidot = 550,
                // Blood Bank and Serology
                Blood_Typing = 65,
                HbSAg = 230,
                HCV = 350,
                HAV = 350,
                Bleeding_Fee = 200,
                // Room Service Divider
                Service_Ward_food = 150,
                Service_Ward_Room_Board = 200,
                Service_Ward_Bedding = 50,
                Service_Ward_Waste_Mngt = 50,
                SemiPrivate_Room_food = 250,
                SemiPrivate_Room_Room_Board = 650,
                SemiPrivate_Room_Bedding = 50,
                SemiPrivate_Room_Waste_Mgnt = 50,
                Private_Room_food = 250,
                Private_Room_Room_Board = 1000,
                Private_Room_Bedding = 100,
                Private_Room_Waste_Mngt = 50;

        public double Service_Ward() {
            return Service_Ward_food + Service_Ward_Bedding + Service_Ward_Room_Board + Service_Ward_Waste_Mngt;
        }

        public double SemiPrivate_Room() {
            return SemiPrivate_Room_food + SemiPrivate_Room_Room_Board + SemiPrivate_Room_Bedding
                    + SemiPrivate_Room_Waste_Mgnt;
        }

        public double Private_Room() {
            return Private_Room_food + Private_Room_Room_Board + Private_Room_Bedding + Private_Room_Waste_Mngt;
        }
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
            String Terminal;
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
                        case 4 -> TransactionRecords(Data_Changer);
                        case 10 -> ConsultationServiceFunctions(Data_Changer);
                        case 20 -> LaboratoryServicesFunctions(Data_Changer);
                        case 30 -> RoomandAdmissionServicesFunctions(Data_Changer);
                        case 40 -> TransactionRecordsFunctions(Data_Changer);
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

    public static void TransactionRecords(int MultiShot) {
        int Id = 40;
        switch (MultiShot) {
            case 1, 2, 3 -> {
                Data_Changer = MultiShot;
                Remstart = Id;
            }
            case 4 -> locale = Remstart = 0;// back to main menu
        }
    }

    // Consulation Service Function
    public static void ConsultationServiceFunctions(int MultiShot) {
        int Id = 1;
        switch (MultiShot) {
            case 1 -> RegisterNewConsultation();// line();//
            case 2 -> EditConsultationFees();// line();//
            case 3 -> ViewConsultationRecords();// line();//
        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static ArrayList<String> consultationRecords = new ArrayList<>();
    public static ArrayList<String> ViewLaboratoryRecords = new ArrayList<>();
    public static ArrayList<String> ViewRoomRecords = new ArrayList<>();
    public static Patients_Database_Array db = new Patients_Database_Array();

    public static void RegisterNewConsultation() {
        Boolean endLoop = false;
        boolean CheckAccount_Recorded = false;
        boolean age_available = false;
        int Stage = 0;
        String firstname = "";
        String lastname = "";
        int Age = -1;
        String Date = " ";
        String typeStr = ""; // Initialize typeStr
        double fee = 0; // Initialize fee
        Pricing priceof = new Pricing();

        do {
            boolean pass = false;
            clear();
            header();
            hsa_register_Consulatation();

            switch (Stage) {
                case 0 -> {// Firstname Input
                    System.out.print("Enter FirstName:\t");
                    firstname = command.nextLine();
                    pass = true;
                }
                case 1 -> {// Lastname Input
                    System.err.println("FirtName: " + firstname);
                    System.out.print("Enter Lastname:\t");
                    lastname = command.nextLine();
                    pass = true;
                }
                case 2 -> {// Duplicate Account Checker
                    try {
                        int search = db.checkSameAccount(firstname, lastname);
                        if (DEbuggMode) {
                            command.nextLine();
                        }
                        if (search >= 0 && !CheckAccount_Recorded) {
                            if (DEbuggMode) {
                                db.showAccount();
                            }
                            animation("Getting Duplicate... Done");
                            lastname = db.Getlastname();
                            firstname = db.Getfirstname();
                            age_available = db.AskAgeData();
                            CheckAccount_Recorded = true;
                        }

                        System.out.println("Patients name:\t" + lastname + ", " + firstname);

                        if (!age_available && !CheckAccount_Recorded) {
                            System.out.print("Enter Age:\t");
                            String AgeComs = command.nextLine();
                            Age = Integer.parseInt(AgeComs);
                        } else {
                            animation("Fetching patients Age.....");
                            Age = db.GetAge();
                            System.out.println("Patient age:\t" + Age);
                        }
                        pass = true;

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        if (DEbuggMode) {
                            command.nextLine();
                        }
                    }
                }
                case 3 -> {// Date Input
                    clear();
                    header();
                    hsa_register_Consulatation();
                    System.out.println("Patients name:\t" + lastname + ", " + firstname);
                    System.out.println("Patient age:\t" + Age);
                    System.out.println(
                            "Enter Date:\tLAYOUT MUST BE \"00-00-0000\" [ Day-Month-Year]\n\tfill the fron with 0 if you only need single digit like 09 not 9");
                    System.out.print("[]-> \t");
                    Date = command.nextLine();

                    if (Date.length() != 10) {
                        System.out.println(
                                "Invalid input: The string must have exactly 10 characters, including dashes ('-').");
                    } else {
                        // Initialize variables
                        String[] parts = new String[3]; // Store the 3 sets (first, second, optional third)
                        int partIndex = 0;
                        StringBuilder currentPart = new StringBuilder();

                        // Loop through the string
                        for (int i = 0; i < Date.length(); i++) {
                            char ch = Date.charAt(i);

                            if (ch == '-') {
                                // When '-' is found, save the current part and reset
                                if (partIndex < 3) { // Prevent ArrayIndexOutOfBoundsException
                                    parts[partIndex] = currentPart.toString();
                                    partIndex++;
                                }
                                currentPart.setLength(0); // Clear the StringBuilder
                            } else {
                                // Append the character to the current part
                                currentPart.append(ch);
                            }
                        }

                        // Add the last part after the loop
                        if (partIndex < 3) { // Prevent ArrayIndexOutOfBoundsException
                            parts[partIndex] = currentPart.toString();
                        }

                        boolean checkpoint = false;
                        try {
                            for (int l = 0; l < parts.length; l++) {
                                boolean loopers = true;
                                int Check = Integer.parseInt(parts[l]);

                                switch (l) {
                                    case 0 -> {
                                        if (DEbuggMode) {
                                            System.out.println("First set: " + parts[0]);
                                            command.nextLine();
                                        }
                                        if (Check > 31) {
                                            loopers = false;
                                        }
                                    }
                                    case 1 -> {
                                        if (DEbuggMode) {
                                            System.out.println("Second set: " + parts[1]);
                                            command.nextLine();
                                        }
                                        if (Check > 12) {
                                            loopers = false;
                                        }
                                    }
                                    case 2 -> {
                                        if (DEbuggMode) {
                                            if (parts[2] != null && parts[2].length() == 4) {
                                                System.out.println("Third set: " + parts[2]);
                                            } else {
                                                System.out.println("No valid third set.");
                                            }
                                        }
                                        checkpoint = true;
                                    }
                                }
                                if (!loopers) {
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in date parts: " + e.getMessage());
                            if (DEbuggMode) {
                                command.nextLine();
                            }
                            break; // Exit the case if invalid input is detected
                        }

                        // Check if the date passed the validation
                        if (checkpoint) {
                            pass = true;
                        } else {
                            System.out.println("Invalid date format or out-of-range values.");
                        }
                        command.nextLine();
                    }
                }

                case 4 -> {// Last step and saving
                    clear();
                    header();
                    hsa_register_Consulatation();
                    System.out.println("Patients name:\t" + lastname + ", " + firstname);
                    System.out.println("Patient age:\t" + Age);
                    System.out.println("Consultation Date: " + Date);
                    System.out.println("Choose consultation type: ");
                    register_Consulatation();
                    int type = -1; // Initialize type to an invalid value
                    System.out.print("[]->\t");
                    if (command.hasNextInt()) {
                        type = command.nextInt();
                        command.nextLine(); // Consume the newline character after reading the integer
                    } else {
                        // Handle the case where the user doesn't enter an integer
                        System.out.println("Invalid input. Please enter a number for the consultation type.");
                        command.nextLine(); // Clear the invalid input
                        break; // Exit the switch and re-prompt the user
                    }

                    pass = true;
                    typeStr = (type == 1) ? "OPD" : "ER";

                    switch (type) {
                        case 1 -> fee = priceof.OPD;
                        case 2 -> fee = priceof.ER;
                    }

                    int patientIndex;
                    if (CheckAccount_Recorded) {
                        // If a duplicate was found, use the existing index
                        patientIndex = db.checkSameAccount(firstname, lastname);
                    } else {
                        // If no duplicate, add a new patient
                        patientIndex = db.addPatient(lastname, firstname, Age);
                    }

                    // Add consultation to account_lodge (with type and date)
                    db.patients.get(patientIndex).addAccountLodge(typeStr, Date);

                    consultationRecords
                            .add("Name: " + lastname + ", " + firstname + "/tDate: " + Date + ", Type: " + typeStr
                                    + ", Fee: ₱" + fee);
                    System.out.println("Consultation Registered! Total Fee: ₱" + fee);
                    endLoop = true;
                }
            }
            if (pass) {
                Stage++;
            }
        } while (!endLoop);
        db.clearFoundData();
    }

    public static void EditConsultationFees() {
        Pricing priceof = new Pricing();
        int PriceDweller = 0;
        while (true) {
            clear();
            header();
            hsa_edit_Consultation();
            if (PriceDweller < 1) {// display part for price
                System.out.println("\n\t Consultation OPD:\t₱ " + priceof.OPD);
                System.out.println("\n\t Consultation ER:\t₱ " + priceof.ER);
            } else {
                if (PriceDweller == 1)
                    System.out.println("\n\t Consultation OPD:\t₱ " + priceof.OPD);
                if (PriceDweller == 2)
                    System.out.println("\n\t Consultation ER:\t₱ " + priceof.ER);
            }
            System.out.println("\n");
            if (PriceDweller < 1) {
                edit_Consultation();
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("3")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("error");
                }
            } else {
                String ednano = (PriceDweller == 2 ? "OPD" : "ER");
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();
                if (PriceDweller == 1) {
                    priceof.OPD = price;
                } else {
                    priceof.ER = price;
                }
                PriceDweller = 0;
            }
        }
    }

    public static void ViewConsultationRecords() {
        clear();
        header();
        System.out.println("NOTE: This is only for Viewing no editing");
        System.out.println("\n--- Consultation Records ---");
        for (String record : consultationRecords) {
            System.out.println(record);
        }
        System.out.print("Press Enter to continue...");
        command.nextLine();// use to halt view
    }

    // Laboratory Service Function
    public static void LaboratoryServicesFunctions(int MultiShot) {
        int Id = 2;
        switch (MultiShot) {
            case 1 -> RegisterNewLaboratoryTest();// line();//
            case 2 -> LaboratoryPricing();// line();//
            case 3 -> ViewLaboratoryRecords();// line();//
        }
        if (DEbuggMode) {
            System.err.println("lab()->" + MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void RegisterNewLaboratoryTest() {
        boolean endLoop = false;
        boolean CheckAccount_Recorded = false;
        boolean age_available = false;
        int Stage = 0;
        String firstname = "";
        String lastname = "";
        int Age = -1;
        String Date = " ";
        double fee = 0;

        // Data Collection
        String Patient_Name = "";
        String Patient_Blood = "";
        String Category_Type = "";
        String Selected_Test = "";

        do {
            boolean pass = false;
            clear();
            header();
            hsa_newLaboratoryTest();

            switch (Stage) {
                case 0 -> {// Firstname Input
                    System.out.print("Enter FirstName:\t");
                    firstname = command.nextLine();
                    pass = true;
                }
                case 1 -> {// LastName Input
                    System.err.println("FirtName: " + firstname);
                    System.out.print("Enter Lastname:\t");
                    lastname = command.nextLine();
                    pass = true;
                }
                case 2 -> {// Check for dupplicate & Age
                    try {
                        int search = db.checkSameAccount(firstname, lastname);
                        if (DEbuggMode) {
                            command.nextLine();
                        }

                        if (search >= 0 && !CheckAccount_Recorded) {
                            if (DEbuggMode) {
                                db.showAccount();
                            }
                            animation("Getting Duplicate... Done");
                            lastname = db.Getlastname();
                            firstname = db.Getfirstname();
                            age_available = db.AskAgeData();
                            CheckAccount_Recorded = true;
                        }

                        Patient_Name = lastname + ", " + firstname;
                        System.out.println("Patients name:\t" + Patient_Name);

                        if (!age_available && !CheckAccount_Recorded) {
                            System.out.print("Enter Age:\t");
                            String AgeComs = command.nextLine();
                            Age = Integer.parseInt(AgeComs);
                        } else {
                            animation("Fetching patients Age.....");
                            Age = db.GetAge();
                            System.out.println("Patient age:\t" + Age);
                        }

                        pass = true;
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        if (DEbuggMode) {
                            command.nextLine();
                        }
                    }
                }
                case 3 -> {// Blood Input
                    // Get Blood Type (might need to add validation here)
                    System.out.print("Enter Blood Type:\t");
                    Patient_Blood = command.nextLine();
                    pass = true;
                }
                case 4 -> {// Date Input
                    clear();
                    header();
                    hsa_newLaboratoryTest();
                    System.out.println("Patients name:\t" + Patient_Name);
                    System.out.println("Patient age:\t" + Age);
                    System.out.println("Patient Blood:\t" + Patient_Blood);
                    System.out.println(
                            "Enter Date:\tLAYOUT MUST BE \"00-00-0000\" [ Day-Month-Year]\n\tfill the fron with 0 if you only need single digit like 09 not 9");
                    System.out.print("[]-> \t");
                    Date = command.nextLine();

                    if (Date.length() != 10) {
                        System.out.println(
                                "Invalid input: The string must have exactly 10 characters, including dashes ('-').");
                    } else {
                        // Initialize variables
                        String[] parts = new String[3]; // Store the 3 sets (first, second, optional third)
                        int partIndex = 0;
                        StringBuilder currentPart = new StringBuilder();

                        // Loop through the string
                        for (int i = 0; i < Date.length(); i++) {
                            char ch = Date.charAt(i);

                            if (ch == '-') {
                                // When '-' is found, save the current part and reset
                                if (partIndex < 3) { // Prevent ArrayIndexOutOfBoundsException
                                    parts[partIndex] = currentPart.toString();
                                    partIndex++;
                                }
                                currentPart.setLength(0); // Clear the StringBuilder
                            } else {
                                // Append the character to the current part
                                currentPart.append(ch);
                            }
                        }

                        // Add the last part after the loop
                        if (partIndex < 3) { // Prevent ArrayIndexOutOfBoundsException
                            parts[partIndex] = currentPart.toString();
                        }

                        boolean checkpoint = false;
                        try {
                            for (int l = 0; l < parts.length; l++) {
                                boolean loopers = true;
                                int Check = Integer.parseInt(parts[l]);

                                switch (l) {
                                    case 0 -> {
                                        if (DEbuggMode) {
                                            System.out.println("First set: " + parts[0]);
                                            command.nextLine();
                                        }
                                        if (Check > 31) {
                                            loopers = false;
                                        }
                                    }
                                    case 1 -> {
                                        if (DEbuggMode) {
                                            System.out.println("Second set: " + parts[1]);
                                            command.nextLine();
                                        }
                                        if (Check > 12) {
                                            loopers = false;
                                        }
                                    }
                                    case 2 -> {
                                        if (DEbuggMode) {
                                            if (parts[2] != null && parts[2].length() == 4) {
                                                System.out.println("Third set: " + parts[2]);
                                            } else {
                                                System.out.println("No valid third set.");
                                            }
                                        }
                                        checkpoint = true;
                                    }
                                }
                                if (!loopers) {
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in date parts: " + e.getMessage());
                            if (DEbuggMode) {
                                command.nextLine();
                            }
                            break; // Exit the case if invalid input is detected
                        }

                        // Check if the date passed the validation
                        if (checkpoint) {
                            pass = true;
                        } else {
                            System.out.println("Invalid date format or out-of-range values.");
                        }
                        command.nextLine();
                    }
                }
                case 5 -> {// Library check
                    // Select Laboratory Category
                    clear();
                    header();
                    hsa_newLaboratoryTest();
                    System.out.println("Patients name:\t" + Patient_Name);
                    System.out.println("Patient age:\t" + Age);
                    System.out.println("Patient Blood:\t" + Patient_Blood);
                    System.out.println("Date:\t" + Date);

                    System.out.println("Select Laboratory Category:");
                    ls_newLaboratorytest(); // Display the category choices

                    int categoryChoice = -1;
                    if (command.hasNextInt()) {
                        categoryChoice = command.nextInt();
                        command.nextLine(); // Consume newline
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        command.nextLine(); // Clear invalid input
                        break;
                    }

                    // Process Category Choice
                    switch (categoryChoice) {
                        case 1 -> {
                            Category_Type = "Blood Chemistry";
                            Selected_Test = selectBloodChemistryTest();
                        }
                        case 2 -> {
                            Category_Type = "Hematology";
                            Selected_Test = selectHematologyTest();
                        }
                        case 3 -> {
                            Category_Type = "Clinical Microscopy";
                            Selected_Test = selectClinicalMicroscopyTest();
                        }
                        case 4 -> {
                            Category_Type = "Bacteriology";
                            Selected_Test = selectBacteriologyTest();
                        }
                        case 5 -> {
                            Category_Type = "Blood Bank and Serology";
                            Selected_Test = selectBloodBankAndSerologyTest();
                        }
                        case 6 -> {
                            endLoop = true; // Back to Laboratory Services Menu
                            break;
                        }
                        default -> {
                            System.out.println("Invalid category choice.");
                        }
                    }

                    // If a test was selected, calculate the fee
                    if (!Selected_Test.isEmpty()) {
                        fee = getTestFee(Category_Type, Selected_Test);
                        pass = true;
                    }
                }
                case 6 -> {// Saving
                    // Register the test
                    int patientIndex;
                    if (CheckAccount_Recorded) {
                        patientIndex = db.checkSameAccount(firstname, lastname);
                    } else {
                        patientIndex = db.addPatient(lastname, firstname, Age);
                    }

                    // Update patient's blood type if available
                    if (!Patient_Blood.isEmpty()) {
                        db.patients.get(patientIndex).addBloodtype(Patient_Blood);
                    }

                    // Add laboratory test to account_lodge
                    db.patients.get(patientIndex).addAccountLodge(Category_Type + " - " + Selected_Test, Date);

                    // Add to ViewLaboratoryRecords (for viewing purposes)
                    ViewLaboratoryRecords.add("Name: " + Patient_Name + ", Date: " + Date + ", Category: "
                            + Category_Type + ", Test: " + Selected_Test + ", Fee: ₱" + fee);

                    System.out.println("Laboratory Test Registered! Total Fee: ₱" + fee);
                    endLoop = true;
                }
            }

            if (pass) {
                Stage++;
            }
        } while (!endLoop);
        db.clearFoundData();
    }

    // Helper functions to select tests from each category
    // v[need to implement these based on your menu structure]v
    private static String selectBloodChemistryTest() {
        // ... (Display Blood Chemistry tests and get user selection)
        clear();
        header();
        ls_category_blood_Chemistry();
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline

        return switch (choice) {
            case 1 -> "Bua";
            case 2 -> "Bun";
            case 3 -> "Cholesterol";
            case 4 -> "Creatinine";
            case 5 -> "FBS:RBS";
            case 6 -> "Triglycerides";
            case 7 -> "AST/ GOT";
            case 8 -> "ALT/ GPT";
            case 9 -> "HDL/ LDL";
            default -> "";
        };
    }

    private static String selectHematologyTest() {
        // ...
        clear();
        header();
        hematology();
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline
        return switch (choice) {
            case 1 -> "CBC";
            case 2 -> "CT/BT";
            case 3 -> "Hgb/Hct";
            case 4 -> "Peripheral Smear Staining";
            case 5 -> "Peripheral Smear Reading";
            case 6 -> "Platelet Count";
            default -> "";
        };
    }

    private static String selectClinicalMicroscopyTest() {
        // ...
        clear();
        header();
        clinical_Microscopy();
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline
        return switch (choice) {
            case 1 -> "Fecalysis";
            case 2 -> "Occult Blood Test";
            case 3 -> "Pregnancy Test";
            case 4 -> "Urinalysis";
            default -> "";
        };
    }

    private static String selectBacteriologyTest() {
        // ...
        clear();
        header();
        bacteriology();
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline
        return switch (choice) {
            case 1 -> "Sputum Exam/ AFB";
            case 2 -> "Slit Skin Smear";
            case 3 -> "Gram Stain";
            case 4 -> "KOH Mount";
            case 5 -> "RF/Igm";
            case 6 -> "Typhidot";
            default -> "";
        };
    }

    private static String selectBloodBankAndSerologyTest() {
        // ...
        clear();
        header();
        bloodBank_Serology();
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline
        return switch (choice) {
            case 1 -> "Blood Typing";
            case 2 -> "HbSAg";
            case 3 -> "HCV";
            case 4 -> "HAV";
            case 5 -> "Bleeding Fee";
            default -> "";
        };
    }

    // Helper function to get the fee for a specific test
    private static double getTestFee(String category, String test) {
        Pricing priceof = new Pricing();
        return switch (category) {
            case "Blood Chemistry" -> switch (test) {
                case "Bua" -> priceof.Bua;
                case "Bun" -> priceof.Bun;
                case "Cholesterol" -> priceof.Cholesterol;
                case "Creatinine" -> priceof.Creatine;
                case "FBS:RBS" -> priceof.FBS_RBS;
                case "Triglycerides" -> priceof.Triglycerides;
                case "AST/ GOT" -> priceof.AST_GOT;
                case "ALT/ GPT" -> priceof.AST_GPT;
                case "HDL/ LDL" -> priceof.HDL_LDL;
                default -> 0.0;
            };
            case "Hematology" -> switch (test) {
                case "CBC" -> priceof.CBC;
                case "CT/BT" -> priceof.CT_BT;
                case "Hgb/Hct" -> priceof.Hgb_Hct;
                case "Peripheral Smear Staining" -> priceof.Peripheral_Smear_Staining;
                case "Peripheral Smear Reading" -> priceof.Peripheral_Smear_Reading;
                case "Platelet Count" -> priceof.Platelet_Count;
                default -> 0.0;
            };
            case "Clinical Microscopy" -> switch (test) {
                case "Fecalysis" -> priceof.Fecalysis;
                case "Occult Blood Test" -> priceof.Occult_Blood_Test;
                case "Pregnancy Test" -> priceof.Pregnancy_Test;
                case "Urinalysis" -> priceof.Urinalysis;
                default -> 0.0;
            };
            case "Bacteriology" -> switch (test) {
                case "Sputum Exam/ AFB" -> priceof.Sputum_Exam_AFB;
                case "Slit Skin Smear" -> priceof.Slit_Skin_Smear;
                case "Gram Stain" -> priceof.Gram_Stain;
                case "KOH Mount" -> priceof.KOH_Mount;
                case "RF/Igm" -> priceof.RF_Igm;
                case "Typhidot" -> priceof.Typhidot;
                default -> 0.0;
            };
            case "Blood Bank and Serology" -> switch (test) {
                case "Blood Typing" -> priceof.Blood_Typing;
                case "HbSAg" -> priceof.HbSAg;
                case "HCV" -> priceof.HCV;
                case "HAV" -> priceof.HAV;
                case "Bleeding Fee" -> priceof.Bleeding_Fee;
                default -> 0.0;
            };
            default -> 0.0;
        };
    }

    public static void LaboratoryPricing() {
        int MultiShot;
        do {
            clear();
            header();
            hsa_editLaboratoryPricinh();
            System.out.println("Choice Which of this Category you'll have to edit:");
            ls_newLaboratorytest();
            System.err.print("Enter choice: --> ");
            String Cache = command.nextLine();
            MultiShot = Integer.parseInt(Cache);
            switch (MultiShot) {
                case 1 -> BloodChemistryPrices();
                case 2 -> HematologyPrices();
                case 3 -> ClinicalMicroscopyPrices();
                case 4 -> BacteriologyPrices();
                case 5 -> BloodBankandSerologyPrices();
                default -> System.err.println("error");
            }
            if (DEbuggMode) {
                System.err.println("laBpRI()->" + MultiShot);
                command.nextLine();
            }
        } while (MultiShot != 6);
    }

    public static void BloodChemistryPrices() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;
        while (true) {
            clear();
            header();
            hsa_editLaboratoryPricinh();
            System.err.println("Section Blood Chemistry Category:");
            if (PriceDweller < 1) {// display part for price
                System.out.println("\t [1] Bua\t\t:\t₱ " + priceof.Bua);
                System.out.println("\t [2] Bun\t\t:\t₱ " + priceof.Bun);
                System.out.println("\t [3] Cholesterol\t:\t₱ " + priceof.Cholesterol);
                System.out.println("\t [4] Creatinine\t\t:\t₱ " + priceof.Creatine);
                System.out.println("\t [5] FBS/RBS\t\t:\t₱ " + priceof.FBS_RBS);
                System.out.println("\t [6] Triglycerides\t:\t₱ " + priceof.Triglycerides);
                System.out.println("\t [7] AST/GOT\t\t:\t₱ " + priceof.AST_GOT);
                System.out.println("\t [8] AST/GPT\t\t:\t₱ " + priceof.AST_GPT);
                System.out.println("\t [9] HDL/LDl\t\t:\t₱ " + priceof.HDL_LDL);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\t Bua\t\t:\t₱ " + priceof.Bua);
                    case 2 -> System.out.println("\t Bun\t\t:\t₱ " + priceof.Bun);
                    case 3 -> System.out.println("\t Cholesterol\t:\t₱ " + priceof.Cholesterol);
                    case 4 -> System.out.println("\t Creatinine\t:\t₱ " + priceof.Creatine);
                    case 5 -> System.out.println("\t FBS/RBS\t:\t₱ " + priceof.FBS_RBS);
                    case 6 -> System.out.println("\t Triglycerides\t:\t₱ " + priceof.Triglycerides);
                    case 7 -> System.out.println("\t AST/GOT\t:\t₱ " + priceof.AST_GOT);
                    case 8 -> System.out.println("\t AST/GPT\t:\t₱ " + priceof.AST_GPT);
                    case 9 -> System.out.println("\t HDL/LDL\t:\t₱ " + priceof.HDL_LDL);
                }
            }
            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("error");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Bua";
                    case 2 -> "Bun";
                    case 3 -> "Cholesterol";
                    case 4 -> "Creatine";
                    case 5 -> "FBS/RBS";
                    case 6 -> "Triglycerides";
                    case 7 -> "AST/GOT";
                    case 8 -> "AST/GPT";
                    case 9 -> "HDL/LDL";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();
                switch (PriceDweller) {
                    case 1 -> priceof.Bua = price;
                    case 2 -> priceof.Bun = price;
                    case 3 -> priceof.Cholesterol = price;
                    case 4 -> priceof.Creatine = price;
                    case 5 -> priceof.FBS_RBS = price;
                    case 6 -> priceof.Triglycerides = price;
                    case 7 -> priceof.AST_GOT = price;
                    case 8 -> priceof.AST_GPT = price;
                    case 9 -> priceof.HDL_LDL = price;
                }
                PriceDweller = -1;
            }
        }
    }

    public static void HematologyPrices() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_editLaboratoryPricinh();
            System.err.println("Section Hematology Category:");

            if (PriceDweller < 1) { // Display part for prices
                System.out.println("\t [1] CBC\t\t\t:\t₱ " + priceof.CBC);
                System.out.println("\t [2] CT/BT\t\t\t:\t₱ " + priceof.CT_BT);
                System.out.println("\t [3] Hgb/Hct\t\t\t:\t₱ " + priceof.Hgb_Hct);
                System.out.println("\t [4] Peripheral Smear Staining\t:\t₱ " + priceof.Peripheral_Smear_Staining);
                System.out.println("\t [5] Peripheral Smear Reading\t:\t₱ " + priceof.Peripheral_Smear_Reading);
                System.out.println("\t [6] Platelet Count\t\t:\t₱ " + priceof.Platelet_Count);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\t CBC\t\t:\t₱ " + priceof.CBC);
                    case 2 -> System.out.println("\t CT/BT\t\t:\t₱ " + priceof.CT_BT);
                    case 3 -> System.out.println("\t Hgb/Hct\t:\t₱ " + priceof.Hgb_Hct);
                    case 4 ->
                        System.out.println("\t Peripheral Smear Staining\t:\t₱ " + priceof.Peripheral_Smear_Staining);
                    case 5 ->
                        System.out.println("\t Peripheral Smear Reading\t:\t₱ " + priceof.Peripheral_Smear_Reading);
                    case 6 -> System.out.println("\t Platelet Count\t:\t₱ " + priceof.Platelet_Count);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "CBC";
                    case 2 -> "CT/BT";
                    case 3 -> "Hgb/Hct";
                    case 4 -> "Peripheral Smear Staining";
                    case 5 -> "Peripheral Smear Reading";
                    case 6 -> "Platelet Count";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.CBC = price;
                    case 2 -> priceof.CT_BT = price;
                    case 3 -> priceof.Hgb_Hct = price;
                    case 4 -> priceof.Peripheral_Smear_Staining = price;
                    case 5 -> priceof.Peripheral_Smear_Reading = price;
                    case 6 -> priceof.Platelet_Count = price;
                }
                PriceDweller = -1;
            }
        }

    }

    public static void ClinicalMicroscopyPrices() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_editLaboratoryPricinh();
            System.err.println("Section Clinical Microscopy Category:");

            if (PriceDweller < 1) {
                System.out.println("\t [1] Fecalysis\t\t:\t₱ " + priceof.Fecalysis);
                System.out.println("\t [2] Occult Blood Test\t:\t₱ " + priceof.Occult_Blood_Test);
                System.out.println("\t [3] Pregnancy Test\t:\t₱ " + priceof.Pregnancy_Test);
                System.out.println("\t [4] Urinalysis\t\t:\t₱ " + priceof.Urinalysis);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\t Fecalysis\t\t:\t₱ " + priceof.Fecalysis);
                    case 2 -> System.out.println("\t Occult Blood Test\t:\t₱ " + priceof.Occult_Blood_Test);
                    case 3 -> System.out.println("\t Pregnancy Test\t\t:\t₱ " + priceof.Pregnancy_Test);
                    case 4 -> System.out.println("\t Urinalysis\t\t:\t₱ " + priceof.Urinalysis);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Fecalysis";
                    case 2 -> "Occult Blood Test";
                    case 3 -> "Pregnancy Test";
                    case 4 -> "Urinalysis";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.Fecalysis = price;
                    case 2 -> priceof.Occult_Blood_Test = price;
                    case 3 -> priceof.Pregnancy_Test = price;
                    case 4 -> priceof.Urinalysis = price;
                }
                PriceDweller = -1;
            }
        }

    }

    public static void BacteriologyPrices() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_editLaboratoryPricinh();
            System.err.println("Section Bacteriology Category:");

            if (PriceDweller < 1) { // Display part for prices
                System.out.println("\t [1] Sputum Exam/AFB\t:\t₱ " + priceof.Sputum_Exam_AFB);
                System.out.println("\t [2] Slit Skin Smear\t:\t₱ " + priceof.Slit_Skin_Smear);
                System.out.println("\t [3] Gram Stain\t\t:\t₱ " + priceof.Gram_Stain);
                System.out.println("\t [4] KOH Mount\t\t:\t₱ " + priceof.KOH_Mount);
                System.out.println("\t [5] RF/IgM\t\t:\t₱ " + priceof.RF_Igm);
                System.out.println("\t [6] Typhidot\t\t:\t₱ " + priceof.Typhidot);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\t Sputum Exam/AFB\t:\t₱ " + priceof.Sputum_Exam_AFB);
                    case 2 -> System.out.println("\t Slit Skin Smear\t:\t₱ " + priceof.Slit_Skin_Smear);
                    case 3 -> System.out.println("\t Gram Stain\t\t:\t₱ " + priceof.Gram_Stain);
                    case 4 -> System.out.println("\t KOH Mount\t\t:\t₱ " + priceof.KOH_Mount);
                    case 5 -> System.out.println("\t RF/IgM\t\t:\t₱ " + priceof.RF_Igm);
                    case 6 -> System.out.println("\t Typhidot\t\t:\t₱ " + priceof.Typhidot);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Sputum Exam/AFB";
                    case 2 -> "Slit Skin Smear";
                    case 3 -> "Gram Stain";
                    case 4 -> "KOH Mount";
                    case 5 -> "RF/IgM";
                    case 6 -> "Typhidot";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.Sputum_Exam_AFB = price;
                    case 2 -> priceof.Slit_Skin_Smear = price;
                    case 3 -> priceof.Gram_Stain = price;
                    case 4 -> priceof.KOH_Mount = price;
                    case 5 -> priceof.RF_Igm = price;
                    case 6 -> priceof.Typhidot = price;
                }
                PriceDweller = -1;
            }
        }

    }

    public static void BloodBankandSerologyPrices() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_editLaboratoryPricinh();
            System.err.println("Section Blood Bank and Serology Category:");

            if (PriceDweller < 1) { // Display part for prices
                System.out.println("\t [1] Blood Typing\t:\t₱ " + priceof.Blood_Typing);
                System.out.println("\t [2] HbSAg\t\t:\t₱ " + priceof.HbSAg);
                System.out.println("\t [3] HCV\t\t:\t₱ " + priceof.HCV);
                System.out.println("\t [4] HAV\t\t:\t₱ " + priceof.HAV);
                System.out.println("\t [5] Bleeding Fee\t:\t₱ " + priceof.Bleeding_Fee);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\t Blood Typing\t:\t₱ " + priceof.Blood_Typing);
                    case 2 -> System.out.println("\t HbSAg\t\t:\t₱ " + priceof.HbSAg);
                    case 3 -> System.out.println("\t HCV\t\t:\t₱ " + priceof.HCV);
                    case 4 -> System.out.println("\t HAV\t\t:\t₱ " + priceof.HAV);
                    case 5 -> System.out.println("\t Bleeding Fee\t:\t₱ " + priceof.Bleeding_Fee);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Blood Typing";
                    case 2 -> "HbSAg";
                    case 3 -> "HCV";
                    case 4 -> "HAV";
                    case 5 -> "Bleeding Fee";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.Blood_Typing = price;
                    case 2 -> priceof.HbSAg = price;
                    case 3 -> priceof.HCV = price;
                    case 4 -> priceof.HAV = price;
                    case 5 -> priceof.Bleeding_Fee = price;
                }
                PriceDweller = -1;
            }
        }
    }

    public static void ViewLaboratoryRecords() {
        clear();
        header();
        System.out.println("NOTE: This is only for Viewing no editing");
        System.out.println("\n--- Laboratory Records ---");
        for (String record : ViewLaboratoryRecords) {
            System.out.println(record);
        }
        System.out.print("Press Enter to continue...");
        command.nextLine();// use to halt view
    }

    // Room Admission Service Function
    public static void RoomandAdmissionServicesFunctions(int MultiShot) {
        int Id = 3;
        switch (MultiShot) {
            case 1 -> RegisterRoomNewAdmission();// line();//
            case 2 -> EditRoomInformation();// line();//
            case 3 -> ViewRoomRecords();// line();//
        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void RegisterRoomNewAdmission() {
        boolean endLoop = false;
        boolean CheckAccount_Recorded = false;
        boolean age_available = false;
        int Stage = 0;
        String firstname = "";
        String lastname = "";
        int Age = -1;
        String Date = " ";
        String Room_Type = "";
        double fee = 0;
        Pricing priceof = new Pricing();

        // Data Collection
        String Patient_Name = "";

        do {
            boolean pass = false;
            clear();
            header();
            System.out.println("----------Room and Admission Services---------");
            switch (Stage) {
                case 0 -> {// Firstname Input
                    System.out.print("Enter FirstName:\t");
                    firstname = command.nextLine();
                    pass = true;
                }
                case 1 -> {// Lastname input
                    System.err.println("FirtName: " + firstname);
                    System.out.print("Enter Lastname:\t");
                    lastname = command.nextLine();
                    pass = true;
                }
                case 2 -> {// Account Dupplication Check
                    try {
                        int search = db.checkSameAccount(firstname, lastname);
                        if (DEbuggMode) {
                            command.nextLine();
                        }

                        if (search >= 0 && !CheckAccount_Recorded) {
                            if (DEbuggMode) {
                                db.showAccount();
                            }
                            animation("Getting Duplicate... Done");
                            lastname = db.Getlastname();
                            firstname = db.Getfirstname();
                            age_available = db.AskAgeData();
                            CheckAccount_Recorded = true;
                        }

                        Patient_Name = lastname + ", " + firstname;
                        System.out.println("Patients name:\t" + Patient_Name);

                        if (!age_available && !CheckAccount_Recorded) {
                            System.out.print("Enter Age:\t");
                            String AgeComs = command.nextLine();
                            Age = Integer.parseInt(AgeComs);
                        } else {
                            animation("Fetching patients Age.....");
                            Age = db.GetAge();
                            System.out.println("Patient age:\t" + Age);
                        }

                        pass = true;
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        if (DEbuggMode) {
                            command.nextLine();
                        }
                    }
                }
                case 3 -> {// for date checking
                    clear();
                    header();
                    System.out.println("----------Register New Admission---------");
                    System.out.println("Patients name:\t" + Patient_Name);
                    System.out.println("Patient age:\t" + Age);
                    System.out.println(
                            "Enter Date:\tLAYOUT MUST BE \"00-00-0000\" [ Day-Month-Year]\n\tfill the fron with 0 if you only need single digit like 09 not 9");
                    System.out.print("[]-> \t");
                    Date = command.nextLine();

                    // Validate Date (Your existing date validation logic)
                    if (Date.length() != 10) {
                        System.out.println(
                                "Invalid input: The string must have exactly 10 characters, including dashes ('-').");
                    } else {
                        // Initialize variables
                        String[] parts = new String[3]; // Store the 3 sets (first, second, optional third)
                        int partIndex = 0;
                        StringBuilder currentPart = new StringBuilder();

                        // Loop through the string
                        for (int i = 0; i < Date.length(); i++) {
                            char ch = Date.charAt(i);

                            if (ch == '-') {
                                // When '-' is found, save the current part and reset
                                if (partIndex < 3) { // Prevent ArrayIndexOutOfBoundsException
                                    parts[partIndex] = currentPart.toString();
                                    partIndex++;
                                }
                                currentPart.setLength(0); // Clear the StringBuilder
                            } else {
                                // Append the character to the current part
                                currentPart.append(ch);
                            }
                        }

                        // Add the last part after the loop
                        if (partIndex < 3) { // Prevent ArrayIndexOutOfBoundsException
                            parts[partIndex] = currentPart.toString();
                        }

                        boolean checkpoint = false;
                        try {
                            for (int l = 0; l < parts.length; l++) {
                                boolean loopers = true;
                                int Check = Integer.parseInt(parts[l]);

                                switch (l) {
                                    case 0 -> {
                                        if (DEbuggMode) {
                                            System.out.println("First set: " + parts[0]);
                                            command.nextLine();
                                        }
                                        if (Check > 31) {
                                            loopers = false;
                                        }
                                    }
                                    case 1 -> {
                                        if (DEbuggMode) {
                                            System.out.println("Second set: " + parts[1]);
                                            command.nextLine();
                                        }
                                        if (Check > 12) {
                                            loopers = false;
                                        }
                                    }
                                    case 2 -> {
                                        if (DEbuggMode) {
                                            if (parts[2] != null && parts[2].length() == 4) {
                                                System.out.println("Third set: " + parts[2]);
                                            } else {
                                                System.out.println("No valid third set.");
                                            }
                                        }
                                        checkpoint = true;
                                    }
                                }
                                if (!loopers) {
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in date parts: " + e.getMessage());
                            if (DEbuggMode) {
                                command.nextLine();
                            }
                            break; // Exit the case if invalid input is detected
                        }

                        // Check if the date passed the validation
                        if (checkpoint) {
                            pass = true;
                        } else {
                            System.out.println("Invalid date format or out-of-range values.");
                        }
                        command.nextLine();
                    }
                }
                case 4 -> {// final checkpoint
                    // Select Room Type
                    clear();
                    header();
                    System.out.println("----------Room and Admission Services---------");
                    System.out.println("Patients name:\t" + Patient_Name);
                    System.out.println("Patient age:\t" + Age);
                    System.out.println("Date:\t" + Date);

                    System.out.println("Select Room Type:");
                    System.out.println("\t1. Service Ward");
                    System.out.println("\t2. Semi-Private Room");
                    System.out.println("\t3. Private Room");
                    System.out.println("\t4. Back to Room and Admission Menu");

                    int roomChoice = -1;
                    if (command.hasNextInt()) {
                        roomChoice = command.nextInt();
                        command.nextLine(); // Consume newline
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        command.nextLine(); // Clear invalid input
                        break;
                    }

                    // Process Room Choice
                    switch (roomChoice) {
                        case 1 -> {
                            Room_Type = "Service Ward";
                            fee = priceof.Service_Ward();
                            pass = true;
                        }
                        case 2 -> {
                            Room_Type = "Semi-Private Room";
                            fee = priceof.SemiPrivate_Room();
                            pass = true;
                        }
                        case 3 -> {
                            Room_Type = "Private Room";
                            fee = priceof.Private_Room();
                            pass = true;
                        }
                        case 4 -> {
                            endLoop = true; // Back to Room and Admission Menu
                        }
                        default -> {
                            System.out.println("Invalid room choice.");
                        }
                    }
                }
                case 5 -> {// saving point
                    // Register the admission
                    int patientIndex;
                    if (CheckAccount_Recorded) {
                        patientIndex = db.checkSameAccount(firstname, lastname);
                    } else {
                        patientIndex = db.addPatient(lastname, firstname, Age);
                    }

                    // Add room admission to account_lodge
                    db.patients.get(patientIndex).addAccountLodge("Room: " + Room_Type, Date);

                    // Add to ViewRoomRecords (for viewing purposes)
                    ViewRoomRecords.add("Name: " + Patient_Name + ", Date: " + Date + ", Room Type: " + Room_Type
                            + ", Fee: ₱" + fee);

                    System.out.println("Room Admission Registered! Total Fee: ₱" + fee);
                    endLoop = true;
                }
            }

            if (pass) {
                Stage++;
            }
        } while (!endLoop);
        db.clearFoundData();
    }

    public static void EditRoomInformation() {
        int MultiShot;
        do {
            clear();
            header();
            hsa_edit_rooms();
            System.out.println("Choice Which of the room you want to edit:");
            ls_edit_Rooms();
            System.err.print("Enter choice: --> ");
            String Cache = command.nextLine();
            MultiShot = Integer.parseInt(Cache);
            switch (MultiShot) {
                case 1 -> ServiceWardINFO();
                case 2 -> Semi_PrivateRoomINFO();
                case 3 -> PrivateRoomINFO();
                default -> System.err.println("error");
            }
            if (DEbuggMode) {
                System.err.println("laBpRI()->" + MultiShot);
                command.nextLine();
            }
        } while (MultiShot != 4);
    }

    public static void ServiceWardINFO() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_edit_rooms();
            System.err.println("Service Ward Total: " + priceof.Service_Ward());

            if (PriceDweller < 1) { // Display part for prices
                System.out.println("\t [1] Food\t\t\t:\t₱ " + priceof.Service_Ward_food);
                System.out.println("\t [2] Bedding\t\t\t:\t₱ " + priceof.Service_Ward_Bedding);
                System.out.println("\t [3] Room Boarding\t\t:\t₱ " + priceof.Service_Ward_Room_Board);
                System.out.println("\t [4] Waste Managenent\t\t:\t₱ " + priceof.Service_Ward_Waste_Mngt);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\tFood\t\t\t:\t₱ " + priceof.Service_Ward_food);
                    case 2 -> System.out.println("\tBedding\t\t\t:\t₱ " + priceof.Service_Ward_Bedding);
                    case 3 -> System.out.println("\tRoom Boarding\t\t:\t₱ " + priceof.Service_Ward_Room_Board);
                    case 4 -> System.out.println("\tWaste Managenent\t\t:\t₱ " + priceof.Service_Ward_Waste_Mngt);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Food";
                    case 2 -> "Bedding";
                    case 3 -> "Room Boarding";
                    case 4 -> "Waste Management";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.Service_Ward_food = price;
                    case 2 -> priceof.Service_Ward_Bedding = price;
                    case 3 -> priceof.Service_Ward_Room_Board = price;
                    case 4 -> priceof.Service_Ward_Waste_Mngt = price;
                }
                PriceDweller = -1;
            }
        }
    }

    public static void Semi_PrivateRoomINFO() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_edit_rooms();
            System.err.println("Semi-Private Room Total: " + priceof.SemiPrivate_Room());

            if (PriceDweller < 1) { // Display part for prices
                System.out.println("\t [1] Food\t\t\t:\t₱ " + priceof.SemiPrivate_Room_food);
                System.out.println("\t [2] Bedding\t\t\t:\t₱ " + priceof.SemiPrivate_Room_Bedding);
                System.out.println("\t [3] Room Boarding\t\t:\t₱ " + priceof.SemiPrivate_Room_Room_Board);
                System.out.println("\t [4] Waste Managenent\t\t:\t₱ " + priceof.SemiPrivate_Room_Waste_Mgnt);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\tFood\t\t\t:\t₱ " + priceof.SemiPrivate_Room_food);
                    case 2 -> System.out.println("\tBedding\t\t\t:\t₱ " + priceof.SemiPrivate_Room_Bedding);
                    case 3 -> System.out.println("\tRoom Boarding\t\t:\t₱ " + priceof.SemiPrivate_Room_Room_Board);
                    case 4 ->
                        System.out.println("\t Waste Managenent\t\t:\t₱ " + priceof.SemiPrivate_Room_Waste_Mgnt);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Food";
                    case 2 -> "Bedding";
                    case 3 -> "Room Boarding";
                    case 4 -> "Waste Management";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.SemiPrivate_Room_food = price;
                    case 2 -> priceof.SemiPrivate_Room_Bedding = price;
                    case 3 -> priceof.SemiPrivate_Room_Room_Board = price;
                    case 4 -> priceof.SemiPrivate_Room_Waste_Mgnt = price;
                }
                PriceDweller = -1;
            }
        }
    }

    public static void PrivateRoomINFO() {
        Pricing priceof = new Pricing();
        int PriceDweller = -1;

        while (true) {
            clear();
            header();
            hsa_edit_rooms();
            System.err.println("Private Room Total: " + priceof.Private_Room());

            if (PriceDweller < 1) { // Display part for prices
                System.out.println("\t [1] Food\t\t:\t₱ " + priceof.Private_Room_food);
                System.out.println("\t [2] Bedding\t\t:\t₱ " + priceof.Private_Room_Bedding);
                System.out.println("\t [3] Room Boarding\t\t:\t₱ " + priceof.Private_Room_Room_Board);
                System.out.println("\t [4] Waste Managenent\t\t:\t₱ " + priceof.Private_Room_Waste_Mngt);
                System.out.println("\t [0] Go Back");
            } else {
                switch (PriceDweller) {
                    case 1 -> System.out.println("\tFood\t\t\t:\t₱ " + priceof.Private_Room_food);
                    case 2 -> System.out.println("\tBedding\t\t\t:\t₱ " + priceof.Private_Room_Bedding);
                    case 3 -> System.out.println("\tRoom Boarding\t\t:\t₱ " + priceof.Private_Room_Room_Board);
                    case 4 ->
                        System.out.println("\t Waste Managenent\t\t:\t₱ " + priceof.Private_Room_Waste_Mngt);
                }
            }

            if (PriceDweller < 1) {
                try {
                    System.err.print("\tEnter choice: -->\t");
                    String nlab = command.nextLine();
                    PriceDweller = Integer.parseInt(nlab);
                    if (nlab.equals("0")) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            } else {
                String ednano = switch (PriceDweller) {
                    case 1 -> "Food";
                    case 2 -> "Bedding";
                    case 3 -> "Room Boarding";
                    case 4 -> "Waste Management";
                    default -> "ERROR";
                };
                System.err.print("Update " + ednano + " Price:\t₱ ");
                double price = command.nextDouble();
                command.nextLine();

                switch (PriceDweller) {
                    case 1 -> priceof.Private_Room_food = price;
                    case 2 -> priceof.Private_Room_Bedding = price;
                    case 3 -> priceof.Private_Room_Room_Board = price;
                    case 4 -> priceof.Private_Room_Waste_Mngt = price;
                }
                PriceDweller = -1;
            }
        }
    }

    public static void ViewRoomRecords() {
        clear();
        header();
        System.out.println("NOTE: This is only for Viewing no editing");
        System.out.println("\n--- Rooms Records ---");
        for (String record : ViewRoomRecords) {
            System.out.println(record);
        }
        System.out.print("Press Enter to continue...");
        command.nextLine();// use to halt view
    }

    // Transaction Records
    public static void TransactionRecordsFunctions(int MultiShot) {
        int Id = 4;
        switch (MultiShot) {
            case 1 -> ConsultationRecords();// line();//
            case 2 -> LaboratoryRecords();// line();//
            case 3 -> RoomRecords();// line();//

        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void ConsultationRecords() {
        int MultiShot;
        do {
            clear();
            header();
            consulation_Record(); // Display the menu for Consultation Records
            System.err.print("Enter choice: --> ");
            if (command.hasNextInt()) {
                MultiShot = command.nextInt();
                command.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                command.nextLine(); // Clear invalid input
                MultiShot = -1; // Keep looping
                continue;
            }

            switch (MultiShot) {
                case 1 -> OPDConsultationRecord();
                case 2 -> ERConsultationRecord();
                case 3 -> {
                    return; // Back to Transaction Records Menu
                }
                default -> System.out.println("Invalid choice.");
            }
        } while (MultiShot != 3);
    }

    public static void OPDConsultationRecord() {
        clear();
        header();
        System.out.println("----------- OPD Patients ----------");

        // Create a list to store OPD patients
        ArrayList<Patients_Database> opdPatients = new ArrayList<>();
        for (Patients_Database patient : db.patients) {
            for (String[] entry : patient.account_lodge) {
                if (entry[0].equals("OPD")) { // Check if the type is OPD
                    opdPatients.add(patient);
                    break; // Add patient only once, even if multiple OPD entries
                }
            }
        }
        if (opdPatients.isEmpty()) {
            System.out.println("No OPD Patients found.");
            System.out.println("\nPress Enter to continue...");
            command.nextLine(); // use to halt view
            return; // Early exit if no OPD patients
        } else {
            // Display the list of OPD patients
            for (int i = 0; i < opdPatients.size(); i++) {
                Patients_Database patient = opdPatients.get(i);
                System.out.println((i + 1) + ". " + patient.fullname + " (Patient ID: " + patient.PatientID + ")");
            }
            System.out.println((opdPatients.size() + 1) + ". Back to Consultation Record Menu");

            // Get the user's choice
            System.out.print("Enter choice: ");
            int choice = command.nextInt();
            command.nextLine(); // Consume newline

            if (choice >= 1 && choice <= opdPatients.size()) {
                // Display details for the selected patient
                Patients_Database selectedPatient = opdPatients.get(choice - 1);
                displayPatientRecord(selectedPatient, "OPD");
            } else if (choice == opdPatients.size() + 1) {
                return; // Go back to the previous menu
            } else {
                System.out.println("Invalid choice.");
            }
        }
        System.out.println("\nPress Enter to continue...");
        command.nextLine(); // use to halt view
    }

    public static void ERConsultationRecord() {
        clear();
        header();
        System.out.println("----------- ER Patients ----------");

        // Create a list to store ER patients
        ArrayList<Patients_Database> erPatients = new ArrayList<>();
        for (Patients_Database patient : db.patients) {
            for (String[] entry : patient.account_lodge) {
                if (entry[0].equals("ER")) { // Check if the type is ER
                    erPatients.add(patient);
                    break; // Add patient only once, even if multiple ER entries
                }
            }
        }
        if (erPatients.isEmpty()) {
            System.out.println("No ER Patients found.");
            System.out.println("\nPress Enter to continue...");
            command.nextLine(); // use to halt view
            return; // Early exit if no ER patients
        } else {
            // Display the list of ER patients
            for (int i = 0; i < erPatients.size(); i++) {
                Patients_Database patient = erPatients.get(i);
                System.out.println((i + 1) + ". " + patient.fullname + " (Patient ID: " + patient.PatientID + ")");
            }
            System.out.println((erPatients.size() + 1) + ". Back to Consultation Record Menu");

            // Get the user's choice
            System.out.print("Enter choice: ");
            int choice = command.nextInt();
            command.nextLine(); // Consume newline

            if (choice >= 1 && choice <= erPatients.size()) {
                // Display details for the selected patient
                Patients_Database selectedPatient = erPatients.get(choice - 1);
                displayPatientRecord(selectedPatient, "ER");
            } else if (choice == erPatients.size() + 1) {
                return; // Go back to the previous menu
            } else {
                System.out.println("Invalid choice.");
            }
        }
        System.out.println("\nPress Enter to continue...");
        command.nextLine(); // use to halt view
    }

    // Helper function to display patient details and consultation records
    private static void displayPatientRecord(Patients_Database patient, String type) {
        clear();
        header();
        System.out.println("---------- Record ----------");
        patient.show_PatientData();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Item                         Description                Amount");

        double totalAmount = 0;
        Pricing priceof = new Pricing();

        for (String[] entry : patient.account_lodge) {
            if (entry[0].equals(type)) {
                String item = type + " Consultation";
                String description = (type.equals("OPD")) ? "Out Patient Department" : "Emergency Room";
                double amount = (type.equals("OPD")) ? priceof.OPD : priceof.ER;
                totalAmount += amount;

                System.out.printf("%-28s %-25s ₱%.2f\n", item, description, amount);
            }
        }

        System.out.println("----------------------------------------------------------------");
        System.out.printf("                                                 Total Amount: ₱%.2f\n", totalAmount);
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nPress Enter to continue...");
        command.nextLine(); // use to halt view
    }

    public static void LaboratoryRecords() {
        int MultiShot;
        do {
            clear();
            header();
            laboratory_Record(); // Display the menu for Laboratory Records
            System.err.print("Enter choice: --> ");
            if (command.hasNextInt()) {
                MultiShot = command.nextInt();
                command.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                command.nextLine(); // Clear invalid input
                MultiShot = -1; // Keep looping
                continue;
            }

            switch (MultiShot) {
                case 1 -> BloodChemistryRecord();
                case 2 -> HematologyRecord();
                case 3 -> ClinicalMicroscopyRecord();
                case 4 -> BacteriologyRecord();
                case 5 -> BloodBankAndSerologyRecord();
                case 6 -> {
                    return; // Back to Transaction Records Menu
                }
                default -> System.out.println("Invalid choice.");
            }
        } while (MultiShot != 6);
    }

    public static void BloodChemistryRecord() {
        displayLaboratoryCategoryRecords("Blood Chemistry");
    }

    public static void HematologyRecord() {
        displayLaboratoryCategoryRecords("Hematology");
    }

    public static void ClinicalMicroscopyRecord() {
        displayLaboratoryCategoryRecords("Clinical Microscopy");
    }

    public static void BacteriologyRecord() {
        displayLaboratoryCategoryRecords("Bacteriology");
    }

    public static void BloodBankAndSerologyRecord() {
        displayLaboratoryCategoryRecords("Blood Bank and Serology");
    }

    // Helper function to display records for a specific laboratory category
    private static void displayLaboratoryCategoryRecords(String category) {
        clear();
        header();
        System.out.println("----------- " + category + " Patients ----------");

        // Create a list to store patients for the given category
        ArrayList<Patients_Database> categoryPatients = new ArrayList<>();
        for (Patients_Database patient : db.patients) {
            for (String[] entry : patient.account_lodge) {
                // Check if the first part matches the category
                if (entry[0].startsWith(category)) {
                    categoryPatients.add(patient);
                    break; // Add patient only once
                }
            }
        }

        if (categoryPatients.isEmpty()) {
            System.out.println("No " + category + " Patients found.");
            System.out.println("\nPress Enter to continue...");
            command.nextLine();
            return;
        }

        // Display the list of patients for the category
        for (int i = 0; i < categoryPatients.size(); i++) {
            Patients_Database patient = categoryPatients.get(i);
            System.out.println((i + 1) + ". " + patient.fullname + " (Patient ID: " + patient.PatientID + ")");
        }
        System.out.println((categoryPatients.size() + 1) + ". Back to Laboratory Record Menu");

        // Get the user's choice
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline

        if (choice >= 1 && choice <= categoryPatients.size()) {
            // Display details for the selected patient
            Patients_Database selectedPatient = categoryPatients.get(choice - 1);
            displayPatientLaboratoryRecord(selectedPatient, category);
        } else if (choice == categoryPatients.size() + 1) {
            return; // Go back to the previous menu
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("\nPress Enter to continue...");
        command.nextLine();
    }

    // Helper function to display patient details and laboratory records
    private static void displayPatientLaboratoryRecord(Patients_Database patient, String category) {
        clear();
        header();
        System.out.println("---------- Record ----------");
        patient.show_PatientData();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Item                         Description                     Amount");

        double totalAmount = 0;

        for (String[] entry : patient.account_lodge) {
            if (entry[0].startsWith(category)) {
                String labTest = entry[0]; // Get the full lab test name from account_lodge
                String description = getTestDescription(labTest); // Get description based on test
                double amount = getTestFeeRecords(category, labTest); // Use helper function
                totalAmount += amount;

                System.out.printf("%-28s %-30s ₱%.2f\n", labTest, description, amount);
            }
        }

        System.out.println("----------------------------------------------------------------");
        System.out.printf("                                                     Total Amount: ₱%.2f\n", totalAmount);
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nPress Enter to continue...");
        command.nextLine();
    }

    // Helper function to get the fee for a specific test
    private static double getTestFeeRecords(String category, String test) {
        Pricing priceof = new Pricing();

        // Extract the specific test from the labTest string (e.g., "Bua" from "Blood
        // Chemistry - Bua")
        String specificTest = test.substring(test.indexOf(" - ") + 3);

        return switch (category) {
            case "Blood Chemistry" -> switch (specificTest) {
                case "Bua" -> priceof.Bua;
                case "Bun" -> priceof.Bun;
                case "Cholesterol" -> priceof.Cholesterol;
                case "Creatinine" -> priceof.Creatine;
                case "FBS:RBS" -> priceof.FBS_RBS;
                case "Triglycerides" -> priceof.Triglycerides;
                case "AST/ GOT" -> priceof.AST_GOT;
                case "ALT/ GPT" -> priceof.AST_GPT;
                case "HDL/ LDL" -> priceof.HDL_LDL;
                default -> 0.0;
            };
            case "Hematology" -> switch (specificTest) {
                case "CBC" -> priceof.CBC;
                case "CT/BT" -> priceof.CT_BT;
                case "Hgb/Hct" -> priceof.Hgb_Hct;
                case "Peripheral Smear Staining" -> priceof.Peripheral_Smear_Staining;
                case "Peripheral Smear Reading" -> priceof.Peripheral_Smear_Reading;
                case "Platelet Count" -> priceof.Platelet_Count;
                default -> 0.0;
            };
            case "Clinical Microscopy" -> switch (specificTest) {
                case "Fecalysis" -> priceof.Fecalysis;
                case "Occult Blood Test" -> priceof.Occult_Blood_Test;
                case "Pregnancy Test" -> priceof.Pregnancy_Test;
                case "Urinalysis" -> priceof.Urinalysis;
                default -> 0.0;
            };
            case "Bacteriology" -> switch (specificTest) {
                case "Sputum Exam/ AFB" -> priceof.Sputum_Exam_AFB;
                case "Slit Skin Smear" -> priceof.Slit_Skin_Smear;
                case "Gram Stain" -> priceof.Gram_Stain;
                case "KOH Mount" -> priceof.KOH_Mount;
                case "RF/Igm" -> priceof.RF_Igm;
                case "Typhidot" -> priceof.Typhidot;
                default -> 0.0;
            };
            case "Blood Bank and Serology" -> switch (specificTest) {
                case "Blood Typing" -> priceof.Blood_Typing;
                case "HbSAg" -> priceof.HbSAg;
                case "HCV" -> priceof.HCV;
                case "HAV" -> priceof.HAV;
                case "Bleeding Fee" -> priceof.Bleeding_Fee;
                default -> 0.0;
            };
            default -> 0.0;
        };
    }

    // Helper function to get the description of a test
    private static String getTestDescription(String labTest) {
        // You can customize these descriptions as needed
        return switch (labTest) {
            case "Blood Chemistry - Bua" -> "Blood Uric Acid Test";
            case "Blood Chemistry - Bun" -> "Blood Urea Nitrogen Test";
            case "Blood Chemistry - Cholesterol" -> "Cholesterol Test";
            case "Blood Chemistry - Creatinine" -> "Creatinine Test";
            case "Blood Chemistry - FBS:RBS" -> "Fasting Blood Sugar/Random Blood Sugar Test";
            case "Blood Chemistry - Triglycerides" -> "Triglycerides Test";
            case "Blood Chemistry - AST/ GOT" -> "Aspartate Aminotransferase/Glutamic Oxaloacetic Transaminase Test";
            case "Blood Chemistry - ALT/ GPT" -> "Alanine Aminotransferase/Glutamic Pyruvic Transaminase Test";
            case "Blood Chemistry - HDL/ LDL" -> "High-Density Lipoprotein/Low-Density Lipoprotein Test";
            case "Hematology - CBC" -> "Complete Blood Count";
            case "Hematology - CT/BT" -> "Clotting Time/Bleeding Time";
            case "Hematology - Hgb/Hct" -> "Hemoglobin/Hematocrit";
            case "Hematology - Peripheral Smear Staining" -> "Peripheral Smear Staining";
            case "Hematology - Peripheral Smear Reading" -> "Peripheral Smear Reading";
            case "Hematology - Platelet Count" -> "Platelet Count";
            case "Clinical Microscopy - Fecalysis" -> "Fecalysis";
            case "Clinical Microscopy - Occult Blood Test" -> "Occult Blood Test";
            case "Clinical Microscopy - Pregnancy Test" -> "Pregnancy Test";
            case "Clinical Microscopy - Urinalysis" -> "Urinalysis";
            case "Bacteriology - Sputum Exam/ AFB" -> "Sputum Exam/Acid-Fast Bacilli";
            case "Bacteriology - Slit Skin Smear" -> "Slit Skin Smear";
            case "Bacteriology - Gram Stain" -> "Gram Stain";
            case "Bacteriology - KOH Mount" -> "KOH Mount";
            case "Bacteriology - RF/Igm" -> "Rheumatoid Factor/Immunoglobulin M";
            case "Bacteriology - Typhidot" -> "Typhidot";
            case "Blood Bank and Serology - Blood Typing" -> "Blood Typing";
            case "Blood Bank and Serology - HbSAg" -> "Hepatitis B Surface Antigen";
            case "Blood Bank and Serology - HCV" -> "Hepatitis C Virus";
            case "Blood Bank and Serology - HAV" -> "Hepatitis A Virus";
            case "Blood Bank and Serology - Bleeding Fee" -> "Bleeding Fee";
            default -> "Laboratory Test"; // Default description if not found
        };
    }

    public static void RoomRecords() {
        int MultiShot;
        do {
            clear();
            header();
            room_Record(); // Display the menu for Room Records
            System.err.print("Enter choice: --> ");
            if (command.hasNextInt()) {
                MultiShot = command.nextInt();
                command.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                command.nextLine(); // Clear invalid input
                MultiShot = -1; // Keep looping
                continue;
            }

            switch (MultiShot) {
                case 1 -> ServiceWardRoomRecord();
                case 2 -> SemiPrivateRoomRecord();
                case 3 -> PrivateRoomRecord();
                case 4 -> {
                    return; // Back to Transaction Records Menu
                }
                default -> System.out.println("Invalid choice.");
            }
        } while (MultiShot != 4);
    }

    public static void ServiceWardRoomRecord() {
        displayRoomCategoryRecords("Service Ward");
    }

    public static void SemiPrivateRoomRecord() {
        displayRoomCategoryRecords("Semi-Private Room");
    }

    public static void PrivateRoomRecord() {
        displayRoomCategoryRecords("Private Room");
    }

    // Helper function to display records for a specific room category
    private static void displayRoomCategoryRecords(String category) {
        clear();
        header();
        System.out.println("----------- " + category + " Patients ----------");

        // Create a list to store patients for the given category
        ArrayList<Patients_Database> categoryPatients = new ArrayList<>();
        for (Patients_Database patient : db.patients) {
            for (String[] entry : patient.account_lodge) {
                if (entry[0].startsWith("Room: " + category)) { // Check for "Room: " + category
                    categoryPatients.add(patient);
                    break; // Add patient only once
                }
            }
        }

        if (categoryPatients.isEmpty()) {
            System.out.println("No " + category + " Patients found.");
            System.out.println("\nPress Enter to continue...");
            command.nextLine();
            return;
        }

        // Display the list of patients for the category
        for (int i = 0; i < categoryPatients.size(); i++) {
            Patients_Database patient = categoryPatients.get(i);
            System.out.println((i + 1) + ". " + patient.fullname + " (Patient ID: " + patient.PatientID + ")");
        }
        System.out.println((categoryPatients.size() + 1) + ". Back to Room Record Menu");

        // Get the user's choice
        System.out.print("Enter choice: ");
        int choice = command.nextInt();
        command.nextLine(); // Consume newline

        if (choice >= 1 && choice <= categoryPatients.size()) {
            // Display details for the selected patient
            Patients_Database selectedPatient = categoryPatients.get(choice - 1);
            displayPatientRoomRecord(selectedPatient, category);
        } else if (choice == categoryPatients.size() + 1) {
            return; // Go back to the previous menu
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("\nPress Enter to continue...");
        command.nextLine();
    }

    // Helper function to display patient details and room records
    private static void displayPatientRoomRecord(Patients_Database patient, String category) {
        clear();
        header();
        System.out.println("---------- Record ----------");
        patient.show_PatientData();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Item                         Description                     Amount");

        double totalAmount = 0;

        for (String[] entry : patient.account_lodge) {
            if (entry[0].startsWith("Room: " + category)) {
                String roomType = entry[0];
                String description = getRoomDescription(category); // Get description of room
                double amount = getRoomFee(category); // Get fee based on category
                totalAmount += amount;

                System.out.printf("%-28s %-30s ₱%.2f\n", roomType, description, amount);
            }
        }

        System.out.println("----------------------------------------------------------------");
        System.out.printf("                                                     Total Amount: ₱%.2f\n", totalAmount);
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nPress Enter to continue...");
        command.nextLine();
    }

    // Helper function to get the fee for a specific room category
    private static double getRoomFee(String category) {
        Pricing priceof = new Pricing();
        return switch (category) {
            case "Service Ward" -> priceof.Service_Ward();
            case "Semi-Private Room" -> priceof.SemiPrivate_Room();
            case "Private Room" -> priceof.Private_Room();
            default -> 0.0; // Invalid category
        };
    }

    // Helper function to get the description for a room category
    private static String getRoomDescription(String category) {
        return switch (category) {
            case "Service Ward" -> "Service Ward Room";
            case "Semi-Private Room" -> "Semi-Private Room";
            case "Private Room" -> "Private Room";
            default -> "Room"; // Default description
        };
    }
}

// Makers Notes
/*
 * Nababaliw na ako sa bugs fixS
 * hahhahahah HAHAAHHAHAHA
 * bugs Encounter: 154
 */
