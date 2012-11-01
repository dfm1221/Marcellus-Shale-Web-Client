package viewer.web.model;

/**
 * User: Justin Ford
 * Date: 10/30/12
 * Time: 5:11 PM
 */
public class ErrorPageDto {

    private Exception exception;
    private String message;

    public Exception getException() {
        return exception;
    }
    public void setException(Exception exception) {
        this.exception = exception;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
