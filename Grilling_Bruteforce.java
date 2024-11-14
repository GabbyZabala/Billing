import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Grilling_Bruteforce extends ui {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> consultationFees = new HashMap<>();
    static HashMap<String, Double> labPrices = new HashMap<>();
    static ArrayList<String> consultationRecords = new ArrayList<>();
    static ArrayList<String> labRecords = new ArrayList<>();
    static ArrayList<String> admissionRecords = new ArrayList<>();

    /*
     * This one is a brute force of the code, well in fact the real code is on my
     * repository
     * github link: https://github.com/GabbyZabala/Billing
     * this one utilizing phasing not data structuring, if you check the real code
     * there's a
     * invisible bug, that is hard to trace for me on the function, like the counter
     * is not working
     * properly..
     * if your checking the prof of progress you can check on the real code, but
     * this one i
     * forgot to track the progress, its already to its functioning state,yeah
     * ⠀⠀⠀⠀⠀⠀⠀⣀⡤⠾⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⠒⠠⢀⠀⠀⠀⠀⠀⠀⠀
     * ⠀⠀⠀⠀⢀⡴⠚⢁⣀⣀⣀⣀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⡀⠁⠢⡀⠀⠀⠀⠀
     * ⠀⠀⢀⡴⢋⡠⠚⠁⠀⠀⠈⠻⠓⢄⠀⠀⢀⡏⠀⠀⠀⠀⠿⠷⢄⠈⠢⡀⠀⠀
     * ⠀⣠⠋⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀ ⡘⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀ ⠀⡇⠀⠐⠄⠀ MAH BAD
     * ⣸⠃⠀⠀⠳⣄⡀⣠⠖⠛⠓⠒⠊⠀⠀⠀⠀⠙⠒⠊⠉⠑⠦⠠⠊⠀⠀ ⠈⡄
     * ⡇⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀ ⠀⠀ .⢳
     * ⡇⠀⠀⠀⠀⠀⠀⠀⠀⢰⣶⣄⠀⣀⣀⣤⣄⣀⣼⣿⠇⠀⠀ ⠀⠀⠀ .⢸
     * ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⠟⡏⠀⡇⠀⢸⠈⡟⠉.⠀ ⠀⠀⠀ .⢸
     * ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠀⡇⠀⡇⠀⢸⠀⠸⡀.⠀⠀⠀⠀⠀⠀⠀ .⢸
     * ⢇⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠇⠀⠁⠀⠈⠀⠀⡇⡔⢲⠀⠀⠀ ⠀⠀⠀ .⡼
     * ⠈⡄⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠏⠀ ⡘⠀ ⠀⠀ ⠀ .⣰⠃
     * ⠀⠈⢄⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠰⠁⠀ ⠀ ⠀ ⢀⡾⠃⠀
     * ⠀⠀⠈⠢⡀⠀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀ ⢠⠃⠀ ⠀ ⠀⢀⡞⠁⠀⠀
     * ⠀⠀⠀⠀⠈⠢⢀⠀⠀⠀⠘⡄⠀⠀⠀⠀ ⠀⠀⡠⠁⠀ ⠀⣀⡤⠖⠋⠀⠀⠀⠀
     * ⠀⠀⠀⠀⠀⠀⠀⠙⠒⠦⣄⣈⣂⣤⣄⣀⣤⣊⣀⣠⠴⠛⠉⠀⠀⠀⠀⠀⠀⠀
     */
    public static void main(String[] args) {
        // Default prices
        consultationFees.put("OPD", 50.0);
        consultationFees.put("ER", 100.0);

        int choice;
        do {
            clear();
            header();
            main_Menu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> consultationServices();
                case 2 -> laboratoryServices();
                case 3 -> roomAdmissionServices();
                case 4 -> transactionRecords();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    public static void consultationServices() {
        int choice;
        do {
            clear();
            header();
            consultation_Services();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> registerConsultation();
                case 2 -> editConsultationFees();
                case 3 -> viewConsultationRecords();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    public static void registerConsultation() {
        clear();
        System.out.println("\n------------ Register New Consultation ------------");
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Consultation Date (MM/DD/YYYY): ");
        String date = scanner.nextLine();

        register_Consulatation();
        System.out.print("Choose consultation type: ");
        int type = scanner.nextInt();

        String typeStr = (type == 1) ? "OPD" : "ER";
        double fee = consultationFees.get(typeStr);
        consultationRecords
                .add("Name: " + name + ", Age: " + age + ", Date: " + date + ", Type: " + typeStr + ", Fee: ₱" + fee);
        System.out.println("Consultation Registered! Total Fee: ₱" + fee);
    }

    public static void editConsultationFees() {
        clear();
        header();
        hsa_edit_Consultation();
        consultationFees.forEach((type, price) -> System.out.println("Consultation " + type + ": ₱" + price));
        System.out.println("Select type to edit");
        edit_ConsultationBrute(1);
        int type = scanner.nextInt();
        String typeStr = (type == 1) ? "OPD" : "ER";

        System.out.print("Enter new price for " + typeStr + ": ₱");
        double newPrice = scanner.nextDouble();
        consultationFees.put(typeStr, newPrice);
        System.out.println("Consultation Fee Updated!");
        sleep(2000);
    }

    public static void viewConsultationRecords() {
        clear();
        System.out.println("\n--- Consultation Records ---");
        for (String record : consultationRecords) {
            System.out.println(record);
        }
        sleep(10000);
    }

    public static void laboratoryServices() {
        int choice;
        do {
            clear();
            System.out.println("\n------------ Laboratory Services ------------");
            System.out.println("1. Register New Laboratory Test");
            System.out.println("2. Edit Laboratory Pricing");
            System.out.println("3. View Laboratory Records");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> registerLaboratoryTest();
                case 2 -> editLabPricing();
                case 3 -> viewLabRecords();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    public static void registerLaboratoryTest() {
        clear();
        System.out.println("\n------------ Register New Laboratory Test ------------");
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Select Laboratory Category:");
        System.out.println("1. Blood Chemistry");
        System.out.println("2. Hematology");
        System.out.println("3. Clinical Microscopy");
        System.out.println("4. Bacteriology");
        System.out.println("5. Blood Bank and Serology");
        int category = scanner.nextInt();
        scanner.nextLine();

        String categoryStr = switch (category) {
            case 1 -> "Blood Chemistry";
            case 2 -> "Hematology";
            case 3 -> "Clinical Microscopy";
            case 4 -> "Bacteriology";
            case 5 -> "Blood Bank and Serology";
            default -> "Unknown";
        };

        labRecords.add("Name: " + name + ", Age: " + age + ", Category: " + categoryStr);
        System.out.println("Laboratory Test Registered under " + categoryStr);
    }

    public static void editLabPricing() {
        clear();
        System.out.println("\nEdit Laboratory Pricing - (Functionality to be implemented)");
    }

    public static void viewLabRecords() {
        clear();
        System.out.println("\n--- Laboratory Records ---");
        for (String record : labRecords) {
            System.out.println(record);
        }
    }

    public static void roomAdmissionServices() {
        clear();
        System.out.println("\nRoom Admission Services - (Functionality to be implemented)");
    }

    public static void transactionRecords() {
        clear();
        System.out.println("\nTransaction Records - (Functionality to be implemented)");
    }
}
