package Homework_2.Task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Задание 4
    public static void programm(String line) throws RuntimeException {
        if (line == null || line.isEmpty())
            throw new RuntimeException("Так делать нельзя!!!");
    }

    public static void main(String[] args) {
        
        // Задание 4
        // Разработайте программу, которая выбросит Exception, когда
        // пользователь вводит пустую строку. Пользователю должно показаться
        // сообщение, что пустые строки вводить нельзя.
        
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            programm(input.readLine());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
