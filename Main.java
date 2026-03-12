import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login loginSystem = new Login();
        EventManager eventManager = new EventManager();
        Scanner scanner = new Scanner(System.in);

        // Add some sample events
        eventManager.addEvent("Tech Conference", "2023-12-01", 100, 200);
        eventManager.addEvent("Music Festival", "2023-11-15", 150, 500);
        eventManager.addEvent("Art Exhibition", "2023-10-20", 80, 100);

        User currentUser = null;

        while (true) {
            if (currentUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Signup");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        currentUser = loginSystem.authenticate();
                        break;
                    case 2:
                        loginSystem.signup();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("\n=== Home Page ===");
                System.out.println("Welcome, " + currentUser.getUsername() + "!");
                System.out.println("1. View Events");
                System.out.println("2. Search Event");
                System.out.println("3. Register for Event");
                System.out.println("4. View Profile");
                System.out.println("5. Undo Last Action");
                if (currentUser.isAdmin()) {
                    System.out.println("6. Add Event");
                    System.out.println("7. Delete Event");
                }
                System.out.println("8. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("=== Events ===");
                        for (Event event : eventManager.getEvents()) {
                            System.out.println(event);
                        }
                        break;
                    case 2:
                        System.out.print("Enter event name to search: ");
                        String searchName = scanner.nextLine();
                        Event foundEvent = eventManager.searchEventLinear(searchName);
                        if (foundEvent != null) {
                            System.out.println("Found: " + foundEvent);
                        } else {
                            System.out.println("Event not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter event name to register: ");
                        String registerName = scanner.nextLine();
                        eventManager.registerForEvent(currentUser.getUsername(), registerName);
                        currentUser.registerForEvent(registerName);
                        System.out.println("Registered successfully!");
                        break;
                    case 4:
                        System.out.println("=== Profile ===");
                        System.out.println("Username: " + currentUser.getUsername());
                        System.out.println("Registered Events: " + currentUser.getRegisteredEvents());
                        System.out.println("Reminders: " + currentUser.getReminders());
                        break;
                    case 5:
                        eventManager.undoLastAction();
                        System.out.println("Last action undone.");
                        break;
                    case 6:
                        if (currentUser.isAdmin()) {
                            System.out.print("Event name: ");
                            String name = scanner.nextLine();
                            System.out.print("Date: ");
                            String date = scanner.nextLine();
                            System.out.print("Popularity: ");
                            int popularity = scanner.nextInt();
                            System.out.print("Total seats: ");
                            int seats = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            eventManager.addEvent(name, date, popularity, seats);
                            System.out.println("Event added.");
                        }
                        break;
                    case 7:
                        if (currentUser.isAdmin()) {
                            System.out.print("Event name to delete: ");
                            String deleteName = scanner.nextLine();
                            eventManager.deleteEvent(deleteName);
                            System.out.println("Event deleted.");
                        }
                        break;
                    case 8:
                        currentUser = null;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}