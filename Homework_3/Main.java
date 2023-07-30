package Homework_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Homework_3.RequestExceptions.ParseException;
import Homework_3.RequestExceptions.InvalidDataException;

public class Main {
    public static void main(String[] args) {
        System.out.println("\033[H\033[2JPlease enter user data like: "
            + User.DATA_FORMAT);

        try (Scanner scanner = new Scanner(System.in)){
            String[] userData = User.getData(scanner.nextLine());
            User userOne = new User(userData);
            userOne.validate();
            File file = new File(userOne.getFileName());
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(file, true));
            writer.write(userOne.toString());
            writer.append('\n');
            writer.close();
        } catch (ParseException p) {
            System.err.println(p.getMessage());
        } catch (InvalidDataException w) {
            System.err.println(w.getMessage());
        } catch (NoSuchElementException | IllegalStateException sc) {
            System.err.println("Scanner error.");
        } catch (IOException f) {
            System.err.println("File error.");
        }
    }
}
