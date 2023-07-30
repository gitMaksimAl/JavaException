package Homework_3;

/**
 * RequestExceptions
 */
public class RequestExceptions extends Throwable{

    public RequestExceptions(String message) {
        super(message);
    }

    public static class ParseException extends RequestExceptions{
        
        public ParseException(String message) {
            super(message);
        }

        public ParseException() {
            super("Wrong amount of data.");
        }
    }

    public static class InvalidDataException extends RequestExceptions{

        public InvalidDataException(String message) {
            super(message);
        }
    }
}