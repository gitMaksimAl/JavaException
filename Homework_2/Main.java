package Homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * Задание 1
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
     * (типа float), и возвращает введенное значение. Ввод текста вместо числа
     * не должно приводить к падению приложения, вместо этого, необходимо
     * повторно запросить у пользователя ввод данных.
     */
    public static float getFloat() {
        Float num = null;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (num == null) {
            try {
                System.out.println("Please enter float in next line.");
                num = Float.parseFloat(input.readLine());
            } catch(NumberFormatException | NullPointerException e) {
                System.err.println("Conversion error.");
            } catch(IOException e) {
                System.err.println("Read error.");
            }
        }
        try {
            input.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return num;
    }
    /*
    * Задание 2
    *    try {
    *       int d = 0;
    *       double catchedRes1 = intArray[8] / d;
    *       System.out.println("catchedRes1 = " + catchedRes1);
    *    } catch (ArithmeticException e) {
    *   System.out.println("Catching exception: " + e);
    *    }
    */
    public static void task2() {
        int[] intArray = new int[8];
        try {
           int d = 0;
           double catchedRes1 = intArray[8] / d;
           System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    /*
    * Задание 3

    * public static void main(String[] args) throws Exception {
    *    try {
    *        int a = 90;
    *        int b = 3;
    *        System.out.println(a / b);
    *        printSum(23, 234);
    *        int[] abc = { 1, 2 };
    *        abc[3] = 9;
    *    } catch (Throwable ex) {
    *        System.out.println("Что-то пошло не так...");
    *    } catch (NullPointerException ex) {
    *        System.out.println("Указатель не может указывать на null!");
    *    } catch (IndexOutOfBoundsException ex) {
    *        System.out.println("Массив выходит за пределы своего размера!");
    *    }
    * }
    * public static void printSum(Integer a, Integer b) throws FileNotFoundException {
    *    System.out.println(a + b);
    * }
    */

    public static void printSum(Integer a, Integer b) throws ArithmeticException {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        System.out.println(getFloat());
        task2();


        // Задание 3
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
}
