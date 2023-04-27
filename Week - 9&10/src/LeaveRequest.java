// This class represents a leave request with the details
public class LeaveRequest {
    // The employee name
    private String empName;
    // The leave type: SL, CL, or VL
    private String leaveType;
    // The leave status: New, Approved, or Rejected
    private String leaveStatus;
    // The name of the handler who approved or rejected the request
    private String approvedBy;
    // The date of the request
    private String requestDate;
    // The date of the approval or rejection
    private String approvalDate;
    // The start date of the VL
    private String startDate;
    // The end date of the VL
    private String endDate;
    // The reason for the CL
    private String reason;

    // Constructor for SL and CL requests
    public LeaveRequest(String empName, String leaveType, String requestDate, String reason) {
        this.empName = empName;
        this.leaveType = leaveType;
        this.requestDate = requestDate;
        this.reason = reason;
        this.leaveStatus = "New"; // default status
        this.approvedBy = null; // default value
        this.approvalDate = null; // default value
        this.startDate = null; // not applicable
        this.endDate = null; // not applicable
    }

    // Constructor for VL requests
    public LeaveRequest(String empName, String leaveType, String requestDate, String startDate, String endDate) {
        this.empName = empName;
        this.leaveType = leaveType;
        this.requestDate = requestDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveStatus = "New"; // default status
        this.approvedBy = null; // default value
        this.approvalDate = null; // default value
        this.reason = null; // not applicable
    }

    // Getters and setters for the fields

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}