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
            case 2 -> EditConsultationFees();
            case 3 -> line();// ViewConsultationRecords();
        }
        if (DEbuggMode) {
            System.err.println(MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void RegisterNewConsultation() {

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

    public static void LaboratoryServicesFunctions(int MultiShot) {
        int Id = 2;
        switch (MultiShot) {
            case 1 -> line();// RegisterNewLaboratoryTest();
            case 2 -> LaboratoryPricing();
            case 3 -> line();// ViewLaboratoryRecords();
        }
        if (DEbuggMode) {
            System.err.println("lab()->" + MultiShot);
            command.nextLine();
        }
        locale = Remstart = Id;
    }

    public static void LaboratoryPricing() {
        int MultiShot = 0;
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
