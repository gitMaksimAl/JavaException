package Homework_3;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Homework_3.RequestExceptions.ParseException;
import Homework_3.RequestExceptions.WrongDataException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter user data like: " +
            "<Name> <Lastname> <Surname> <birthday(dd.mm.yyyy)> " +
            "<phonenumber(11 digit)> <sex(m|f)>");
        try (Scanner scanner = new Scanner(System.in)){
            String[] userData = User.getData(scanner.nextLine());
            User userOne = new User(userData);
            userOne.validate();
            System.out.println(userOne.getFile());
        } catch (ParseException p) {
            System.err.println(p.getMessage());
        } catch (WrongDataException w) {
            System.err.println(w.getMessage());
        } catch (NoSuchElementException | IllegalStateException sc) {
            System.err.println("Scanner error.");
        }
    }
}
