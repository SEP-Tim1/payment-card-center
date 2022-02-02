package sep.paymentcardcenter.exceptions;

public class BankNotFoundException extends Exception {
    private static final String message = "Bank not found!";

    public BankNotFoundException() {
        super(message);
    }
}
