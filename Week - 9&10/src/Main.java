
// This class represents the main class that creates and tests the chain of responsibility
import java.util.Scanner; // for user input

public class Main {

    public static void main(String[] args) {

        // Create a chain of handlers: Tech Lead -> Project Manager -> Director
        Handler techLead = new TechLead(new ProjectManager(new Director()));

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of leave requests to test
        System.out.println("How many leave requests do you want to test?");
        int n = scanner.nextInt(); // read an integer from the user

        // Loop n times to create and test n leave requests
        for (int i = 0; i < n; i++) {

            // Ask the user for the details of the leave request
            System.out.println("Enter the employee name:");
            String empName = scanner.next(); // read a string from the user
            System.out.println("Enter the leave type (SL, CL, or VL):");
            String leaveType = scanner.next(); // read a string from the user
            System.out.println("Enter the request date (dd/mm/yyyy):");
            String requestDate = scanner.next(); // read a string from the user

            // Create a leave request object based on the leave type
            LeaveRequest request;
            if (leaveType.equals("SL") || leaveType.equals("CL")) {
                // Ask the user for the reason for SL or CL
                System.out.println("Enter the reason for " + leaveType + ":");
                String reason = scanner.next(); // read a string from the user
                // Create a SL or CL request with the reason
                request = new LeaveRequest(empName, leaveType, requestDate, reason);
            } else if (leaveType.equals("VL")) {
                // Ask the user for the start date and end date for VL
                System.out.println("Enter the start date (dd/mm/yyyy) for VL:");
                String startDate = scanner.next(); // read a string from the user
                System.out.println("Enter the end date (dd/mm/yyyy) for VL:");
                String endDate = scanner.next(); // read a string from the user
                // Create a VL request with the start date and end date
                request = new LeaveRequest(empName, leaveType, requestDate, startDate, endDate);
            } else {
                // Invalid leave type entered by the user
                System.out.println("Error: Invalid leave type entered");
                continue; // skip this iteration and go to the next one
            }

            // Test the chain of responsibility with the leave request
            techLead.handle(request);
        }

        // Close the scanner object
        scanner.close();
    }
}