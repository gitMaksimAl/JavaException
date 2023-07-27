package Homework_3;

/**
 * RequestExceptions
 */
public class RequestExceptions extends Throwable{

    public RequestExceptions(String message) {
        super(message);
    }

    public static class ParseException extends RequestExceptions{
        
        public ParseException() {
            super("Wrong data amount.");
        }
    }

    public static class WrongDataException extends RequestExceptions{

        public WrongDataException() {
            super("Wrong data format.");
        }
    }
}