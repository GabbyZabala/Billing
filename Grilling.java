import java.util.Scanner;

public class Grilling extends ui{

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

	public static void main(String[] args) {
        int locale = 1;
        Boolean loop = true;
        while(true){
            switch (locale){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    clear();
                    System.out.print("Your Exiting the program..");
                    Sleep(100);
                    loop = false;
                    break;
                default:
                    locale = 5;
                    break;
                
            }
            clear(); // Clear the console
        }
        System.out.print("Program ended");
	}
}