import java.util.*;

public class EventManager {
    private LinkedList<Event> events;
    private HashMap<String, Event> eventMap; // For fast lookup
    private Queue<String> registrationQueue;
    private Stack<String> undoStack;
    private PriorityQueue<Event> vipQueue; // Priority queue for VIP events

    public EventManager() {
        events = new LinkedList<>();
        eventMap = new HashMap<>();
        registrationQueue = new LinkedList<>();
        undoStack = new Stack<>();
        vipQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getPopularity(), e1.getPopularity()));
    }

    public void addEvent(String name, String date, int popularity, int totalSeats) {
        Event event = new Event(name, date, popularity, totalSeats);
        events.add(event);
        eventMap.put(name, event);
        vipQueue.add(event);
        undoStack.push("add:" + name);
    }

    public void deleteEvent(String name) {
        Event event = eventMap.get(name);
        if (event != null) {
            events.remove(event);
            eventMap.remove(name);
            vipQueue.remove(event);
            undoStack.push("delete:" + name + ":" + event.getDate() + ":" + event.getPopularity() + ":" + (event.getAvailableSeats() + event.getRegisteredUsers().size()));
        }
    }

    public Event searchEventLinear(String name) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    public Event searchEventBinary(String name) {
        // Sort events by name for binary search
        events.sort(Comparator.comparing(Event::getName));
        int left = 0, right = events.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = events.get(mid).getName().compareToIgnoreCase(name);
            if (cmp == 0) {
                return events.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortEventsByPopularity() {
        // Bubble sort
        for (int i = 0; i < events.size() - 1; i++) {
            for (int j = 0; j < events.size() - i - 1; j++) {
                if (events.get(j).getPopularity() < events.get(j + 1).getPopularity()) {
                    Event temp = events.get(j);
                    events.set(j, events.get(j + 1));
                    events.set(j + 1, temp);
                }
            }
        }
    }

    public void sortEventsByDate() {
        // Merge sort
        events = mergeSort(events);
    }

    private LinkedList<Event> mergeSort(LinkedList<Event> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        LinkedList<Event> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Event> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private LinkedList<Event> merge(LinkedList<Event> left, LinkedList<Event> right) {
        LinkedList<Event> result = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst().getDate().compareTo(right.getFirst().getDate()) <= 0) {
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    public void registerForEvent(String username, String eventName) {
        Event event = eventMap.get(eventName);
        if (event != null && event.getAvailableSeats() > 0) {
            registrationQueue.add(username + ":" + eventName);
            event.registerUser(username);
            undoStack.push("register:" + username + ":" + eventName);
        }
    }

    public void undoLastAction() {
        if (!undoStack.isEmpty()) {
            String lastAction = undoStack.pop();
            String[] parts = lastAction.split(":");
            String action = parts[0];

            switch (action) {
                case "add":
                    deleteEvent(parts[1]);
                    break;
                case "delete":
                    addEvent(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                    break;
                case "register":
                    Event event = eventMap.get(parts[2]);
                    if (event != null) {
                        event.unregisterUser(parts[1]);
                    }
                    break;
            }
        }
    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    public PriorityQueue<Event> getVipQueue() {
        return vipQueue;
    }

    public void addReminder(String username, String eventName, String reminder) {
        // This would be called from User class, but for simplicity, we'll handle it here
        User user = null; // You'd need to get user from login system
        if (user != null) {
            user.addReminder(reminder);
        }
    }
}