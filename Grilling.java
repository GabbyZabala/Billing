import java.util.Scanner;

public class Grilling extends ui {

    public static void Display_Screen(int screen) {
        switch (screen) {
            case 0:
                main_Menu();
                break;
            case 1:
                consultation_Services();// +10
                break;
            case 2:
                laboratory_Services();// +20
                break;
            case 3:
                room_Record();// +30
                break;
            case 4:
                transaction_Records();// +40
                break;
            case 5:
                break;
            default:

                break;
        }
    }

    public static void main(String[] args) {
        clear();
        animation("Loading.....");
        clear();
        Boolean loop = true, force = true;
        int locale = 0, revert = 0, tempo = 0;
        while (loop) {
            clear();
            header();
            Scanner command = new Scanner(System.in);
            Display_Screen(locale);
            System.err.print("\tEnter choice: -->\t");
            int Terminate = command.nextInt();
            switch (revert) {
                case 0:
                    if (force) {
                        switch (Terminate) {
                            case 1:// goto Consultation Service
                            case 2:// goto laboratory
                            case 3:// goto room and admin
                            case 4:
                                locale = Terminate;// transaction records
                                break;
                            case 5:// exit
                                clear();
                                sleep(1000);
                                animation("Exiting programm...");
                                loop = false;
                                break;
                            default:
                                locale = 0;
                                break;
                        }
                    }
                    revert = Terminate;
                    break;
                case 1:// goto Consultation Service
                    if (force) {
                        switch (Terminate) {
                            case 1:
                            case 2:
                            case 3:
                                locale = Terminate + 10;
                                break;
                            case 4:
                            default:
                                locale = tempo;
                                break;
                        }

                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            clear(); // Clear the console
            animation("Loading.....");
            tempo = revert;
        }
    }
}