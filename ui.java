import java.util.Random;

public class ui {
    public static void header() {
        System.out.println("======= Hospital Billing=======");
    }

    public static void main_Menu() {// Data number: 0
        String[] choices = { "Consultation Services", "Laboratory Services", "Room and Admission Services",
                "Transaction Records", "Exit" };
        System.out.println("-----------Main Menu----------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }

    }

    public static void consultation_Services() {// Data number: 1
        String[] choices = { "Register New Consultation", "Edit Consultation Fees", "View Consultation Records",
                "Back to Main Menu" };
        System.out.println("----------Consultation Services---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // Cosultation Service START here
    public static void hsa_register_Consulatation() {
        System.out.println("----------Register New Consultation---------");
    }

    public static void register_Consulatation() {
        String[] choices = { "OPD Consultation", "ER Consultation", "Back to Consultation Services Menu" };
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void hsa_edit_Consultation() {
        System.out.println("----------Edit Consultation Fee---------");
    }

    public static void edit_Consultation() {
        String[] choices = { "Consultation OPD", "Consultation ER", "Exit" };
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void edit_ConsultationBrute(int type1toremoveexit) {
        String[] choices = { "Consultation OPD", "Consultation ER", "Exit" };
        for (int i = 0; i < choices.length - type1toremoveexit; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // Cosultation Service END here
    public static void laboratory_Services() {// Data number: 2
        String[] choices = { "Register New Laboratory Test", "Edit Laboratory Pricing", "View Laboratory Records",
                "Back to Main Menu" };
        System.out.println("----------Laboratory Services---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // Cosultation Service END here
    public static void laboratory_Servicesbrute() {// Data number: 2
        String[] choices = { "Register New Laboratory Test", "Edit Laboratory Pricing", "View Laboratory Records",
                "Back to Main Menu" };
        System.out.println("----------Laboratory Services---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // LAB SERVICE START HERE
    public static void hsa_newLaboratoryTest() {
        System.out.println("------------ Register New Laboratory Test ------------");
    }

    public static void hsa_editLaboratoryPricinh() {
        System.out.println("----------Edit Laboratory Fee---------");
    }

    public static void ls_newLaboratorytest() {
        String[] choices = { "Blood Chemistry", "Hermatology", "Clinical Microscopy", "Bacteriology",
                "Blood Bank and Serology", "Back to Laboratory Services Menu" };
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void ls_category_blood_Chemistry() {
        String[] choices = { "Bua", "Bun", "Cholesterol", "Createnine", "FBS:RBS", "Triglycerides", "AST/ GOT",
                "ALT/ GPT", "HDL/ LDL", "Back" };
        System.out.println("----------Blood Chemistry---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void hematology() {
        String[] choices = { "CBC", "CT/BT", "Hgb/Hct", "Pheripheral Smear Staining", "Pheripheral Smear Reading",
                "Platelet Count", "Prothrombintime", "Back" };
        System.out.println("----------Hematology---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void clinical_Microscopy() {
        String[] choices = { "Fecalysis", "Occult Blood Test", "Pregnancy Test", "Urinalysis", "Back" };
        System.out.println("----------Clinical Microscopy---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void bacteriology() {
        String[] choices = { "Sputum Exam/ AFB", "Slit Skin Smear", "Gram Stain", "KOH Mount", "RF/Igm", "Typhidot",
                "Back" };
        System.out.println("----------Bacteriology---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void bloodBank_Serology() {
        String[] choices = { "Blood Typing", "HbSAg", "HCV", "HAV", "Bleeding Fee", "Back" };
        System.out.println("----------Blood Bank and Serology---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // LAB SERVICE END HERE
    public static void room_Services() {// Data number: 3
        String[] choices = { "Register New Admission", "Edit Room Informtaion", "View Room Records",
                "Back to Main Menu" };
        System.out.println("----------Room and Admission Services---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // Room SERVICE START HERE
    public static void register_Admission() {
        String[] choices = { "Service Ward", "Semi-Primitive Room", "Private Room", "Back to Room and Admission Menu" };
        System.out.println("----------Register New Admission---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void hsa_edit_rooms() {
        System.out.println("----------Edit Rooms---------");
    }

    public static void ls_edit_Rooms() {
        String[] choices = { "SERVICE WARD INFO", "SEMI-PRIVATE ROOM INFO", "PRIVATE ROOM", "Exit" };
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // ROOM SERVER ENDS HERE
    public static void transaction_Records() {// Data number: 4
        String[] choices = { "Consultation Records", "Laboratory Records", "Room Admission Records",
                "Back to Main Menu" };
        System.out.println("----------Transaction Records---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // TRANSACTION RECORDS START HERE
    public static void consulation_Record() {
        String[] choices = { "Consultation History", "Exit" };
        System.out.println("----------Consultation Record---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void laboratory_Record() {
        String[] choices = { "Blood Chemistry", "Hematology", "Clinical Microcopy", "Bacteriology",
                "Blood Bank and Serology", "Exit" };
        System.out.println("----------Laborartory Record---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    public static void room_Record() {
        String[] choices = { "SERVICE WARD History", "SEMI-PRIVATE ROOM History", "PRIVATE ROOM History", "Exit" };
        System.out.println("----------Room Record---------");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ": " + choices[i]);
        }
    }

    // TRANSACTION RECORDS ENDS HERE
    public static void Error_Desktop() {
        String lines = "\n\t--------------------------------------------";
        for (int i = 0; i <= 3; i++) {
            if (i % 2 != 0) {
                System.err.println(lines);
            } else {
                System.err.println(
                        "\n\t\tYou found the error display Screen\n\tidk how you got here but nice.. \n\n\tpls exit the app.. - Kurt");
            }
        }
    }

    // Function detailes on GRILLING
    public static void clear() {// clear function
        if (System.getProperty("os.name").contains("Windows")) {// for console using
            // For Windows
            System.out.print("\033c");
        } else {
            // For Linux/macOS
            System.out.print("\033[H\033[2J"); // ANSI escape code for clearing
            System.out.flush();
        }
    }

    public static void animation(String input) {
        for (int i = 0; i < input.length(); ++i) {
            System.out.print(input.charAt(i));
            sleep(1); // Adjust the delay in milliseconds
        }
    }

    public static void sleep(int numbers) {// sleep function
        try {
            Thread.sleep(numbers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomNum(int maxNumber) {
        Random ran = new Random();
        int labelnumber = ran.nextInt(maxNumber);
        return labelnumber;
    }

    public static void loading_Animation() {// just a loading animation nothing special here
        boolean animation_finish = true;
        int max_number = 40;
        int queue_number = 0;
        while (animation_finish) {
            System.err.println("Loading...");
            System.err.println(" ----------------------------------------");
            System.err.print("|");
            for (int i = 1; i <= queue_number; i++) {
                System.err.print("#");
            }
            for (int x = 1; x <= max_number; x++) {
                System.err.print(" ");
            }
            System.err.print("|\n");
            System.out.println(" ----------------------------------------");

            queue_number += randomNum(20);
            if (queue_number > 40) {
                queue_number = 40;
                animation_finish = false;
            } else {
                max_number = 40 - queue_number;
            }
            sleep(1000);
            clear();
        }
    }

    public static boolean Display_Properties(int lanpla) {
        switch (lanpla) {
            case 0 -> main_Menu();
            case 1 -> consultation_Services();// +10
            case 2 -> laboratory_Services();// +20
            case 3 -> room_Services();// +30
            case 4 -> transaction_Records();// +40
            case 11 -> register_Consulatation();
            case 12 -> edit_Consultation();
            case 13 -> hsa_edit_Consultation();// view Consultation records
            case 21 -> ls_newLaboratorytest();
            // case 22 Edit Laboratory Pricing
            // case 23 view lab records
            case 24 -> ls_category_blood_Chemistry();// +3 registrar
            case 25 -> hematology();// +4
            case 26 -> clinical_Microscopy(); // +5
            case 27 -> bacteriology();// +6
            case 28 -> bloodBank_Serology();// +7
            case 31 -> register_Admission();
            // case 32 -> edit_Rooms();
            case 41 -> consulation_Record();
            case 42 -> laboratory_Record();
            case 43 -> room_Record();
            case 101 -> System.out.println();// blank display
            default -> {
                Error_Desktop();
                return false;
            }
        }
        return true;
    }

    public static void line() {
        System.out.println("==================================================");
    }

    public static void records_pages_indecator(boolean showTools, int TotalStatus, int max_number) {
        String[] stamp = { "Previous", "Next", "Exit" };
        System.out.println("\nGuide tools: " + (showTools ? "^\t [ Press T to show Tools]" : "v"));
        if (max_number != 0) {
            if (showTools) {
                for (int i = (TotalStatus != 0 || TotalStatus != max_number ? 0 : 1); i < stamp.length; i++) {
                    // ang sakit mag dynamic ng display hays
                    System.out.println("\t[ " + (i + 1) + " ]\t"
                            + stamp[(TotalStatus != max_number ? i : (TotalStatus == 1 ? 0 : i))]);
                    /*
                     * naka redbull pala ako ngayon kaya kung gumana to
                     * diko na sure kung pano to nangyare XDDD
                     */
                }
            }
        } else {
            System.out.println("\t[ 3 ]\t" + stamp[2] + "\n");
        }
    }
}