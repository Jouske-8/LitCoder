import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array and the number of operations
        //System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        
       // System.out.println("Enter the number of operations:");
        int q = scanner.nextInt();

        // Initialize the array and the difference array
        long[] arr = new long[n + 1];  // Use n+1 to handle boundary conditions easily
        
        // Process each operation
        for (int i = 0; i < q; i++) {
            int start = scanner.nextInt() - 1; // Convert to 0-based index
            int end = scanner.nextInt() - 1;   // Convert to 0-based index
            int value = scanner.nextInt();
            
            // Apply the difference array technique
            arr[start] += value;     // Add value at start index
            if (end + 1 < n) {
                arr[end + 1] -= value;  // Subtract value just after end index
            }
        }

        // Find the maximum value in the array
        long max = Long.MIN_VALUE;
        long currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];    // Take the prefix sum
            if (currentSum > max) {
                max = currentSum;    // Track the maximum value
            }
        }

        // Output the maximum value in the array after all operations
        System.out.println(max);

        scanner.close();
    }
}
