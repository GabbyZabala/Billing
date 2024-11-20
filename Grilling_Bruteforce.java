import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*NOTICE BOARD
     * You can check the previews notice board on 
     * github link: https://github.com/GabbyZabala/Billing
     * just click on the file>BLAME
     * 
     * error lab data handling need to be proccess, saving seems errer 
     */
public class Grilling_Bruteforce extends ui {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> consultationFees = new HashMap<>();
    static HashMap<String, Double> labPrices = new HashMap<>();
    static ArrayList<String> consultationRecords = new ArrayList<>();
    static ArrayList<String> labRecords = new ArrayList<>();
    static ArrayList<String> admissionRecords = new ArrayList<>();
    static {
        // Default prices
        // For Consultation
        consultationFees.put("OPD", 50.0);
        consultationFees.put("ER", 100.0);

        // For Laboratory
        labPrices.put("Blank - No Data", 0.00);
        // +1 below
        labPrices.put("Blood Chemistry - Bua", 160.00);
        labPrices.put("Blood Chemistry - Bun", 160.00);
        labPrices.put("Blood Chemistry - Cholesterol", 160.00);
        labPrices.put("Blood Chemistry - Creatinine", 195.00);
        labPrices.put("Blood Chemistry - FBS:RBS", 160.00);
        labPrices.put("Blood Chemistry - Triglycerides", 250.00);
        labPrices.put("Blood Chemistry - AST/ GOT", 200.00);
        labPrices.put("Blood Chemistry - ALT/ GPT", 200.00);
        labPrices.put("Blood Chemistry - HDL/ LDL", 300.00);
        // +10 below
        labPrices.put("Hematology - CBC\t\t\t", 250.00);
        labPrices.put("Hematology - CT/BT\t\t\t", 100.00);
        labPrices.put("Hematology - Hgb/Hct\t\t\t", 100.00);
        labPrices.put("Hematology - Peripheral Smear Staining\t", 100.00);
        labPrices.put("Hematology - Peripheral Smear Reading\t", 300.00);
        labPrices.put("Hematology - Platelet Count\t", 250.00);
        // +16 below
        labPrices.put("Clinical Microscopy - Fecalysis", 100.00);
        labPrices.put("Clinical Microscopy - Occult Blood Test", 100.00);
        labPrices.put("Clinical Microscopy - Pregnancy Test", 150.00);
        labPrices.put("Clinical Microscopy - Urinalysis", 125.00);
        // +20 below
        labPrices.put("Bacteriology - Sputum Exam/ AFB", 130.00);
        labPrices.put("Bacteriology - Slit Skin Smear", 130.00);
        labPrices.put("Bacteriology - Gram Stain", 130.00);
        labPrices.put("Bacteriology - KOH Mount", 130.00);
        labPrices.put("Bacteriology - RF/Igm", 450.00);
        labPrices.put("Bacteriology - Typhidot", 550.00);
        // +26 below
        labPrices.put("Blood Bank and Serology - Blood Typing", 65.00);
        labPrices.put("Blood Bank and Serology - HbSAg", 230.00);
        labPrices.put("Blood Bank and Serology - HCV", 350.00);
        labPrices.put("Blood Bank and Serology - HAV", 350.00);
        labPrices.put("Blood Bank and Serology - Bleeding Fee", 200.00);

    }

    public static void main(String[] args) {

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
            scanner.nextLine();
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
        header();
        hsa_register_Consulatation();
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
        edit_ConsultationBrute(0);
        int type = scanner.nextInt();
        String typeStr = "";
        switch (type) {
            case 1:
            case 2:
                typeStr = (type == 1) ? "OPD" : "ER";
                break;
            case 3:
                return;
        }

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
        System.out.print("Press Enter to continue...");
        scanner.nextLine();

    }

    public static void laboratoryServices() {
        int choice;
        do {
            clear();
            header();
            laboratory_Servicesbrute();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
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
        do {
            clear();
            hsa_newLaboratoryTest();

            // Patient Information
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Patient Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Display available tests
            System.out.println("\nAvailable Laboratory Tests:");
            ls_newLaboratorytest();
            System.out.print("\nEnter test choice: ");
            int testChoice = scanner.nextInt();

            // Select test category and return selected test
            int testIndex = switch (testChoice) {
                case 1 -> regLabBloodChemistry(name, age);
                case 2 -> regLabHematology(name, age);
                case 3 -> regLabClinicalMicroscopyy(name, age);
                case 4 -> regLabBacteriology(name, age);
                case 5 -> regLabBloodBankandSerology(name, age);
                default -> -1; // Invalid choice
            };

            if (testIndex == -1) {
                System.out.println("\nInvalid Test Choice! Please try again.");
                sleep(3000);
                return; // Exit
            } else {
                return;
            }
        } while (true);
    }

    public static int regLabBloodChemistry(String PatientName, int PatientAge) {
        do {
            clear();
            header();
            hsa_newLaboratoryTest();

            // Filtered list to store valid test names
            ArrayList<String> validTests = new ArrayList<>();// storage for found samples
            int counting = 1;

            // Display valid tests with correct numbering
            for (String blockCategory : labPrices.keySet()) {
                if (blockCategory.matches("^Blood Chemistry.*")) {
                    System.out.printf("%d. %s...........................\t₱ %.2f\n", counting++, blockCategory,
                            labPrices.get(blockCategory));
                    validTests.add(blockCategory);// adds the data to make to propely structured
                }
            }

            System.out.print("\nEnter Choice:\t");
            int blockChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (blockChoice >= 1 && blockChoice <= validTests.size()) {
                // Get selected test details
                String test = validTests.get(blockChoice - 1);
                double fee = labPrices.get(test);

                // Display selected test and fee
                clear();
                System.out.println("\nSelected Test: " + test + " | Fee: ₱" + fee);

                // Register test
                labRecords.add("Name: " + PatientName + ", Age: " + PatientAge + ", Test: " + test + ", Fee: ₱" + fee);
                System.out.println("\nRegistration Complete!");
                sleep(3000);
                return blockChoice; // Return the choice index
            } else {
                System.out.println("Invalid Choice! Please try again.");
                sleep(2000);
            }
        } while (true); // Repeat until a valid choice is made
    }

    public static int regLabHematology(String PatientName, int PatientAge) {
        do {
            clear();
            header();
            hsa_newLaboratoryTest();

            // Filtered list to store valid test names
            ArrayList<String> validTests = new ArrayList<>();// storage for found samples
            int counting = 1;

            // Display valid tests with correct numbering
            for (String blockCategory : labPrices.keySet()) {
                if (blockCategory.matches("^Hematology.*")) {
                    System.out.printf("%d. %s...........................\t₱ %.2f\n", counting++, blockCategory,
                            labPrices.get(blockCategory));
                    validTests.add(blockCategory);// adds the data to make to propely structured
                }
            }

            System.out.print("\nEnter Choice:\t");
            int blockChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (blockChoice >= 1 && blockChoice <= validTests.size()) {
                // Get selected test details
                String test = validTests.get(blockChoice - 1);
                double fee = labPrices.get(test);

                // Display selected test and fee
                clear();
                System.out.println("\nSelected Test: " + test + " | Fee: ₱" + fee);

                // Register test
                labRecords.add("Name: " + PatientName + ", Age: " + PatientAge + ", Test: " + test + ", Fee: ₱" + fee);
                System.out.println("\nRegistration Complete!");
                sleep(3000);
                return blockChoice; // Return the choice index
            } else {
                System.out.println("Invalid Choice! Please try again.");
                sleep(2000);
            }
        } while (true); // Repeat until a valid choice is made
    }

    public static int regLabClinicalMicroscopyy(String PatientName, int PatientAge) {
        do {
            clear();
            header();
            hsa_newLaboratoryTest();
            // Filtered list to store valid test names
            ArrayList<String> validTests = new ArrayList<>();// storage for found samples
            int counting = 1;

            // Display valid tests with correct numbering
            for (String blockCategory : labPrices.keySet()) {
                if (blockCategory.matches("^Clinical Microscopy.*")) {
                    System.out.printf("%d. %s...........................\t₱ %.2f\n", counting++, blockCategory,
                            labPrices.get(blockCategory));
                    validTests.add(blockCategory);// adds the data to make to propely structured
                }
            }

            System.out.print("\nEnter Choice:\t");
            int blockChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (blockChoice >= 1 && blockChoice <= validTests.size()) {
                // Get selected test details
                String test = validTests.get(blockChoice - 1);
                double fee = labPrices.get(test);

                // Display selected test and fee
                clear();
                System.out.println("\nSelected Test: " + test + " | Fee: ₱" + fee);

                // Register test
                labRecords.add("Name: " + PatientName + ", Age: " + PatientAge + ", Test: " + test + ", Fee: ₱" + fee);
                System.out.println("\nRegistration Complete!");
                sleep(3000);
                return blockChoice; // Return the choice index
            } else {
                System.out.println("Invalid Choice! Please try again.");
                sleep(2000);
            }
        } while (true);
    }

    public static int regLabBacteriology(String PatientName, int PatientAge) {
        do {
            clear();
            header();
            hsa_newLaboratoryTest();
            // Filtered list to store valid test names
            ArrayList<String> validTests = new ArrayList<>();// storage for found samples
            int counting = 1;

            // Display valid tests with correct numbering
            for (String blockCategory : labPrices.keySet()) {
                if (blockCategory.matches("^Bacteriology.*")) {
                    System.out.printf("%d. %s...........................\t₱ %.2f\n", counting++, blockCategory,
                            labPrices.get(blockCategory));
                    validTests.add(blockCategory);// adds the data to make to propely structured
                }
            }

            System.out.print("\nEnter Choice:\t");
            int blockChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (blockChoice >= 1 && blockChoice <= validTests.size()) {
                // Get selected test details
                String test = validTests.get(blockChoice - 1);
                double fee = labPrices.get(test);

                // Display selected test and fee
                clear();
                System.out.println("\nSelected Test: " + test + " | Fee: ₱" + fee);

                // Register test
                labRecords.add("Name: " + PatientName + ", Age: " + PatientAge + ", Test: " + test + ", Fee: ₱" + fee);
                System.out.println("\nRegistration Complete!");
                sleep(3000);
                return blockChoice; // Return the choice index
            } else {
                System.out.println("Invalid Choice! Please try again.");
                sleep(2000);
            }
        } while (true);
    }

    public static int regLabBloodBankandSerology(String PatientName, int PatientAge) {
        do {
            clear();
            header();
            hsa_newLaboratoryTest();
            // Filtered list to store valid test names
            ArrayList<String> validTests = new ArrayList<>();// storage for found samples
            int counting = 1;

            // Display valid tests with correct numbering
            for (String blockCategory : labPrices.keySet()) {
                if (blockCategory.matches("^Blood Bank and Serology..*")) {
                    System.out.printf("%d. %s...........................\t₱ %.2f\n", counting++, blockCategory,
                            labPrices.get(blockCategory));
                    validTests.add(blockCategory);// adds the data to make to propely structured
                }
            }

            System.out.print("\nEnter Choice:\t");
            int blockChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (blockChoice >= 1 && blockChoice <= validTests.size()) {
                // Get selected test details
                String test = validTests.get(blockChoice - 1);
                double fee = labPrices.get(test);

                // Display selected test and fee
                clear();
                System.out.println("\nSelected Test: " + test + " | Fee: ₱" + fee);

                // Register test
                labRecords.add("Name: " + PatientName + ", Age: " + PatientAge + ", Test: " + test + ", Fee: ₱" + fee);
                System.out.println("\nRegistration Complete!");
                sleep(3000);
                return blockChoice; // Return the choice index
            } else {
                System.out.println("Invalid Choice! Please try again.");
                sleep(2000);
            }
        } while (true);
    }

    public static void viewLabRecords() {
        clear();
        System.out.println("\n--- Laboratory Records ---");
        for (String record : labRecords) {
            System.out.println(record);
        }
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public static void editLabPricing() {
        clear();
        System.out.println("\n------------ Edit Laboratory Pricing ------------");

        // Display available tests
        int index = 1;
        for (String test : labPrices.keySet()) {
            System.out.printf("%d. %s...........................₱ %.2f\n", index++, test, labPrices.get(test));
        }

        System.out.print("\nEnter test to edit: ");
        int testChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String test = labPrices.keySet().toArray(new String[0])[testChoice - 1];
        System.out.print("Enter new price for " + test + ": ₱");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        labPrices.put(test, newPrice);
        System.out.println("\nLaboratory Fee Updated!");
        sleep(3000);
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
