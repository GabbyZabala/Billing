import java.util.Arrays;
import java.util.Scanner;

class Patients_Data {
    String lastname;
    String firstname;
    String fullname;
    int age;
    String Bloodtype;
    int account_usage = 0;
    String[] account_lodge = new String[99];// 99 for max usage of the account that can carry
    int consultation_data_usage = 0;
    String[] consultation_data = new String[99];// for date purposes

    public void add_Patients_Data(String last, String first, int age) { // Constructor
        this.lastname = last;
        this.firstname = first;
        this.fullname = last + ", " + first;
        this.age = age;
    }// Node pass na this

    public void show_PatientsData() {
        System.out.print("PATIENTS FULLNAME:\t" + fullname);
        System.out.println("\t---Details: First[ " + firstname + " ] Last [ " + lastname + " ]");
        System.out.println("-- AGE:\t\t" + age);
        System.out.println("-- BLOODTYPE:\t" + Bloodtype);
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
                            System.err.print("\tDate: " + consultation_data[con] + "\n");
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
    public static boolean noterror_dis = true;

    static class Pricing {
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

    public static void Display_Screen(int screen) {
        switch (screen) {
            case 0:
                main_Menu();
                break;
            case 1:
                consultation_Services();
                break;// +10
            case 2:
                laboratory_Services();
                break;// +20
            case 3:
                room_Record();
                break;// +30
            case 4:
                transaction_Records();
                break;// +40
            case 11:
                register_Consulatation();
                break;
            case 12:
                edit_Consultation();
                break;
            case 13:// view Consultation records
                break;
            case 21:
                ls_newLaboratorytest();
                break;
            case 22:// Edit Laboratory Pricing
                break;
            case 23:// view lab records
                break;
            case 24:
                ls_category_blood_Chemistry();
                break;// +3 registrar
            case 25:
                hematology();
                break;// +4
            case 26:
                clinical_Microscopy();
                break; // +5
            case 27:
                bacteriology();
                break;// +6
            case 28:
                bloodBank_Serology();
                break;// +7
            case 31:
                register_Admission();
                break;
            case 32:
                edit_Rooms();
                break;
            case 41:
                consulation_Record();
                break;
            case 42:
                laboratory_Record();
                break;
            case 43:
                room_Record();
                break;
            default:
                Error_Desktop();
                noterror_dis = false;
                break;
        }
    }

    public static void main(String[] args) {
        try (Scanner command = new Scanner(System.in)) {
            Pricing[] priceof = new Pricing[1];
            priceof[0] = new Pricing();// For Pricing
            Patients_Data[] patients = new Patients_Data[90];// for records and data

            for (int i = 0; i < patients.length; i++) {
                patients[i] = new Patients_Data();
            }
            int patients_avalable = 0;
            clear();
            loading_Animation();
            // animation("Loading.....");
            clear();
            Boolean loop = true, force = noterror_dis;
            int locale = 0;// Display location replant
            int revert = 0;// Function access will be added here start layout | layer 1 | layer 2| layer 3
                           // | so on
            int[] user = new int[90];// storage for possible user to be bind with
            int user_count = 0;
            int chosen_account = 1;// account that will be use as a storage with the combination of class storage
            // function
            int Terminate = 0;
            while (loop) {
                clear();
                System.err.println("AppStatus:/Local/" + locale + "/rev/" + revert + "/acc/" + patients_avalable);
                header();
                Display_Screen(locale);
                System.err.print("\tEnter choice: -->\t");
                if (revert % 10 != 0 || revert == 0) {
                    int Terminated = command.nextInt();
                    Terminate = Terminated;
                    command.nextLine();
                }
                switch (revert) {
                    case 0:
                        if (force) {
                            switch (Terminate) {
                                case 1:// goto Consultation Service
                                case 2:// goto laboratory
                                case 3:// goto room and admin
                                case 4:
                                    locale = Terminate;// transaction records
                                    break;
                                case 5:// exit
                                    clear();
                                    sleep(1000);
                                    animation("Exiting programm...");
                                    loop = false;
                                    break;
                                default:// start ka dito lowbat na me
                                    locale = 0;
                                    break;
                            }
                            revert = Terminate;
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
                                default:
                                    locale = 0;
                                    revert = 0;
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
                                                    System.out.println("Enter Patient Name:\t" + conclu_input[crea - 1]
                                                            + ", " + conclu_input[crea - 2]);
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
                                        if (patients_avalable != 0 && crea != 2) {// checking for duplicates
                                            System.out.print("Searching the database/");
                                            for (int i = 0; i < patients.length; i++) {
                                                if (i < 5) {
                                                    System.out.print(".");
                                                }
                                                String comparison = "";// compares if action found~~
                                                switch (crea) {
                                                    case 1: // Use the patient's last name for comparison
                                                        if (patients[i].lastname != null) {
                                                            comparison = patients[i].lastname;
                                                        }
                                                        break;
                                                    default: // Default to first name
                                                        if (patients[i].firstname != null) {
                                                            comparison = patients[i].firstname;
                                                        }
                                                        break;
                                                }
                                                if (comparison != null) {
                                                    // for debugging purposes!!!
                                                    // System.out.println("Comparing patient: " + comparison);
                                                    // System.out.println("With input: "
                                                    // + (conclu_input[crea] != null ? conclu_input[crea]
                                                    // : "null"));
                                                    // sleep(5000);
                                                    // Check if the comparison value matches the input
                                                    if (comparison.equalsIgnoreCase(conclu_input[crea])) {
                                                        user[user_count] = i;// sana diako mamali sakit sa ulo mag
                                                                             // recheck ng code XD
                                                        user_count++;
                                                        Patient_found = true;
                                                    }
                                                }
                                            }
                                            String casolore = (user_count > 2 ? "some" : "is");
                                            String status = (Patient_found ? "Found" : "Not Found");
                                            System.out.print("Patient " + casolore + " " + status);

                                        }
                                        if (Patient_found) {
                                            clear();
                                            int choices;
                                            while (true) {
                                                System.err.println("Input the patient you want to choose");
                                                for (int i = 0; i < user_count; i++) {
                                                    System.out.println("[ " + i + " ]");
                                                    patients[user[i]].show_PatientsData();
                                                }
                                                System.out.print("Pls Enter The Patient or type [" + user_count
                                                        + "] to cancel the sel3ction\n\t:-->");
                                                try {
                                                    String lan = command.nextLine();
                                                    choices = Integer.parseInt(lan);
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("retry handling./.");
                                                }
                                            }
                                            boolean lo = false;
                                            for (int i = 0; i < user_count; i++) {
                                                if (choices == user[i]) {
                                                    lo = true;
                                                }
                                            }
                                            if (lo) {
                                                chosen_account = choices + 1;
                                                break;
                                            }
                                        }
                                    }
                                    if (!Patient_found) {// registers new patients
                                        if (patients[patients_avalable].equals(null)) {
                                            chosen_account = patients_avalable;
                                        }
                                        int addy = Integer.parseInt(conclu_input[2]);
                                        patients[chosen_account - 1].add_Patients_Data(conclu_input[1], conclu_input[0],
                                                addy);
                                        patients_avalable++;
                                    }
                                    String[] comrad = new String[3];
                                    String[] qoutes = { "Day", "Month", "Year" };
                                    for (int i = 0; i < comrad.length; i++) {
                                        clear();
                                        header();
                                        hsa_register_Consulatation();
                                        System.out.print("Patient Name:\t" + patients[chosen_account - 1].fullname
                                                + "\nPatient Age:\t" + patients[chosen_account - 1].age
                                                + "\nEnter the Layout in this order[ Day/Month/Year] type \"~\" to go back in date\nEnter "
                                                + qoutes[i] + ":\t");
                                        switch (i) {
                                            case 2:
                                                System.err.print(comrad[i - 2] + "/");
                                            case 1:
                                                System.err.print(comrad[i - 1] + "/");
                                            default:
                                                break;
                                        }
                                        try {
                                            String Date = command.nextLine();
                                            int number_checker = Integer.parseInt(Date);
                                            System.out.print(number_checker);
                                            comrad[i] = Date;
                                        } catch (NumberFormatException e) {
                                            if (i != 0) {
                                                i--;
                                                i--;
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
                                        System.out.print("Patient Name:\t" + patients[chosen_account - 1].fullname
                                                + "\nPatient Age:\t" + patients[chosen_account - 1].age
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
                                                    exit = true;
                                                    saveprocess = false;
                                                    break;
                                            }
                                            if (saveprocess) {
                                                patients[chosen_account - 1].Add_Account_Lodge(nan);
                                                patients[chosen_account - 1].Add_Consultation(nano);
                                            }
                                            if (exit) {
                                                break;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.print("Error..");// place holder di kasi nacacatchyung error eh
                                        }
                                    }
                                    locale = 0;
                                    revert = 0;
                                    Arrays.fill(user, 0);// for reset purposes the rest here
                                    user_count = 0;
                                    Arrays.fill(conclu_input, null);
                                    break;
                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:

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
                clear(); // Clear the console
                animation("Loading.....");
            }
        }
        // this problem here fix,
        // command.close();// happy now COMPILER ^v^ kainis pangit tingan namay yello eh
        // XD
    }
}