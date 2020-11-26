package domain;

public class MyOutOfBoundsException extends IndexOutOfBoundsException {

    public MyOutOfBoundsException(String string) {
        super(string);
    }
}
