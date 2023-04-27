// This class represents a Tech Lead handler in the chain of responsibility
public class TechLead implements Handler {

    // The next handler in the chain
    private Handler next;

    // The constructor that takes the next handler as a parameter
    public TechLead(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(LeaveRequest request) {

        System.out.println("Tech Lead received the leave request from " + request.getEmpName());

        // If the leave type is SL, process it and approve it
        if (request.getLeaveType().equals("SL")) {
            System.out.println("Tech Lead approved the SL request");
            request.setLeaveStatus("Approved");
            request.setApprovedBy("Tech Lead");
            request.setApprovalDate("Today"); // assuming today's date
        }
        // Otherwise, forward it to the next handler
        else {
            System.out.println("Tech Lead forwarded the request to the next handler");
            next.handle(request);
        }
    }
}