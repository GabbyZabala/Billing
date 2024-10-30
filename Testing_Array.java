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
        lana[] bak = new lana[9];
        for (int i = 0; i < bak.length; i++) {
            bak[i] = new lana(); // Initialize each element in the array
        }
        clear();
        int account_access = 1;
        try(Scanner lan = new Scanner(System.in)){// suggested by github copilot
            for (int i = 0; i < 6; i++) {
                System.err.print("Enter word: ");
                String fan = lan.nextLine();
                bak[account_access].add(fan);
            }
        }
        bak[account_access].display_array();
        sleep(2000);//only included in ui so dont mind this
        clear();//only included in ui so dont mind this
    }
}