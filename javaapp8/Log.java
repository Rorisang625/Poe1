package javaapp8;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log {
    
    public static void main(String[] args) {
        String userName = null;
        String password = null;
        String firstName;
        String lastName;
        
        Scanner userInput = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Select choice:");
            int choice = userInput.nextInt();
            userInput.nextLine(); 
            
            if (choice == 1) {
                System.out.println("Please enter your first name:");
                firstName = userInput.nextLine();
                System.out.println("Please enter your last name:");
                lastName = userInput.nextLine();
                System.out.println("Please enter your username:");
                userName = userInput.nextLine();
                System.out.println("Please enter your password:");
                password = userInput.nextLine();
                
                if (checkUserName(userName) && checkPasswordComplexity(password)) {
                    registerUser(userName, password);
                } else {
                    System.out.println("Registration failed due to incorrect username or password format.");
                }
            } else if (choice == 2) {
                if (userName == null || password == null) {
                    System.out.println("No account registered. Please register first.");
                } else {
                    System.out.println("Enter your first name:");
                    String enteredName = userInput.nextLine();
                    System.out.println("Enter your last name:");
                    String enteredSurname = userInput.nextLine();
                    System.out.println("Please enter your username:");
                    String enteredUsername = userInput.nextLine();
                    System.out.println("Please enter your password:");
                    String enteredPassword = userInput.nextLine();
                    loginUser(userName, password, enteredUsername, enteredPassword, enteredName, enteredSurname);
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
      public static boolean checkUserName(String username) {
        if (username.length() <= 5 && username.contains("_")) {
            return true;
        } else {
            System.out.println("Username is not correctly formatted. Please ensure it contains an underscore and is no more than 5 characters.");
            return false;
        }
    }
    
     public static boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("Password is not correctly formatted. Please ensure it contains at least one digit, one uppercase letter, one lowercase letter, and one special character.");
            return false;
        }
    }
    public static void registerUser(String username, String password) {
        
        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("The user has been successfully registered.");
        } else {
            System.out.println("User registration failed!");
        }
    }
    
    public static void loginUser(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword, String name, String surname) {
        boolean success = enteredUsername.equals(registeredUsername) && enteredPassword.equals(registeredPassword);
        returnLoginStatus(success, name, surname);
    }
    
    public static void returnLoginStatus(boolean result, String name, String surname) {
        if (result) {
            System.out.println("Welcome " + name + " " + surname + ", it is great to see you.");
            System.exit(0);
        } else {
            System.out.println("Incorrect username or password. Please try again.");
        }
    }
}
