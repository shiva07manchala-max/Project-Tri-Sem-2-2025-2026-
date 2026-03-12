import java.util.HashMap;
import java.util.Scanner;

public class Login {
    private HashMap<String, User> users;
    private Scanner scanner;

    public Login() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
        // Add a default admin user
        users.put("admin", new User("admin", "admin123", true));
    }

    public User authenticate() {
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            System.out.println("Login successful!");
            return user;
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    public void signup() {
        System.out.println("=== Signup ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        users.put(username, new User(username, password, false));
        System.out.println("Signup successful!");
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
