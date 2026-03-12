# Interactive Smart Event Management System (DSA Project)

## Project Overview
This Java-based Event Management System demonstrates various Data Structures and Algorithms (DSA) concepts through an interactive console application. It allows users to register, login, view events, register for events, and manage profiles, while admins can add/delete events.

## Features Implemented

### User Management
- **Login System**: Uses HashMap for storing and retrieving user credentials
- **Signup**: Register new users with username and password
- **Profile Management**: View user details and registered events

### Event Management
- **View Events**: Display all upcoming events
- **Search Events**: Linear search and Binary search (when sorted)
- **Sort Events**: Bubble sort by popularity, Merge sort by date
- **Event Registration**: Uses Queue for registration process
- **Undo Actions**: Stack-based undo functionality
- **Admin Features**: Add and delete events

### Additional DSA Features
- **Priority Queue**: For VIP users/events based on popularity
- **Hashing**: Fast event lookup using HashMap
- **Linked List**: For storing events and user registrations
- **Event Reminders**: Linked list for user reminders
- **Seat Availability**: Tracking available seats for events

## Data Structures Used

| Feature | Data Structure |
|---------|----------------|
| Login system | HashMap |
| Events list | Linked List |
| Search events | Linear/Binary Search |
| Sort events | Bubble Sort / Merge Sort |
| Event registration | Queue |
| Undo action | Stack |
| VIP events | Priority Queue |
| Fast event search | Hashing (HashMap) |

## How to Run

1. Compile all Java files:
   ```
   javac *.java
   ```

2. Run the main class:
   ```
   java Main
   ```

## Usage Instructions

1. **Login/Signup**: Choose option 1 to login or 2 to signup
2. **Home Page**: After login, choose from various options:
   - View Events (1)
   - Search Event (2)
   - Register for Event (3)
   - View Profile (4)
   - Undo Last Action (5)
   - Admin options: Add Event (6), Delete Event (7)
   - Logout (8)

## Sample Data
The system comes pre-loaded with sample events:
- Tech Conference (Dec 1, 2023)
- Music Festival (Nov 15, 2023)
- Art Exhibition (Oct 20, 2023)

## Admin Access
- Username: admin
- Password: admin123

## DSA Concepts Demonstrated

1. **HashMap**: For user authentication and fast event lookup
2. **LinkedList**: For storing events and user registrations
3. **Queue**: For event registration process
4. **Stack**: For undo functionality
5. **Priority Queue**: For VIP event management
6. **Linear Search**: Basic event search
7. **Binary Search**: Efficient search on sorted data
8. **Bubble Sort**: Sorting events by popularity
9. **Merge Sort**: Sorting events by date

This project serves as a comprehensive demonstration of fundamental DSA concepts applied to a real-world scenario.