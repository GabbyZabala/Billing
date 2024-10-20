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
        int locale = 0, revert;
        Boolean loop = true;
        while(true){  
            header();
            Scanner command = new Scanner(System.in);
            switch (locale){
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
                case 5:
                    clear();
                    System.out.print("Your Exiting the program..");
                    loop = false;
                    break;
                default:
                    break;
                
            }
            System.err.print("\tEnter choice: -->\t");
            int Terminate = command.nextInt();
            revert = Terminate;

            clear(); // Clear the console
        }
	}
}