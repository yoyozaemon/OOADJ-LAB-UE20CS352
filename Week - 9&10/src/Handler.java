// This interface represents a handler in the chain of responsibility
public interface Handler {

    // This method handles the leave request or passes it to the next handler
    public void handle(LeaveRequest request);
}