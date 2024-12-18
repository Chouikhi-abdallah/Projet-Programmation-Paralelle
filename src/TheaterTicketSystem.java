import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

// Main class for the theater ticket system
public class TheaterTicketSystem {
    private final TicketManager ticketManager; // Manages the tickets (seats)

    // Constructor initializes the TicketManager with the given number of seats
    public TheaterTicketSystem(int seatCount) {
        ticketManager = new TicketManager(seatCount);

        // Simulates two clients using separate threads
        new Thread(() -> createAndShowGUI("Client 1")).start(); // Creates GUI for Client 1
        new Thread(() -> createAndShowGUI("Client 2")).start(); // Creates GUI for Client 2
    }

    // Method to create and display the graphical user interface for a client
    private void createAndShowGUI(String clientName) {
        // Create a new JFrame (window) for the client
        JFrame frame = new JFrame("Theater Ticket System (" + clientName + ")");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application on window exit
        frame.setSize(700, 500); // Set window size to 700x500 pixels

        // Main panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Title label at the top with instructions
        JLabel title = new JLabel("Welcome to the Theater Ticket System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20)); // Set font style and size
        title.setBorder(new TitledBorder("Instructions: Click to reserve or cancel a seat.")); // Add a titled border
        mainPanel.add(title, BorderLayout.NORTH); // Place the title at the top of the panel

        // Grid panel to display seats in a 4x5 grid layout
        JPanel gridPanel = new JPanel(new GridLayout(4, 5, 10, 10)); // 4 rows, 5 columns, 10px gaps

        // Loop to create buttons for each seat
        for (int i = 0; i < ticketManager.getSeats().size(); i++) {
            int id = i + 1; // Seat ID (1-based index)
            JButton button = new JButton("Seat " + id); // Button label showing seat number
            button.setBackground(Color.WHITE); // Set initial button color to white (available)
            button.setForeground(Color.BLUE); // Set text color to blue
            button.setFocusPainted(false); // Disable focus paint for better aesthetics

            // Custom button design (uses a custom UI if defined)
            button.setUI(new CustomButtonUI());

            // Add an action listener to handle button clicks
            button.addActionListener((ActionEvent e) -> handleButtonClick(clientName, id, button));

            gridPanel.add(button); // Add the button to the grid panel
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER); // Place the grid panel in the center
        frame.add(mainPanel); // Add the main panel to the frame
        frame.setVisible(true); // Make the frame visible
    }

    // Handles button clicks for reserving or canceling seats
    private void handleButtonClick(String clientName, int id, JButton button) {
        // Synchronize on the TicketManager to ensure thread-safe access
        synchronized (ticketManager) {
            // If the seat is currently available (white color)
            if (button.getBackground() == Color.WHITE) {
                if (ticketManager.reserveSeat(id)) { // Attempt to reserve the seat
                    button.setBackground(Color.RED); // Change color to red (reserved)
                    button.setText("Reserved"); // Update button label to "Reserved"
                    System.out.println(clientName + " reserved Seat " + id); // Log reservation
                } else {
                    // Show a message dialog if the seat is already reserved
                    JOptionPane.showMessageDialog(null, clientName + ": Seat " + id + " is already reserved!");
                }
            }
            // If the seat is currently reserved (red color)
            else if (button.getBackground() == Color.RED) {
                if (ticketManager.cancelSeat(id)) { // Attempt to cancel the reservation
                    button.setBackground(Color.WHITE); // Change color back to white (available)
                    button.setText("Seat " + id); // Reset button label to "Seat X"
                    System.out.println(clientName + " canceled reservation for Seat " + id); // Log cancellation
                } else {
                    // Show a message dialog if the seat is not reserved
                    JOptionPane.showMessageDialog(null, clientName + ": Seat " + id + " is not reserved!");
                }
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new TheaterTicketSystem(20); // Create a system with 20 seats
    }
}
