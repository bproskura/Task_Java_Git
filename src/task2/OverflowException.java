package task2;
/**
 * Exception message
 */

public class OverflowException extends Exception {

    private String exception;

    public OverflowException(String exception) {
        this.exception = exception;
    }

}
