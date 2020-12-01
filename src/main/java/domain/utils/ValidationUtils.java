package domain.utils;

import domain.numsAndExceptions.UserIsWrongException;

public class ValidationUtils {

    public static void checkUserValue(int item) throws UserIsWrongException {
        if (item <= 0 || item > 2) {
            throw new UserIsWrongException("Вы ввели не верное число.");
        }
    }
}
