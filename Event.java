import java.util.LinkedList;

public class Event {
    private String name;
    private String date;
    private int popularity;
    private int totalSeats;
    private int availableSeats;
    private LinkedList<String> registeredUsers;

    public Event(String name, String date, int popularity, int totalSeats) {
        this.name = name;
        this.date = date;
        this.popularity = popularity;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.registeredUsers = new LinkedList<>();
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public int getPopularity() { return popularity; }
    public int getAvailableSeats() { return availableSeats; }
    public LinkedList<String> getRegisteredUsers() { return registeredUsers; }

    public void registerUser(String username) {
        if (availableSeats > 0) {
            registeredUsers.add(username);
            availableSeats--;
        }
    }

    public void unregisterUser(String username) {
        if (registeredUsers.remove(username)) {
            availableSeats++;
        }
    }

    @Override
    public String toString() {
        return name + " on " + date + " (Popularity: " + popularity + ", Seats: " + availableSeats + "/" + totalSeats + ")";
    }
}