// The Ticket class represents a single seat in the ticketing system, with methods for reservation and cancellation.
class Ticket {

    // The unique identifier for this ticket (seat).
    private final int id;

    // A boolean flag to indicate whether the ticket is reserved or not.
    private boolean isReserved;

    // Constructor to initialize the ticket with a specific ID and set its initial state to not reserved.
    public Ticket(int id) {
        this.id = id; // Set the ticket's unique ID.
        this.isReserved = false; // Initially, the ticket is not reserved.
    }

    // Getter method to retrieve the ID of the ticket.
    public int getId() {
        return id; // Return the ticket's unique ID.
    }

    // Synchronized method to reserve the ticket. Returns true if the reservation is successful.
    public synchronized boolean reserve() {
        // Check if the ticket is currently not reserved.
        if (!isReserved) {
            isReserved = true; // Mark the ticket as reserved.
            return true; // Indicate that the reservation was successful.
        }
        // If the ticket is already reserved, return false.
        return false;
    }

    // Synchronized method to cancel the reservation of the ticket. Returns true if the cancellation is successful.
    public synchronized boolean cancel() {
        // Check if the ticket is currently reserved.
        if (isReserved) {
            isReserved = false; // Mark the ticket as not reserved.
            return true; // Indicate that the cancellation was successful.
        }
        // If the ticket is not reserved, return false.
        return false;
    }

    // Method to check if the ticket is available (not reserved).
    public boolean isAvailable() {
        return !isReserved; // Return true if the ticket is not reserved, otherwise return false.
    }
}
