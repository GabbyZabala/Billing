import java.util.Arrays;// for auto reset on my array, idk reddits suggestion
import java.util.Scanner;

class Patients_Data {// Patients Database
    String lastname;
    String firstname;
    String fullname;
    int age = 0;
    String Bloodtype;
    int account_usage = 0;
    String[] account_lodge = new String[99];// 99 for max usage of the account that can carry
    int consultation_data_usage = 0;
    String[] consultation_data = new String[99];// for date purposes
    /*
     * Constructor Below
     * Node pass na this
     */

    public void add_Patients_Data(String last, String first, int age) {
        this.lastname = last;
        this.firstname = first;
        this.fullname = last + ", " + first;
        this.age = age;
    }

    public void show_PatientsData() {
        System.out.print("PATIENTS FULLNAME:\t" + fullname);
        System.out.println("\t---Details: First[ " + firstname + " ] Last [ " + lastname + " ]");
        System.out.println("-- AGE:\t\t" + (age == 0 ? "[ NO DATA ] " : age));
        System.out.println("-- BLOODTYPE:\t" + (Bloodtype == null ? "[ NO DATA ] " : Bloodtype));
    }

    public void Add_Bloodtype(String Blood) {
        this.Bloodtype = Blood;
    }

    public void Add_Account_Lodge(String name_input) {// di ako marunong nung dynamic array eh
        this.account_lodge[account_usage] = name_input;
        this.account_usage++;
    }

    public void Add_Consultation(String date) {
        this.consultation_data[consultation_data_usage] = date;
        this.consultation_data_usage++;
    }

    public boolean Scan_Consultation() {
        int blanka = 0;
        for (int i = 0; i < account_lodge.length; i++) {// scanning purposess
            if (account_lodge[i] != null) {
                if (account_lodge[i].equals("OPD") || account_lodge[i].equals("ER")) {
                    blanka++;
                }
            }
        }
        if (blanka != 0)
            return true;
        else
            return false;
    }

    public void View_Conconsultation() {
        int opdCount = 0, erCount = 0, vias = 0;
        for (int i = 0; i < account_lodge.length; i++) {
            if (account_lodge[i] != null) {
                if (account_lodge[i].equals("OPD")) {
                    opdCount++;
                    System.out.println("OPD - " + consultation_data[vias]);
                    vias++;
                } else if (account_lodge[i].equals("ER")) {
                    erCount++;
                    System.out.println("ER - " + consultation_data[vias]);
                    vias++;
                }
            }
        }
        if (opdCount == 0) {
            System.out.println("No OPD data recorded.");
        }
        if (erCount == 0) {
            System.out.println("No ER data recorded.");
        }
    }

    public void show_PatientsHistory() {
        int con = 0;
        for (int i = 1; i < 3; i++) {
            if (i != 2) {
                System.out.println(
                        "-------------------------------------------------------------------------------------");
            } else {
                for (String lata : this.account_lodge) {
                    if (lata != null) {
                        System.out.print("\n\tActivity Log: " + lata);
                        if (lata.equals("OPD") || lata.equals("ER")) {
                            System.out.println("\tDate: " + consultation_data[con]);
                            con++;
                        }
                        System.err.println(
                                "\t------------------------------------------");
                    }
                }
            }
        }
    }
}

public class Grilling extends ui {
    public static boolean DebugMode = true;// turn off this function if your gonna use it for presentation
    // needed to be a global variable
    public static boolean noterror_dis = true;
    public static Patients_Data[] patients = new Patients_Data[90];// for records and data
    public static int patients_avalable = 0;
    static {// for initializing class to bring slot to more patients
        for (int i = 0; i < patients.length; i++) {// di ko alam kung may list library yung same sa c++
            patients[i] = new Patients_Data();
        }
    }
    public static int[] user = new int[90];// storage for possible user to be bind with
    public static int user_count = 0;
    public static int chosen_account = 1;// account that will be use as a storage with the combination of class storage
    // just the code history in my github account
    // https://github.com/GabbyZabala/Billing
    // too tired to explain T^T

    static class Pricing {// Pricing Properties
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

    public static Pricing priceof = new Pricing();

    public static void Display_Screen(int screen) {// This void is for display Properties
        boolean tring;
        tring = Display_Properties(screen); // ang haba kasi nung display_propeties kaya ginawan ko ng paraan
        if (!tring) { // ang sakit kasi sa kamay mag scroll up eh XD
            noterror_dis = false;
        }
    }

    public static void main(String[] args) {
        try (Scanner command = new Scanner(System.in)) {
            clear();
            loading_Animation();
            // animation("Loading.....");
            clear();
            Boolean loop = true, force = noterror_dis;
            int locale = 0;// Display location replant
            int revert = 0;// Function access will be added here start layout | layer 1 | layer 2| layer 3
                           // | so on
            // function
            int Terminate = 0;
            while (loop) {
                boolean errorblocker = false;
                clear();
                System.err.println("AppStatus:/Local/" + locale + "/rev/" + revert + "/Ter/" + Terminate + "/acc/"
                        + patients_avalable);
                header();
                Display_Screen(locale);
                System.err.print("\tEnter choice: -->\t");
                if (revert % 10 != 0 || revert == 0) {
                    try {
                        String Terminated = command.nextLine();
                        Terminate = Integer.parseInt(Terminated);
                    } catch (NumberFormatException e) {
                        errorblocker = true;
                    }
                }
                if (!errorblocker) {
                    switch (revert) {
                        case 0:
                            if (force) {
                                switch (Terminate) {
                                    case 1:// goto Consultation Service
                                    case 2:// goto laboratory
                                    case 3:// goto room and admin
                                    case 4:
                                        locale = Terminate;// transaction records
                                        revert = Terminate;
                                        break;
                                    case 5:// exit
                                        clear();
                                        sleep(1000);
                                        animation("Exiting programm...");
                                        loop = false;
                                        break;
                                    default:// start ka dito lowbat na me
                                        locale = 0;
                                        revert = 0;
                                        break;
                                }
                                break;
                            }
                        case 1:// goto Consultation Service
                            if (force) {
                                switch (Terminate) {
                                    case 1:
                                    case 2:
                                    case 3:
                                        locale = Terminate + 10;
                                        revert = 10;
                                        break;
                                    case 4:
                                        locale = 0;
                                        revert = 0;
                                    default:
                                        break;
                                }
                                break;
                            }
                        case 2:
                            if (force) {
                                switch (Terminate) {
                                    case 1:
                                        locale = Terminate + 20;
                                        revert = 20;
                                        break;
                                    case 2:
                                    case 3:
                                        System.err.println("\n No Variables is included here yet...");
                                        sleep(1000);
                                        break;
                                    case 4:
                                        locale = 0 // i just realize i have free will whawhahwhawhwhahwa
                                        ;// whaaaa XD
                                        revert = 0 // no one can stop me hahhahahaha
                                        ;// LMAO
                                    default: // la ako magawa bahang baha dito sa bahay XD
                                        break;
                                }
                                break;
                            }
                        case 3:
                            if (force) {
                                switch (Terminate) {
                                    case 1:
                                    case 2:
                                        locale = Terminate + 30;
                                        revert = 30;
                                        break;
                                    case 3:
                                        System.err.println("\n No Variables is included here yet...");
                                        sleep(1000);
                                        break;
                                    case 4:
                                        locale = 0;
                                        revert = 0;
                                }
                                break;
                            }
                        case 4:
                            if (force) {
                                switch (Terminate) {
                                    case 1:
                                    case 2:
                                    case 3:
                                        locale = Terminate + 40;
                                        revert = 40;
                                        break;
                                    case 4:
                                        locale = 0;
                                        revert = 0;
                                }
                                break;
                            }
                        case 10:// Registration Functions heehe
                            if (force) {
                                switch (Terminate) {
                                    case 1: // Register new consultation
                                        consultation_function1(command);
                                        locale = 1;
                                        revert = 1;
                                        break;
                                    case 2:
                                        consultation_function2(command);
                                        /*
                                         * command imported due to some error that
                                         * i didnt know that but chatgpt suggested
                                         * i import scanner not create a duplicate
                                         * so yeah learned in a hard way, there's
                                         * first time on everything
                                         */
                                        revert = 1;
                                        locale = 1;
                                        break;
                                    case 3:
                                        consultation_function3(command);
                                        revert = 1;
                                        locale = 1;
                                        break;
                                }
                                break;
                            }
                        case 20:// Laborartory Functions
                            break;
                        case 30:// Room and Acdmission Functions
                            break;
                        case 40:// Records Functions
                            break;
                        default:
                            noterror_dis = false;
                            break;
                    }
                }
                clear(); // Clear the console
                animation("Loading.....");
            }
        }
        // this problem here fix,
        // command.close();// happy now COMPILER ^v^ kainis pangit tingan namay yello eh
        // XD
    }

    // New registration
    public static void consultation_function1(Scanner command) {// dont judge me i just learned this one ^v^ - Kurt
        String[] conclu_option = { "FirstName", "LastName", "Age" };// Optional loopers
        String[] conclu_input = new String[3];// System Concluder
        // Add chose if input is finished so the data can be mastered fast
        boolean Patient_found = false;
        for (int crea = 0; crea < conclu_option.length; crea++) {
            clear();
            header();
            hsa_register_Consulatation();
            switch (crea) {
                case 2:
                case 1:
                    if (conclu_input[1] != null) {
                        System.out.println(
                                "Enter Patient Name:\t" + conclu_input[1]
                                        + ", " + conclu_input[0]);
                    } else {
                        System.out.println("Patient " + conclu_option[crea - 1] + ":\t"
                                + conclu_input[crea - 1]);
                    }
                default:
                    System.out.print("Enter Patient " + conclu_option[crea] + ":\t");
                    break;
            }
            String conclu_coms = command.nextLine();
            if (crea != 2) {
                conclu_input[crea] = conclu_coms;
            } else {
                try {
                    int number_catcher = Integer.parseInt(conclu_coms);
                    conclu_input[crea] = conclu_coms;
                    System.out.println(number_catcher);
                } catch (NumberFormatException e) {
                    System.err.println("try again");
                    crea--;
                }
            }
            if (crea != 2 && patients_avalable != 0) {// checking for duplicates
                System.out.print("Searching the database/");
                for (int patientID = 0; patientID < patients.length; patientID++) {
                    if (patientID < 5) {
                        System.out.print(".");
                    }
                    String comparison = "";// compares if action found~~
                    switch (crea) {
                        case 1: // Use the patient's last name for comparison
                            if (patients[patientID].lastname != null) {
                                comparison = patients[patientID].lastname;
                                System.out.println(comparison);
                            }
                            break;
                        default: // Default to first name
                            if (patients[patientID].firstname != null) {
                                comparison = patients[patientID].firstname;
                                System.out.println(comparison);
                            }
                            break;
                    }
                    if (comparison != null) {
                        // for debugging purposes!!!
                        if (DebugMode) {
                            System.out.print(
                                    patientID + "Comparing patient: " + (comparison != null ? comparison : "null"));
                            System.out.print("With input: "
                                    + (conclu_input[crea] != null ? conclu_input[crea]
                                            : "null")
                                    + "\n");
                        }
                        // Check if the comparison value matches the input
                        if (comparison.equalsIgnoreCase(conclu_input[crea])) {
                            user[user_count] = patientID;// sana diako mamali sakit sa ulo mag
                            // recheck ng code XD
                            user_count++;
                            Patient_found = true;
                            System.err.println("\tFound");
                        }
                    }
                }
                String casolore = (user_count > 2 ? "some" : "is");
                String status = (Patient_found ? "Found" : "Not Found");
                System.out.print("Patient " + casolore + " " + status);
                if (DebugMode)
                    command.nextLine();
                else
                    sleep(1000);

            }
            if (Patient_found) {
                clear();
                int choices = 0;
                boolean lanml = false;
                while (true) {
                    System.err.println("Input the patient you want to choose");
                    for (int foundPatientData = 0; foundPatientData < user_count; foundPatientData++) {
                        System.out.println("[ " + foundPatientData + " ]");
                        patients[user[foundPatientData]].show_PatientsData();
                    }
                    System.out.print("Pls Enter The Patient or type [" + user_count
                            + "] to cancel the sel3ction\n\t:-->");
                    try {
                        String lan = command.nextLine();
                        choices = Integer.parseInt(lan);
                        if (choices == user_count) {
                            lanml = true;
                            Arrays.fill(user, 0);// for reset purposes the rest here
                            user_count = 0;
                            Patient_found = false;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("retry handling./.");
                    }
                }
                if (!lanml) {
                    boolean lo = false;
                    for (int i = 0; i < user_count; i++) {
                        if (choices == user[i]) {
                            lo = true;
                        }
                    }
                    if (lo) {
                        chosen_account = choices + 1;
                        conclu_input[0] = patients[chosen_account - 1].firstname;
                        conclu_input[1] = patients[chosen_account - 1].lastname;
                        conclu_input[2] = patients[chosen_account - 1].age + "";
                        break;
                    }
                } else {
                    if (crea == 1) {
                        clear();
                        header();
                        hsa_register_Consulatation();
                        System.out.println("Enter Patient Name:\t" + conclu_input[1] + ", " + conclu_input[0]);
                        System.out.println("Enter Patients Suffix[ex: Jr, Sr, etc]:\t");
                        String suffix = command.nextLine();
                        conclu_input[1] += " " + suffix;
                    }
                }
            }
        }
        String[] comrad = new String[3];
        String[] qoutes = { "Day", "Month", "Year" };
        String fname = conclu_input[1] + ", " + conclu_input[0];
        for (int dateLine = 0; dateLine < comrad.length; dateLine++) {
            clear();
            header();
            hsa_register_Consulatation();
            System.out.print("Patient Name:\t" + fname
                    + "\nPatient Age:\t" + conclu_input[2]
                    + "\nEnter the Layout in this order[ Day/Month/Year] type \"~\" to go back in date\nEnter "
                    + qoutes[dateLine] + ":\t");
            switch (dateLine) {
                case 2:
                    System.err.print(comrad[dateLine - 2] + "/");
                case 1:
                    System.err.print(comrad[dateLine - 1] + "/");
                default:
                    break;
            }
            try {
                String Date = command.nextLine();
                int number_checker = Integer.parseInt(Date);
                System.out.print(number_checker);
                comrad[dateLine] = Date;
            } catch (NumberFormatException e) {
                if (dateLine != 0) {
                    dateLine -= 2;
                }
            }
        }
        String nano = "";
        for (int dlan = 0; dlan < comrad.length; dlan++) {
            nano += comrad[dlan];
            if (dlan != 2) {
                nano += "/";
            }
        }
        while (true) {
            clear();
            header();
            boolean exit = false, saveprocess = true;
            hsa_register_Consulatation();
            System.out.print("Patient Name:\t" + fname
                    + "\nPatient Age:\t" + conclu_input[2]
                    + "\nConsulation Date:\t" + nano + "\n");
            register_Consulatation();
            try {
                System.out.print("[]:-->");
                String nan = "";
                String blan = command.nextLine();
                int blaconsule = Integer.parseInt(blan);
                switch (blaconsule) {
                    case 1:
                        nan = "OPD";
                        exit = true;
                        break;
                    case 2:
                        nan = "ER";
                        exit = true;
                        break;
                    case 3:
                        return;
                }
                if (saveprocess) {
                    patients[chosen_account].Add_Account_Lodge(nan);
                    patients[chosen_account].Add_Consultation(nano);
                }
                if (exit) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error..");// place holder di kasi nacacatchyung error
                                            // eh
            }
        }
        if (!Patient_found) {// registers new patients
            if (patients[patients_avalable] == null) {
                chosen_account = patients_avalable;
            }
            patients_avalable++;
            int addy = Integer.parseInt(conclu_input[2]);
            patients[chosen_account].add_Patients_Data(conclu_input[1], conclu_input[0], addy);
        }
        Arrays.fill(conclu_input, null);
    }

    // Change Price in Consultation
    public static void consultation_function2(Scanner command) {
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

    // View Consultation lodge
    public static void consultation_function3(Scanner command) {// Function 3 is bugged
        boolean showUtils = true;
        int[][] index = new int[90][3];
        int row = 0;
        int column = 0;
        int stotal = 0;

        // Populate the index array based on available patients
        for (int scanned = 0; scanned < patients.length; scanned++) {
            if (patients[scanned] != null) {
                if (patients[scanned].Scan_Consultation()) {
                    index[column][row] = scanned + 1;
                    row++;
                    if (row >= 3) {
                        row = 0;
                        column++;
                    }
                    stotal++;
                }
            }
        }
        clear();
        // System.out.println("!!Debugging purpose!!\nStatus:\t" + stotal + "\nRow\t" +
        // row + "\nColumn:\t" + column);
        sleep(1000);
        if (stotal != 0) {
            // Main loop for displaying and navigating pages
            for (int i = 0; i <= column; i++) {
                clear();
                header();
                // Display patients on the current page
                for (int y : index[i]) {
                    if (y != 0) {
                        System.out.println("[ " + (y - 1) + " ]");
                        patients[y - 1].show_PatientsData();
                        patients[y - 1].View_Conconsultation();
                        line();
                    }
                }

                records_pages_indecator(showUtils, i, column);

                // Get user input
                System.err.print("\t[]:-->");
                String input = command.nextLine();
                char clad = input.charAt(0);
                if (!showUtils && (clad == 'T' || clad == 't')) {// Toggle `showUtils` if 'T' or 't' is pressed
                    showUtils = true;
                }
                // Page navigation handling
                switch (clad) {
                    case '1': // Next page
                        if (i < column)
                            i++;
                        else
                            System.out.println("No more pages.");
                        break;
                    case '2': // Previous page
                        if (i > 0)
                            i--;
                        else
                            System.out.println("Already on the first page.");
                        break;
                    case '3': // Exit consultation view
                        return;
                    default:
                        System.out.println("Invalid command.");
                }
                sleep(1000);
            }
            sleep(1000);
        } else {
            clear();
            header();
            System.out.println("No Data is Present!!");
            sleep(5000);
        }
    }

}