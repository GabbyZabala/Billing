import java.util.Scanner;

class Patients_Data {
    String lastname;
    String firstname;
    String name;
    int age;
    String Bloodtype;
    int account_usage = 0;
    String[] account_lodge = new String[99];// 99 for max usage of the account that can carry
    int consultation_data_usage = 0;
    String[] consultation_data = new String[99];// for date purposes

    public void add_Patients_Data(String last, String first, int age) { // Constructor
        this.lastname = last;
        this.firstname = first;
        this.name = last +", "+ first;
        this.age = age;
    }// Node pass na this

    public void show_PatientsData() {
        System.out.println("PATIENTS NAME:\t" + name);
        System.out.println("-- AGE:\t" + age);
    }
    
    public void Add_Account_Lodge(String name_input, int consulation_TorF) {// di ako marunong nung dynamic array eh
        this.account_lodge[account_usage] = name_input;
        this.account_usage++;
    }
    public void Add_Consultation(String date){
        this.consultation_data[consultation_data_usage] = date;
        this.consultation_data_usage++;
    }
    public void show_PatientsHistory(){
        for (String lata: this.account_lodge) {
            if(lata !=null){

            }
        }
    }
}

public class Grilling extends ui {
    public static boolean noterror_dis = true;

    public static void Display_Screen(int screen) {
        switch (screen) {
            case 0:main_Menu();break;
            case 1:consultation_Services();break;// +10
            case 2:laboratory_Services();break;// +20
            case 3:room_Record();break;// +30
            case 4:transaction_Records();break;// +40
            case 11:register_Consulatation();break;
            case 12:edit_Consultation();break;
            case 13:// view Consultation records
                break;
            case 21:ls_newLaboratorytest();break;
            case 22:// Edit Laboratory Pricing
                break;
            case 23:// view lab records
                break;
            case 24:ls_category_blood_Chemistry();break;// +3 registrar
            case 25:hematology();break;// +4
            case 26:clinical_Microscopy();break; // +5
            case 27:bacteriology();break;// +6
            case 28:bloodBank_Serology();break;// +7
            case 31:register_Admission();break;
            case 32:edit_Rooms();break;
            case 41:consulation_Record();break;
            case 42:laboratory_Record();break;
            case 43:room_Record();break;
            default:
                Error_Desktop();
                noterror_dis = false;
                break;
        }
    }

    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);
        Patients_Data[] patients = new Patients_Data[90];// for records and data
        for(int i = 0; i < patients.length; i++){
            patients[i] = new Patients_Data();
        }
        clear();
        loading_Animation();
        // animation("Loading.....");
        clear();
        Boolean loop = true, force = noterror_dis;
        int locale = 0;// Display location replant
        int revert = 0;// Function access will be added here start layout | layer 1 | layer 2| layer 3
                       // | so on
        while (loop) {
            clear();
            header();
            Display_Screen(locale);
            System.err.print("\tEnter choice: -->\t");
            int Terminate = command.nextInt();
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
                                locale =  Terminate + 20;
                                revert = 20;
                                break;
                            case 2:
                            case 3:
                                break;
                            case 4:
                                locale = 0;
                                revert = 0;
                            default:
                                break;
                        }
                        break;
                    }
                case 3:
                    break;
                case 4:
                    break;
                case 10:
                    break;
                case 20:
                    break;
                case 30:
                    break;
                case 40:
                    break;
                default:
                    break;
                
            }
            clear(); // Clear the console
            animation("Loading.....");
        }
        command.close();// happy now COMPILER ^v^ kainis pangit tingan namay yellow eh XD
    }
}