public class ui{
    public static void header() {
        System.out.println("== Hospital Billing=======");  
    }
    public static void main_Menu(){
        String [] choices = {"Consultation Services","Laboratory Services","Room and Admission Services","Transaction Records","Exit"};
        System.out.println("-----------Main Menu----------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }     
    }
    public static void consultation_Services(){
        String [] choices = {"Register New Consultation","Edit Consultation Fees","View Consultation Records","Back to Main Menu"};
        System.out.println("----------Consultation Services---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }     
    }
    public static void register_Consulatation(){
        String [] choices = {"OPD Consultation","ER Consultation","Back to Consultation Services Menu"};
        System.out.println("----------Register New Consultation---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }     
    public static void edit_Consultation(){
        String [] choices = {"Consultation OPD","Consultation ER","Exit"};
        System.out.println("----------Edit Consultation Fee---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void laboratory_Services(){
        String [] choices = {"Register New Laboratory Test","Edit Laboratory Pricing","View Laboratory Records","Back to Main Menu"};
        System.out.println("----------Laboratory Services---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void laboratory_Test(){
        String [] choices = {"Blood Chemistry","Hermatology","Clinical Microscopy","Bacteriology","Blood Bank and Serology","Back to Laboratory Services Menu"};
        System.out.println("----------Register New Laboratory Test---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void blood_Chemistry(){
        String [] choices = {"Bua","Bun","Cholesterol","Createnine","FBS:RBS","Triglycerides","AST/ GOT","ALT/ GPT","HDL/ LDL","Back"};
        System.out.println("----------Blood Chemistry---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void hematology(){
        String [] choices = {"CBC","CT/BT","Hgb/Hct","Pheripheral Smear Staining","Pheripheral Smear Reading","Platelet Count","Prothrombintime","Back"};
        System.out.println("----------Hematology---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void clinical_Microscopy(){
        String [] choices = {"Fecalysis","Occult Blood Test","Pregnancy Test","Urinalysis","Back"};
        System.out.println("----------Clinical Microscopy---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void bacteriology(){
        String [] choices = {"Sputum Exam/ AFB","Slit Skin Smear","Gram Stain","KOH Mount","RF/Igm","Typhidot","Back"};
        System.out.println("----------Bacteriology---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void bloodBank_Serology(){
        String [] choices = {"Blood Typing","HbSAg","HCV","HAV","Bleeding Fee","Back"};
        System.out.println("----------Blood Bank and Serology---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void room_Services(){
        String [] choices = {"Register New Admission","Edit Room Informtaion","View Room Records","Back to Main Menu"};
        System.out.println("----------Room and Admission Services---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void register_Admission(){
        String [] choices = {"Service Ward","Semi-Primitive Room","Private Room","Back to Room and Admission Menu"};
        System.out.println("----------Register New Admission---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void edit_Rooms(){
        String [] choices = {"SERVICE WARD INFO","SEMI-PRIVATE ROOM INFO","PRIVATE ROOM","Exit"};
        System.out.println("----------Edit Rooms---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void transaction_Records(){
        String [] choices = {"Consultation Records","Laboratory Records","Room Admission Records","Back to Main Menu"};
        System.out.println("----------Transaction Records---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void consulation_Record(){
        String [] choices = {"Consultation History","Exit"};
        System.out.println("----------Consultation Record---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void laboratory_Record(){
        String [] choices = {"Blood Chemistry","Hematology","Clinical Microcopy","Bacteriology","Blood Bank and Serology","Exit"};
        System.out.println("----------Laborartory Record---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void room_Record(){
        String [] choices = {"SERVICE WARD History","SEMI-PRIVATE ROOM History","PRIVATE ROOM History","Exit"};
        System.out.println("----------Room Record---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
}