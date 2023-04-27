// This class represents a Director handler in the chain of responsibility
public class Director implements Handler {

    // The constructor that does not take any parameter
    public Director() {
        // No need to set the next handler as this is the last handler in the chain
    }

    @Override
    public void handle(LeaveRequest request) {

        System.out.println("Director received the leave request from " + request.getEmpName());

        // If the leave type is VL, process it and approve or reject it based on the
        // duration
        if (request.getLeaveType().equals("VL")) {
            System.out.println("Director processed the VL request");
            // Assuming some logic to calculate the duration and decide whether to approve
            // or reject
            int duration = calculateDuration(request.getStartDate(), request.getEndDate());
            if (duration <= 10) { // assuming 10 days is the maximum allowed VL duration
                System.out.println("Director approved the VL request");
                request.setLeaveStatus("Approved");
                request.setApprovedBy("Director");
                request.setApprovalDate("Today"); // assuming today's date
            } else {
                System.out.println("Director rejected the VL request");
                request.setLeaveStatus("Rejected");
                request.setApprovedBy("Director");
                request.setApprovalDate("Today"); // assuming today's date
            }
        }
        // Otherwise, print an error message as there is no more handler in the chain
        else {
            System.out.println("Error: Invalid leave type for Director handler");
        }
    }

    // A helper method to calculate the duration of VL in days
    private int calculateDuration(String startDate, String endDate) {
        // Assuming some logic to parse and compare the dates and return the difference
        // in days
        return 5; // for simplicity, return 5 for now
    }
}