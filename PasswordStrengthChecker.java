import java.util.Scanner;  

public class PasswordStrengthChecker {
    
    public static void main(String[] args) { 
        
        // Create and initialize the scanner to read user's input
        Scanner input = new Scanner(System.in); 
        System.out.print("Enter the password you would like to check: ");
        String password = input.nextLine();
        
        // Validate user's input (program will exit if password contains white spaces or is empty)  
        if (password.contains(" ")) {
            System.out.println("Invalid Password.");
            System.exit(0);
        } else if (password.isEmpty()) {
            System.out.print("Password cannot be empty.");
            System.exit(0);
        }
        
        // Close the scanner when done
        input.close(); 
        
        // Declare a variable criteriaCount
        int criteriaCount = checkPasswordCriteria(password);
        
        // Password strength evaluation based on how many criteria are met
        if (criteriaCount >=1 && criteriaCount <=3) {
            System.out.println("Password Strength: WEAK");
            
        } else if (criteriaCount == 4) {
            System.out.println("Password Strength: MODERATE");
            
        } else {
            System.out.println("Password Strength: STRONG");
        }
        
    }
    
    // Declare a method that will check the criteria in the password
    public static int checkPasswordCriteria(String password) {
        
        // Initialize a variable that will count met criteria (each criteria met increases the count by 1)
        int criteriaCount = 0;
        
        // Check if password has lowercase letters
        if (password.matches(".*[a-z].*")) {
            criteriaCount++;
        }
        
        // Check if password has uppercase letters
        if (password.matches(".*[A-Z].*")) {
            criteriaCount++;
        }
        
        // Check is password has digits
        if (password.matches(".*[0-9].*")) {
            criteriaCount++;
        }
        
        // Check if password has special characters
        if (password.matches(".*[! @ # $ % ^ & * ( ) - _ = + | [ ] { } ; : / ? . > ].*")) {
            criteriaCount++;
        }
        
        // Check if password is at least 8 characters long
        if (password.length() >=8) {
            criteriaCount++;
        }
        
        // Return a value of how many criteria are met
        return criteriaCount;
    }
    
 }


