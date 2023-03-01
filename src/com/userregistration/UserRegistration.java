package com.userregistration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public Scanner scanner = new Scanner(System.in);

    //UC1: User need to input valid first name
    //The first name starts with capital letter and has minimum three characters
    public void checkUserFirstName() {

        System.out.print("Enter your First Name: ");
        String firstname = scanner.next();
        UserDetails userDetails = new UserDetails(firstname);

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher = pattern.matcher(userDetails.firstName);

        //the matches() method tries to match the whole string against the pattern.
        boolean isFirstName =  matcher.matches();
        if(isFirstName)
            System.out.println(userDetails.firstName + " is a valid First Name.");
        else
            System.err.println("Please enter a valid First Name.");
    }
    public static void main(String[] args) {
        System.out.println("---------- User Registration ----------");
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.checkUserFirstName();
    }
}
