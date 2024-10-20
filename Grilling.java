import java.util.Scanner;

public class Grilling extends ui{
    Boolean loop = true;
    public static void clear() {
        if (System.getProperty("os.name").contains("Windows")) {
            // For Windows
            System.out.print("\033c");
        } else {
            // For Linux/macOS
            System.out.print("\033[H\033[2J"); // ANSI escape code for clearing
            System.out.flush();
        }
    }

    public static void Display_Screen(int screen) {
        switch (screen){
            case 0:
                main_Menu();
                break;
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            
            default:
                break;
            
        }
    }
	public static void main(String[] args) {
        int locale = 0, revert;
        while(true){  
            revert = locale;
            header();
            Scanner command= new Scanner(System.in);
            Display_Screen(locale);
            System.err.print("\tEnter choice: -->\t");
            int Terminate = command.nextInt();
            switch (revert) {
                case 0:
                    
                    break;
                default:
                    throw new AssertionError();
            }
            locale = Terminate;

            clear(); // Clear the console
        }
	}
}