// Code Accuracy 100.00%
// Code Quality 82.92%
// Code Accuracy 89.03%

import java.util.Scanner;

public class Main {

    // Check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Check if a number is a special prime
    public static boolean isSpecialPrime(int n) {
        String digits = String.valueOf(n);

        // Check all concatenations of the digits (from left to right)
        for (int i = 1; i <= digits.length(); i++) {
            int subNumber = Integer.parseInt(digits.substring(0, i));
            if (!isPrime(subNumber)) {
                return false;
            }
        }
        return true;
    }

    // Find the largest special prime smaller than the limit
    public static int findLargestSpecialPrime(int limit) {
        for (int num = limit - 1; num > 1; num--) {
            if (isSpecialPrime(num)) {
                return num;
            }
        }
        return -1;  // No special prime found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take the input
        int inputNum = sc.nextInt();
        
        // Find and print the largest special prime
        int result = findLargestSpecialPrime(inputNum);
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("No special prime found");
        }

        sc.close();
    }
}
