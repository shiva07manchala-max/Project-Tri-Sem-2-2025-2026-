import java.util.LinkedList;

public class User {
    private String username;
    private String password;
    private boolean isAdmin;
    private LinkedList<String> registeredEvents;
    private LinkedList<String> reminders;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.registeredEvents = new LinkedList<>();
        this.reminders = new LinkedList<>();
    }

    public String getUsername() { return username; }
    public boolean isAdmin() { return isAdmin; }
    public LinkedList<String> getRegisteredEvents() { return registeredEvents; }
    public LinkedList<String> getReminders() { return reminders; }

    public void registerForEvent(String eventName) {
        registeredEvents.add(eventName);
    }

    public void unregisterFromEvent(String eventName) {
        registeredEvents.remove(eventName);
    }

    public void addReminder(String reminder) {
        reminders.add(reminder);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}