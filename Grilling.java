import java.util.Scanner;

public class Grilling extends ui {

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
            sleep(500); // Adjust the delay in milliseconds
        }
    }

    public static void sleep(int numbers) {// sleep function
        try {
            // Sleep for 2 seconds
            Thread.sleep(numbers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Display_Screen(int screen) {
        switch (screen) {
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
        animation("Loading.....");
        clear();
        Boolean loop = true;
        int locale = 0;
        int revert;
        while (loop) {
            revert = locale;
            header();
            Scanner command = new Scanner(System.in);
            Display_Screen(locale);
            System.err.print("\tEnter choice: -->\t");
            int Terminate = command.nextInt();
            switch (revert) {
                case 0:
                    if (revert == locale) {
                        switch (Terminate) {
                            case 1:
                                // goto consultation
                                break;
                            case 2:
                                // goto laboratory
                                break;
                            case 3:
                                // goto room and admin
                                break;
                            case 4:
                                // transaction records
                                break;
                            case 5:// exit
                                clear();
                                sleep(1000);
                                animation("Exiting programm...");
                                loop = false;
                                break;
                        }
                    }
                    break;
                case 1:

                    break;
            }
            locale = Terminate;

            clear(); // Clear the console
        }
    }
}