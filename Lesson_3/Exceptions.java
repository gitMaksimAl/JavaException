package Lesson_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions extends Exception {
    /**
     * ZeroDiv
     * Создайтеклассисключения, который будет выбрасываться при делениина
     * 0. Исключениедолжно отображать понятноедля пользователя сообщение
     * об ошибке. 
     */
    
    public static class ZeroDiv extends ArithmeticException {

        public ZeroDiv(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "Zero";
        }

    }
    /**
     * NullPointer
     * Создайтеклассисключений, котороебудет возникатьпри обращении к
     * пустому элементув массиве ссылочного типа. Исключениедолжно
     * отображать понятноедля пользователя сообщениеоб ошибке 
     */
    public static class NullPointer extends NullPointerException {
        public NullPointer(int index) {
            super(String.format("%d - is empty.", index));
        }
    }

    /**
     * Создайтеклассисключения, котороебудет возникатьпри попытке открыть
     * несуществующий файл. Исключение должно отображать понятное для
     * пользователясообщение об ошибке.
     */
    public static class NotFound extends IOException {
        public NotFound(String fileName) {
            super(String.format("%s - do not exist.", fileName));
        }
    }
}
