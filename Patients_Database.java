class Patients_Database {// Patients Database
    private static int num = 0;
    private int PatientID;
    private String lastname;
    private String firstname;
    private String fullname;
    private int age = 0;
    private String Bloodtype;
    private int account_usage = 0;
    private String[] account_lodge = new String[99];// 99 for max usage of the account that can carry
    private int consultation_data_usage = 0;
    private String[] consultation_data = new String[99];// for date purposes
    /*
     * Constructor Below
     * Node pass na this
     */

    Patients_Database(String last, String first, int Patientage) {
        this.lastname = last;
        this.firstname = first;
        this.fullname = last + ", " + first;
        this.age = Patientage;
        this.PatientID = ++num;
    }

    public void show_PatientsData() {
        System.out.println("PATIENTS FULLNAME:\t" + fullname);
        System.out.println("PATIENTS ID:\t" + PatientID);
        System.out.println("\t---Details: First[ " + firstname + " ] Last [ " + lastname + " ]");
        System.out.println("-- AGE:\t\t" + (age == 0 ? "[ NO DATA ] " : age));
        System.out.println("-- BLOODTYPE:\t" + (Bloodtype == null ? "[ NO DATA ] " : Bloodtype));
    }

    public void Add_Bloodtype(String Blood) {
        this.Bloodtype = Blood;
    }

    public void Add_Account_Lodge(String name_input) {// di ako marunong nung dynamic array eh
        this.account_lodge[account_usage] = name_input;
        this.account_usage++;
    }

    public void Add_Consultation(String date) {
        this.consultation_data[consultation_data_usage] = date;
        this.consultation_data_usage++;
    }

    public boolean Scan_Consultation() {
        int blanka = 0;
        for (int i = 0; i < account_lodge.length; i++) {// scanning purposess
            if (account_lodge[i] != null) {
                if (account_lodge[i].equals("OPD") || account_lodge[i].equals("ER")) {
                    blanka++;
                }
            }
        }
        if (blanka != 0)
            return true;
        else
            return false;
    }

    public void View_Conconsultation() {
        int opdCount = 0, erCount = 0, vias = 0;
        for (int i = 0; i < account_lodge.length; i++) {
            if (account_lodge[i] != null) {
                if (account_lodge[i].equals("OPD")) {
                    opdCount++;
                    System.out.println("OPD - " + consultation_data[vias]);
                    vias++;
                } else if (account_lodge[i].equals("ER")) {
                    erCount++;
                    System.out.println("ER - " + consultation_data[vias]);
                    vias++;
                }
            }
        }
        if (opdCount == 0) {
            System.out.println("No OPD data recorded.");
        }
        if (erCount == 0) {
            System.out.println("No ER data recorded.");
        }
    }

    public void show_PatientsHistory() {
        int con = 0;
        for (int i = 1; i < 3; i++) {
            if (i != 2) {
                System.out.println(
                        "-------------------------------------------------------------------------------------");
            } else {
                for (String lata : this.account_lodge) {
                    if (lata != null) {
                        System.out.print("\n\tActivity Log: " + lata);
                        if (lata.equals("OPD") || lata.equals("ER")) {
                            System.out.println("\tDate: " + consultation_data[con]);
                            con++;
                        }
                        System.err.println(
                                "\t------------------------------------------");
                    }
                }
            }
        }
    }
}
