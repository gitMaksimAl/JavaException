package Homework_3;

import java.io.File;
import Homework_3.RequestExceptions.ParseException;
import Homework_3.RequestExceptions.WrongDataException;

/**
 * User.
 * Use static method 'createUser' for create new user from string with data.
 */
public class User {

    private Name userName;
    private BirthDay bday;
    private PhoneNumber phone;
    private char sex;
    private String file;

    public User() {this.userName = null;}

    public static String[] getData(String data) throws ParseException{
        String[] parsed = data.split(" ");
        if (parsed.length != 6) throw new RequestExceptions.ParseException();
        else {
            for (String item: parsed) System.out.println(item);
            return parsed;
        }
    }

    public User(String[] data) {
        this.userName = new Name(data[0], data[1], data[2]);
        this.bday = new BirthDay(data[3]);
        this.phone = new PhoneNumber(data[4]);
        this.sex = data[5].charAt(0);
    }

    public void validate() throws WrongDataException{
        try {
            this.userName.valid();
            this.bday.valid();
            this.phone.valid();
            if (this.sex == 'f' || this.sex == 'm')
                this.file = String.format("%s%s%s", 
                    System.getProperty("user.dir"),
                    File.separator,
                    this.userName.lastName);
            else throw new RequestExceptions.WrongDataException();
        } catch (WrongDataException w) {
            throw w;
        }
    }

    public String getFile() {
        return file;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %c",
            this.userName,
            this.bday,
            this.phone,
            this.sex);
    }
    /**
     * Name
     */
    public class Name {

        private String regex = "^[A-Z][a-z]+$";
        private String firstName;
        private String lastName;
        private String surName;

        private Name(String fname, String lname, String sname) {
            this.lastName = lname;
            this.firstName = fname;
            this.surName = sname;
        }

        private void valid() throws WrongDataException{
            if (!this.firstName.matches(regex)
                && this.lastName.matches(regex)
                && this.surName.matches(regex))
                    throw new RequestExceptions.WrongDataException();
        }

        public String toString() {
            return String.format("%s %s %s",
                this.firstName,
                this.lastName,
                this.surName);
        }
    }

    /**
     * Birth Day - string format: 'dd.mm.yyyy'.
     */
    public class BirthDay {

        String regex = "^(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).(19|20)\\d\\d$";
        private String date;

        private BirthDay(String date) {
            this.date = date;
        }

        private void valid() throws WrongDataException{
            if (!this.date.matches(regex))
                throw new RequestExceptions.WrongDataException();
        }
    }

    public class PhoneNumber {

        private String regex = "^\\d{11}";
        private String number;

        private PhoneNumber(String number) {
            this.number = number;
        }

        private void  valid() throws WrongDataException{
            if (!number.matches(regex))
                throw new RequestExceptions.WrongDataException();
        }
    }
}
