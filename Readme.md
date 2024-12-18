# **Theater Ticket Reservation System**  

## **Overview**  
The **Theater Ticket Reservation System** is a Java-based application that simulates a real-time ticket booking experience for theater seats. It features a graphical user interface (GUI) created with **Swing**, showcasing a seat reservation system that allows multiple clients to interact simultaneously. The system ensures thread-safe operations using semaphores and synchronized methods, making it both robust and suitable for concurrent environments.

---

## **Features**  

### **1. Multi-Client Support**  
The system simulates two clients interacting with the application via separate GUIs, providing a real-time experience of how multiple users would interact with the system simultaneously.  

### **2. Graphical User Interface (GUI)**  
The user interface features:  
- **A welcoming title**: Displays a header with instructions for reserving or canceling seats.  
- **Interactive buttons**: Each button represents a theater seat, with dynamic coloring and labels indicating the seat’s status:  
  - **White**: Available for reservation.  
  - **Red**: Reserved by a client.  

### **3. Seat Reservation and Cancellation**  
Users can:  
- **Reserve a seat** by clicking on an available button (white).  
- **Cancel a reservation** by clicking on a reserved button (red).  

### **4. Concurrency and Synchronization**  
- **Thread-safe operations**: Synchronization ensures that multiple clients can safely interact with the system without race conditions or inconsistencies.  
- **Semaphore control**: Limits the number of concurrent reservations to avoid overwhelming system resources.  

---

## **How It Works**  

1. **Initialization**:  
   - The system starts with 20 theater seats, each represented by a `Ticket` object.  

2. **Main Components**:  
   - **TicketManager**: Manages the reservation and cancellation logic while ensuring thread safety.  
   - **TheaterTicketSystem**: Handles GUI creation and client interactions.  
   - **Ticket**: Represents individual seats, storing their ID and reservation status.  

3. **Client Interaction**:  
   - Two GUIs are created, one for each client.  
   - Clients can interact with buttons to reserve or cancel seats.  

4. **Real-Time Feedback**:  
   - Button colors and text update dynamically to reflect the current status of each seat.  
   - If a seat is already reserved or not reserved when clicked, a pop-up message informs the user.  

---

## **Technologies Used**  

- **Java**: Core programming language for the application.  
- **Swing**: For building the GUI.  
- **Concurrency Utilities**: Java’s `Semaphore` and `synchronized` keyword to manage concurrent client interactions.  

---

## **Code Structure**  

### **1. TicketManager**  
This class manages the core logic of the system. It ensures:  
- Seat reservations and cancellations are thread-safe.  
- Only a limited number of concurrent reservations are allowed using a **semaphore**.

### **2. Ticket**  
Represents individual seats. Each `Ticket` has:  
- An ID to uniquely identify it.  
- A boolean field (`isReserved`) to track its status.  
- Methods for reserving and canceling the ticket in a synchronized manner.

### **3. TheaterTicketSystem**  
This is the main entry point of the application. It:  
- Initializes the `TicketManager` with the specified number of seats.  
- Creates separate GUIs for multiple clients.  
- Handles button interactions and updates the seat status dynamically.  

---

## **How to Run the Program**  

1. **Prerequisites**:  
   - Ensure you have **Java 8** or higher installed on your system.  
   - A compatible IDE such as IntelliJ IDEA or Eclipse is recommended for execution.

2. **Steps to Run**:  
   - Clone or download the project.  
   - Open the project in your preferred IDE.  
   - Compile and run the `TheaterTicketSystem` class.  

3. **Simulating Clients**:  
   - Upon running, two separate GUI windows will open, simulating two clients interacting with the system simultaneously.  

---

## **Usage Instructions**  

1. **Reserving a Ticket**:  
   - Click on an available seat (white button).  
   - The button will turn **red** and display "Reserved".  

2. **Canceling a Reservation**:  
   - Click on a reserved seat (red button).  
   - The button will turn **white** and display the seat number again.  

3. **Handling Errors**:  
   - If a seat is already reserved or not reserved, you’ll receive an informative pop-up message.  

---

## **Concurrency Features**  

1. **Thread Safety**:  
   - The `synchronized` keyword ensures that reservation and cancellation operations are not performed concurrently on the same seat, avoiding conflicts.  

2. **Semaphore**:  
   - Limits the number of simultaneous reservations to 5, ensuring the system remains responsive under load.  

---

## **Design Enhancements**  

1. **Custom Button UI**:  
   - Provides a polished look to seat buttons with focus paint disabled for a cleaner design.  

2. **Dynamic Feedback**:  
   - Buttons change color and text based on seat status, providing real-time feedback.  

3. **Error Handling**:  
   - Users are notified of invalid actions, ensuring a smooth experience.  

---

## **Future Improvements**  

1. **Database Integration**:  
   - Persist seat reservations in a database to allow tracking across multiple sessions.  

2. **Real-Time Networking**:  
   - Add network capabilities to allow clients on different machines to interact with the same ticket system.  

3. **Admin Panel**:  
   - Introduce an admin interface to manage the theater layout and seat availability.  

4. **Mobile Version**:  
   - Develop a mobile-friendly version of the application for increased accessibility.  

---

## **Why This Project is Important**  

The **Theater Ticket Reservation System** is a great example of how to:  
- Implement **multithreading and synchronization** in real-world applications.  
- Build **interactive GUIs** with dynamic updates using Java Swing.  
- Design robust systems with **concurrent user interactions**.  

It’s an excellent educational tool for understanding core programming concepts while simulating a practical problem.  

---

## **Contact Information**  

For queries or suggestions, feel free to reach out:  
- **Email**: chouikhiabdallahpro@gmail.com

---

## **Conclusion**  

The **Theater Ticket Reservation System** is a practical demonstration of using Java to build a thread-safe, interactive application. It showcases the combination of object-oriented design principles, concurrency, and GUI development, making it an excellent project for learners and developers alike.  
