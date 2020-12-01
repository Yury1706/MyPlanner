package domain.numsAndExceptions;

public class MyOutOfBoundsException extends IndexOutOfBoundsException {

    public MyOutOfBoundsException(String string) {
        super(string);
    }
}
