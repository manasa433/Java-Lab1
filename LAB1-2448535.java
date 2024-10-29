1.
The task requires validating a credit card number based on its length. The number must contain between 8 and 9 digits inclusive. If the number does not meet this criteria, the output should be "Invalid credit card number."

java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a credit card number
        System.out.print("Enter a credit card number: ");
        String ccNumber = scanner.nextLine();
        
        // Validate the credit card number
        if (isValidCreditCardNumber(ccNumber)) {
            System.out.println("Valid credit card number.");
        } else {
            System.out.println("Invalid credit card number.");
        }

        scanner.close();
    }

    public static boolean isValidCreditCardNumber(String ccNumber) {
        // Check the length of the credit card number
        int length = ccNumber.length();
        return length >= 8 && length <= 9 && ccNumber.matches("\\d+");
    }
}

2Q.
-Stepa:Remove the last digit of the `ccNumber`.

import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        // Step 1: Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Step 2: Prompt the user for input
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Step 3: Validate the length of the credit card number
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number");
            return; // Exit the program if invalid
        }

        // Step 4: Remove the last digit of ccNumber
        String lastDigit = ccNumber.substring(ccNumber.length() - 1); // Get the last digit
        String remainingDigits = ccNumber.substring(0, ccNumber.length() - 1); // Get remaining digits

        // Displaying results for debugging purposes
        System.out.println("Last digit: " + lastDigit);
        System.out.println("Remaining digits: " + remainingDigits);
        
        // Close the scanner
        scanner.close();
    }
}

- Step b: Reverse the remaining digits.

import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Check validity based on length
        if (isValidLength(ccNumber)) {
            // Remove the last digit
            String modifiedCCNumber = ccNumber.substring(0, ccNumber.length() - 1);
            
            // Reverse the remaining digits
            String reversedCCNumber = reverseString(modifiedCCNumber);
            
            // Check validity using switch-case
            switch (modifiedCCNumber.length()) {
                case 7:
                    System.out.println("Valid length after removing last digit (7 digits).");
                    break;
                case 8:
                    System.out.println("Valid length after removing last digit (8 digits).");
                    break;
                default:
                    System.out.println("Invalid length after processing.");
                    break;
            }

            // Print the reversed number
            System.out.println("Reversed remaining digits: " + reversedCCNumber);
        } else {
            System.out.println("Invalid credit card number.");
        }
    }

    public static boolean isValidLength(String ccNumber) {
        return ccNumber.length() >= 8 && ccNumber.length() <= 9;
    }

    // Method to reverse a string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
- Step c:Double the digits that are in the odd-numbered positions (1st, 3rd, 5th, etc.). If the
result of the doubling is a double-digit number, add the digits of that result (for example, if `5` is
doubled to `10`, then add `1 + 0 = 1`).
import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Check validity based on length
        if (isValidLength(ccNumber)) {
            // Remove the last digit
            String modifiedCCNumber = ccNumber.substring(0, ccNumber.length() - 1);
            
            // Reverse the remaining digits
            String reversedCCNumber = reverseString(modifiedCCNumber);
            
            // Double the digits in odd-numbered positions and process
            int[] processedDigits = processDigits(reversedCCNumber);
            
            // Check validity using switch-case
            switch (modifiedCCNumber.length()) {
                case 7:
                    System.out.println("Valid length after removing last digit (7 digits).");
                    break;
                case 8:
                    System.out.println("Valid length after removing last digit (8 digits).");
                    break;
                default:
                    System.out.println("Invalid length after processing.");
                    break;
            }

            // Print the processed digits
            System.out.print("Processed digits: ");
            for (int digit : processedDigits) {
                System.out.print(digit + " ");
            }
            System.out.println();
        } else {
            System.out.println("Invalid credit card number.");
        }
    }

    public static boolean isValidLength(String ccNumber) {
        return ccNumber.length() >= 8 && ccNumber.length() <= 9;
    }

    // Method to reverse a string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method to double digits in odd-numbered positions and sum if needed
    public static int[] processDigits(String reversedCCNumber) {
        int[] results = new int[reversedCCNumber.length()];

        for (int i = 0; i < reversedCCNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedCCNumber.charAt(i));
            if (i % 2 == 0) { // 0-based index for odd-numbered positions
                int doubled = digit * 2;
                // If doubled value is a double-digit number, sum its digits
                if (doubled > 9) {
                    doubled = (doubled / 10) + (doubled % 10);
                }
                results[i] = doubled;
            } else {
                results[i] = digit;
            }
        }
        return results;
    }
}

- Step d:Add up all the digits.

import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Check validity based on length
        if (isValidLength(ccNumber)) {
            // Remove the last digit
            String modifiedCCNumber = ccNumber.substring(0, ccNumber.length() - 1);
            
            // Reverse the remaining digits
            String reversedCCNumber = reverseString(modifiedCCNumber);
            
            // Double the digits in odd-numbered positions and process
            int[] processedDigits = processDigits(reversedCCNumber);
            
            // Calculate the sum of all processed digits
            int totalSum = sumDigits(processedDigits);
            
            // Check validity using switch-case
            switch (modifiedCCNumber.length()) {
                case 7:
                    System.out.println("Valid length after removing last digit (7 digits).");
                    break;
                case 8:
                    System.out.println("Valid length after removing last digit (8 digits).");
                    break;
                default:
                    System.out.println("Invalid length after processing.");
                    break;
            }

            // Print the processed digits and the total sum
            System.out.print("Processed digits: ");
            for (int digit : processedDigits) {
                System.out.print(digit + " ");
            }
            System.out.println();
            System.out.println("Total sum of processed digits: " + totalSum);
        } else {
            System.out.println("Invalid credit card number.");
        }
    }

    public static boolean isValidLength(String ccNumber) {
        return ccNumber.length() >= 8 && ccNumber.length() <= 9;
    }

    // Method to reverse a string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method to double digits in odd-numbered positions and sum if needed
    public static int[] processDigits(String reversedCCNumber) {
        int[] results = new int[reversedCCNumber.length()];

        for (int i = 0; i < reversedCCNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedCCNumber.charAt(i));
            if (i % 2 == 0) { // 0-based index for odd-numbered positions
                int doubled = digit * 2;
                // If doubled value is a double-digit number, sum its digits
                if (doubled > 9) {
                    doubled = (doubled / 10) + (doubled % 10);
                }
                results[i] = doubled;
            } else {
                results[i] = digit;
            }
        }
        return results;
    }

    // Method to sum all processed digits
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
}

- Step e:Subtract the last digit obtained in step a from 10.
import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Check validity based on length
        if (isValidLength(ccNumber)) {
            // Remove the last digit and store it
            int lastDigit = Character.getNumericValue(ccNumber.charAt(ccNumber.length() - 1));
            String modifiedCCNumber = ccNumber.substring(0, ccNumber.length() - 1);
            
            // Reverse the remaining digits
            String reversedCCNumber = reverseString(modifiedCCNumber);
            
            // Double the digits in odd-numbered positions and process
            int[] processedDigits = processDigits(reversedCCNumber);
            
            // Calculate the sum of all processed digits
            int totalSum = sumDigits(processedDigits);
            
            // Check validity using switch-case
            switch (modifiedCCNumber.length()) {
                case 7:
                    System.out.println("Valid length after removing last digit (7 digits).");
                    break;
                case 8:
                    System.out.println("Valid length after removing last digit (8 digits).");
                    break;
                default:
                    System.out.println("Invalid length after processing.");
                    break;
            }

            // Print the processed digits and the total sum
            System.out.print("Processed digits: ");
            for (int digit : processedDigits) {
                System.out.print(digit + " ");
            }
            System.out.println();
            System.out.println("Total sum of processed digits: " + totalSum);
            
            // Step e: Subtract last digit from 10
            int result = 10 - lastDigit;
            System.out.println("Result of 10 - last digit: " + result);
        } else {
            System.out.println("Invalid credit card number.");
        }
    }

    public static boolean isValidLength(String ccNumber) {
        return ccNumber.length() >= 8 && ccNumber.length() <= 9;
    }

    // Method to reverse a string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method to double digits in odd-numbered positions and sum if needed
    public static int[] processDigits(String reversedCCNumber) {
        int[] results = new int[reversedCCNumber.length()];

        for (int i = 0; i < reversedCCNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedCCNumber.charAt(i));
            if (i % 2 == 0) { // 0-based index for odd-numbered positions
                int doubled = digit * 2;
                // If doubled value is a double-digit number, sum its digits
                if (doubled > 9) {
                    doubled = (doubled / 10) + (doubled % 10);
                }
                results[i] = doubled;
            } else {
                results[i] = digit;
            }
        }
        return results;
    }

    // Method to sum all processed digits
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
}

- Step f:Compare the result of step e with the last digit obtained in step a. If they match, the
card number is valid; otherwise, it is invalid.
import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Check validity based on length
        if (isValidLength(ccNumber)) {
            // Remove the last digit and store it
            int lastDigit = Character.getNumericValue(ccNumber.charAt(ccNumber.length() - 1));
            String modifiedCCNumber = ccNumber.substring(0, ccNumber.length() - 1);
            
            // Reverse the remaining digits
            String reversedCCNumber = reverseString(modifiedCCNumber);
            
            // Double the digits in odd-numbered positions and process
            int[] processedDigits = processDigits(reversedCCNumber);
            
            // Calculate the sum of all processed digits
            int totalSum = sumDigits(processedDigits);
            
            // Check validity using switch-case
            switch (modifiedCCNumber.length()) {
                case 7:
                    System.out.println("Valid length after removing last digit (7 digits).");
                    break;
                case 8:
                    System.out.println("Valid length after removing last digit (8 digits).");
                    break;
                default:
                    System.out.println("Invalid length after processing.");
                    break;
            }

            // Print the processed digits and the total sum
            System.out.print("Processed digits: ");
            for (int digit : processedDigits) {
                System.out.print(digit + " ");
            }
            System.out.println();
            System.out.println("Total sum of processed digits: " + totalSum);
            
            // Step e: Subtract last digit from 10
            int result = 10 - lastDigit;
            System.out.println("Result of 10 - last digit: " + result);
            
            // Step f: Compare result with last digit
            if (result == lastDigit) {
                System.out.println("The credit card number is valid.");
            } else {
                System.out.println("The credit card number is invalid.");
            }
        } else {
            System.out.println("Invalid credit card number.");
        }
    }

    public static boolean isValidLength(String ccNumber) {
        return ccNumber.length() >= 8 && ccNumber.length() <= 9;
    }

    // Method to reverse a string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method to double digits in odd-numbered positions and sum if needed
    public static int[] processDigits(String reversedCCNumber) {
        int[] results = new int[reversedCCNumber.length()];

        for (int i = 0; i < reversedCCNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedCCNumber.charAt(i));
            if (i % 2 == 0) { // 0-based index for odd-numbered positions
                int doubled = digit * 2;
                // If doubled value is a double-digit number, sum its digits
                if (doubled > 9) {
                    doubled = (doubled / 10) + (doubled % 10);
                }
                results[i] = doubled;
            } else {
                results[i] = digit;
            }
        }
        return results;
    }

    // Method to sum all processed digits
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
}


