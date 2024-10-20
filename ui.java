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
}