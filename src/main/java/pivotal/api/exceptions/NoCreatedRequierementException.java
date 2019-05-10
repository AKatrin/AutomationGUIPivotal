package pivotal.api.exceptions;

public class NoCreatedRequierementException extends Exception {

    public NoCreatedRequierementException() {
        super();
    }

    public NoCreatedRequierementException(String message, String... values) {
        super(String.format(message, values));
    }
}
