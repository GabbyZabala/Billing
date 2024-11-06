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

    public void Add_Account_Lodge(String name_input, int consulation_TorF) {// di ako marunong nung dynamic array eh
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
            int chosen_account = 0;// account that will be use as a storage with the combination of class storage
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
                                    String[] patientsidentifier = { "LastName", "FirstName", "Age" };
                                    int latel = patients_avalable;
                                    String[] Data_input = new String[2]; // For both string input
                                    int cdata_ageinput = 0; // For age input
                                    int repaciet = 0; // For Data input automation
                                    for (int patients_idno = 0; patients_idno < 2; patients_idno++) {
                                        clear();
                                        header();
                                        System.err.print(patients_idno + " - Enter Patient Name:\n");
                                        switch (patients_idno) {
                                            case 2:
                                                System.out.print("\t" + patientsidentifier[patients_idno - 2] + ":\t"
                                                        + Data_input[repaciet - 1] + "\n");
                                            case 1:
                                                System.out.print("\t" + patientsidentifier[patients_idno - 1] + ":\t"
                                                        + Data_input[repaciet] + "\n");
                                            case 0:
                                                System.out.print("\t" + patientsidentifier[patients_idno] + ":\t");
                                                break;
                                        }

                                        // Case sensitive handling here, to be modified if needed
                                        if (patients_idno != 2) {
                                            String data = command.nextLine(); // Read input from the user
                                            if (patients_avalable != 0) {
                                                System.err.print("Searching for possible patients.");
                                                for (int check = 0; check < patients.length; check++) {
                                                    if (data.equals(patients[check].lastname)) { // Using .equals for
                                                                                                 // string comparison
                                                        user[user_count] = check;
                                                    }
                                                    if (check < 10) {
                                                        System.err.println(".");
                                                    } else {
                                                        if (check == 10) {
                                                            System.err.println("Too many Patients Data please wait.");
                                                        }
                                                    }
                                                }
                                                System.err.println("Here are some results:");
                                                for (int show_check = 0; show_check < user.length; show_check++) {
                                                    System.out.print("[ " + (show_check + 1) + " ]");
                                                    patients[user[show_check]].show_PatientsData();
                                                }
                                                System.out.println(
                                                        "If the patient you're looking for is listed, please input accordingly.");
                                            } else {
                                                System.err.println("No patients are present in the database.");
                                                Data_input[repaciet] = data;
                                            }
                                            repaciet++;
                                        } else {
                                            // Collecting integer input for age
                                            int cidata = command.nextInt();
                                            cdata_ageinput = cidata;
                                            command.nextLine(); // Clear newline from buffer to avoid skipping next
                                                                // input
                                        }
                                        sleep(10); // Add any necessary delay here
                                    }

                                    if (patients_avalable == 0) {
                                        chosen_account = 0;
                                    }
                                    // Add patient data to chosen account
                                    patients[chosen_account].add_Patients_Data(Data_input[0], Data_input[1],
                                            cdata_ageinput);
                                    if (latel - 1 == chosen_account) {
                                        patients_avalable++;
                                    }
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