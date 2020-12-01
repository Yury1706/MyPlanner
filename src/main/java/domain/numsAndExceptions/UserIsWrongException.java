package domain.numsAndExceptions;

public class UserIsWrongException extends Exception{

    public UserIsWrongException(String info) {
        super(info);
    }
}
