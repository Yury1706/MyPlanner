package domain;

public class ExceptionMethods {

    public static void checkUserValue(int item) throws UserIsWrongException {
        if (item <= 0 || item > 2) {
            throw new UserIsWrongException("Вы ввели не верное число.");
        }
    }

    public static void checkDate(int month, int date) throws DateException {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (date < 1 || date > 31) {
                    throw new DateException("Такого дня нет в этом месяце!");
                }
                break;
            case 2:
                if (date < 1 || date > 28) {
                    throw new DateException("Такого дня нет в этом месяце!");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (date < 1 || date > 30) {
                    throw new DateException("Такого дня нет в этом месяце!");
                }
                break;
        }
    }

}
