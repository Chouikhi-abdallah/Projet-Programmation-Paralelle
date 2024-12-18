import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

// The TicketManager class manages the reservation and cancellation of tickets/seats.
public class TicketManager {

    // List to hold all the seats (represented as Ticket objects).
    private final List<Ticket> seats;

    // Semaphore to control the number of threads that can access the reservation system concurrently.
    private final Semaphore semaphore;

    // Constructor to initialize the TicketManager with the given number of seats.
    public TicketManager(int seatCount) {
        seats = new ArrayList<>(); // Initialize the list to store Ticket objects.

        // Create a semaphore with 5 permits, allowing up to 5 concurrent reservations.
        // The `true` parameter ensures fairness, meaning threads acquire permits in order.
        semaphore = new Semaphore(5, true);

        // Populate the seats list with Ticket objects for each seat ID from 1 to seatCount.
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Ticket(i)); // Create a new Ticket object and add it to the list.
        }
    }

    // Method to reserve a seat by its ID. Returns true if the reservation is successful.
    public synchronized boolean reserveSeat(int id) {
        // Check if the provided seat ID is valid (within the bounds of the list).
        if (id >= 1 && id <= seats.size()) {
            try {
                semaphore.acquire(); // Acquire a permit from the semaphore before proceeding.

                // Attempt to reserve the seat and store the result in the `success` variable.
                boolean success = seats.get(id - 1).reserve();

                semaphore.release(); // Release the permit back to the semaphore.
                return success; // Return the result of the reservation attempt.

            } catch (InterruptedException e) {
                // Handle the case where the thread is interrupted while waiting for a permit.
                e.printStackTrace();
                return false; // Return false since the reservation failed.
            }
        }
        // If the seat ID is invalid, print an error message and return false.
        System.out.println("Invalid Seat ID: " + id);
        return false;
    }

    // Method to cancel a seat reservation by its ID. Returns true if the cancellation is successful.
    public synchronized boolean cancelSeat(int id) {
        // Check if the provided seat ID is valid (within the bounds of the list).
        if (id >= 1 && id <= seats.size()) {
            // Attempt to cancel the reservation of the specified seat.
            return seats.get(id - 1).cancel();
        }
        // If the seat ID is invalid, print an error message and return false.
        System.out.println("Invalid Seat ID: " + id);
        return false;
    }

    // Getter method to return the list of all seats (Ticket objects).
    public List<Ticket> getSeats() {
        return seats; // Return the list of Ticket objects.
    }
}
