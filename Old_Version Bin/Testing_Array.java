import java.util.Scanner;

class lana {
    String data[] = new String[10];
    int num = 0;

    public void add(String added_data) {
        data[num] = added_data;
        num++;
    }

    public void display_array() {
        for (String da : data) {
            if (da != null) {
                System.err.println(da);
            }
        }
    }
}

public class Testing_Array extends ui {
    public static void main(String[] args) {
        clear();
        int Testing = 2;// input here the testing you want to try just add another case to addyour
                        // testing
        switch (Testing) {
            case 1:
                lana[] bak = new lana[9];
                for (int i = 0; i < bak.length; i++) {
                    bak[i] = new lana(); // Initialize each element in the array
                }
                clear();
                int account_access = 1;
                try (Scanner lan = new Scanner(System.in)) {// suggested by github copilot
                    for (int i = 0; i < 6; i++) {
                        System.err.print("Enter word: ");
                        String fan = lan.nextLine();
                        bak[account_access].add(fan);
                    }
                }
                bak[account_access].display_array();
                sleep(2000);// only included in ui so dont mind this
                clear();// only included in ui so dont mind this
                break;
            case 2:
                try (Scanner Subcoms = new Scanner(System.in)) {
                    String[] sections = { "First", "Second", "Third" };
                    String[] section_input = new String[3];
                    for (int creator = 0; creator < sections.length; creator++) {
                        switch (creator) {
                            case 2:
                                System.out.println(sections[creator - 2] + ":\t" + section_input[creator - 2]);
                            case 1:
                                System.out.println(sections[creator - 1] + ":\t" + section_input[creator - 1]);
                            default:
                                System.out.print(sections[creator] + ":\t");
                                break;
                        }
                        String untered = Subcoms.nextLine();
                        if (creator != 2) {
                            section_input[creator] = untered;
                        } else {
                            try {
                                int number_catcher = Integer.parseInt(untered);
                                System.out.println("Number entered [" + number_catcher + "] is read saving process!!");
                                section_input[creator] = untered;
                            } catch (NumberFormatException e) {
                                System.err.println("Only Number is needed in this stage!!!");
                                creator--;
                            }
                        }
                        sleep(4000);
                        clear();
                    }
                }
                break;
            default:
                break;
        }
        System.err.println("If you see this the Testing Finished its run");
    }
}