package com.userregistration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public Scanner scanner = new Scanner(System.in);
    UserDetails userDetails = new UserDetails();

    // User need to input valid first name and last name
    public void checkUserName() {
        UserDetails userDetails = new UserDetails();
        System.out.println("Enter your First Name: ");
        userDetails.setFirstName(scanner.next());
        System.out.println("Enter your Last Name: ");
        userDetails.setLastName(scanner.next());

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher1 = pattern.matcher(userDetails.getFirstName());
        Matcher matcher2 = pattern.matcher(userDetails.getLastName());

        //the matches() method tries to match the whole string against the pattern.
        boolean isFirstName =  matcher1.matches();
        boolean isLastName =  matcher2.matches();

        if(isFirstName && isLastName) {
            System.out.println(userDetails.firstName + " is a valid First Name.");
            System.out.println(userDetails.lastName + " is a valid Last Name.");
        }
        else {
            System.err.println("Please enter a valid Name.");
            System.out.println();
        }
    }

    //UC3: User need to input valid email address
    public void checkEmailAddress(){
        System.out.println("Enter your email address: ");
        userDetails.setEmailAddress(scanner.nextLine());

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("^(?=.{3,20}@)[a-zA-Z]+[A-Za-z0-9]+[- + . _]?[a-zA-Z0-9]+.@[^-_.][a-zA-Z0-9]+(\\.[a-z]+)(\\.[a-z]+)*$");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher = pattern.matcher(userDetails.getEmailAddress());

        //the matches() method tries to match the whole string against the pattern.
        boolean isEmail =  matcher.matches();

        if(isEmail) {
            System.out.println(userDetails.emailAddress + " is a valid email address.");
        }
        else {
            System.err.println("Please enter a valid email address.");
        }
    }

    //UC4: Valid Mobile No (country code followed by space and 10-digit number)
    public void checkValidMobileNumber(){
        System.out.print("Enter your mobile number: ");
        userDetails.setMobileNumber(scanner.nextLine());

        Pattern pattern = Pattern.compile("^[+][0-9]{2}\\s[0-9]{10}$");

        Matcher matcherObject = pattern.matcher(userDetails.getMobileNumber());
        boolean isMobileNumber =  matcherObject.matches();

        if(isMobileNumber)
            System.out.println(userDetails.mobileNumber + " is a valid  mobile number\n");
        else
            System.out.println(userDetails.mobileNumber + " is an invalid mobile number");
    }

    //UC8: Valid Password (Exactly 1 special character)
    public void checkValidPassword(){
        System.out.print("Enter your password: ");

        //Setting the input as password
        userDetails.setPassword(scanner.nextLine());

        //The Pattern class is used to define a pattern for the regex engine. Look up
        Pattern pattern = Pattern.compile("^((?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%&]*[!@#$%&][^!@#$%&]*$)[A-Za-z0-9!@#$%&]{8,})$");
        //Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&-+=()])([a-zA-Z0-9]*).{8,}$");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcherObject = pattern.matcher(userDetails.getPassword());

        //the matches() method tries to match the whole string against the pattern.
        boolean isPassword =  matcherObject.matches();

        if(isPassword) {
            System.out.println(userDetails.password + " is a valid password");
        }
        else {
            System.out.println(userDetails.password + " is an invalid password\n");
            System.out.println("Password should not contain less than 8 characters");
            System.out.println("Password should contain at least one upper case");
            System.out.println("Password should contain at least one number");
            System.out.println("Password should contain exactly one special character");
        }
    }

    public static void main(String[] args) {
        System.out.println("---------- User Registration ----------");
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.checkValidPassword();
    }
}
