// This class represents a Project Manager handler in the chain of responsibility
public class ProjectManager implements Handler {

    // The next handler in the chain
    private Handler next;

    // The constructor that takes the next handler as a parameter
    public ProjectManager(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(LeaveRequest request) {

        System.out.println("Project Manager received the leave request from " + request.getEmpName());

        // If the leave type is CL, process it and approve or reject it based on the
        // reason
        if (request.getLeaveType().equals("CL")) {
            System.out.println("Project Manager processed the CL request");
            // Assuming some logic to check the reason and decide whether to approve or
            // reject
            boolean validReason = checkReason(request.getReason());
            if (validReason) {
                System.out.println("Project Manager approved the CL request");
                request.setLeaveStatus("Approved");
                request.setApprovedBy("Project Manager");
                request.setApprovalDate("Today"); // assuming today's date
            } else {
                System.out.println("Project Manager rejected the CL request");
                request.setLeaveStatus("Rejected");
                request.setApprovedBy("Project Manager");
                request.setApprovalDate("Today"); // assuming today's date
            }
        }
        // Otherwise, forward it to the next handler
        else {
            System.out.println("Project Manager forwarded the request to the next handler");
            next.handle(request);
        }
    }

    // A helper method to check the reason for CL and return true or false
    private boolean checkReason(String reason) {
        // Assuming some logic to validate the reason
        return true; // for simplicity, return true for now
    }
}