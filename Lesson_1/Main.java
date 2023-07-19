package Lesson_1;

import java.lang.StringBuilder;
/**
 * Main
 */
public class Main {

    public static int getSize(int[] array) {
        int result;
        if (array.length < 10) result = -1;
        else result = array.length;
        return result;
    }

    public static int getIndex(int[] array, int num) {
        if (array == null) return -3;
        if (array.length < 10) return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) return i;
        }
        return -2;
    }

    public static int getSumm(int[][] array) {
        if (array.length != array[0].length)
            throw new RuntimeException("Array is not square.");
        int size = array.length;
        int summ = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[i][j] != 0 && array[i][j] != 1)
                    throw new RuntimeException("value is not 0 or 1");
                summ += array[i][j];
            }
        }
        return summ;
    }

    public static void tryThis(Integer[] array) {
        StringBuilder errMsg = new StringBuilder();
        for (int i = 0; i < array.length; i++ ) {
            if (array[i] == null) errMsg.append(i);
        }
        if (errMsg.length() != 0)
            throw new RuntimeException(errMsg.toString());
    }

    public static void main(String[] args) {
        //Task 1
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[][] arr2 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 0},
            {0, 1, 1, 0, 1}
        };
        Integer[] arr3 = new Integer[5];

        //System.out.println(getSize(arr));
        ////Task 2
        //System.out.println(getIndex(null, 22));
        ////Task 3
        //System.out.println(getSumm(arr2));
        //Task 4
        tryThis(arr3);
    }
}