public class Index{
    public static void clear() {
        if (System.getProperty("os.name").contains("Windows")) {
            // For Windows
            System.out.print("\033c");
        } else {
            // For Linux/macOS
            System.out.print("\033[H\033[2J"); // ANSI escape code for clearing
            System.out.flush();
        }

	public static void main(String[] args) {
		System.out.println("Hello World!");

        clear(); // Clear the console
	}
}