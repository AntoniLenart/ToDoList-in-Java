import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Login {

    private String username;
    private String password;

    public boolean run() {
        try {
            Scanner scan = new Scanner(new File("C:\\Users\\antek\\eclipse-workspace\\ToDoList\\src\\credentials.txt"));

            username = scan.nextLine();
            password = scan.nextLine();
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String inputUsername = keyboard.nextLine();
        System.out.print("Enter your password: ");
        String inputPassword = keyboard.nextLine();
        
        keyboard.close();
        
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Logging in!");
            return true;
        } else {
            System.out.println("Wrong credentials");
            return false;
        }
    }
}
