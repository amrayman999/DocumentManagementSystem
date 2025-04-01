package Package_2;

public class LengthOverFlowException extends Exception {
    private int exceededLengthAmount;

    public LengthOverFlowException(String message, int exceededLengthAmount) {
        super(message);
        this.exceededLengthAmount = exceededLengthAmount;
    }

    public int getExceededLengthAmount() {
        return exceededLengthAmount;
    }
}
