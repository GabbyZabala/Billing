public class ui{
    public static void header() {
        System.out.println("== Hospital Billing=======");  
    }
    public static void main_Menu(){
        String [] choices = {"Consultation Services","Laboratory Services","Room and Admission Services","Transaction Records","Exit"};
        System.out.println("-----------Menu----------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }     
    }
    public static void Consultation_Services(){
        String [] choices = {"Register New Consultation","Edit Consultation Fees","View Consultation Records","Back to Main Menu"};
        System.out.println("----------Consultation Services---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }     
    }
    public static void Register_Consulatation(){
        String [] choices = {"1.OPD Consultation","2.ER Consultation","3.Back to Consultation Services Menu"};
        System.out.println("----------Register New Consultation---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }     
    public static void Edit_Consultation(){
        String [] choices = {"Consultation OPD","Consultation ER","Exit"};
        System.out.println("----------Edit Consultation Fee---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void Laboratory_Services(){
        String [] choices = {"Register New Laboratory Test","Edit Laboratory Pricing","View Laboratory Records","Back to Main Menu"};
        System.out.println("----------Laboratory Services---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void Laboratory_Test(){
        String [] choices = {"Blood Chemistry","Hermatology","Clinical Microscopy","Bacteriology","Blood Bank and Serology","Back to Laboratory Services Menu"};
        System.out.println("----------Register New Laboratory Test---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
        }
    }
    public static void Blood_Chemistry(){
        String [] choices = {"1.Bua","Hermatology","Clinical Microscopy","Bacteriology","Blood Bank and Serology","Back to Laboratory Services Menu"};
        System.out.println("----------Register New Laboratory Test---------");
        for(int i = 0; i<choices.length;i++) {
            System.out.println((i+1)+": "+choices[i]);
}