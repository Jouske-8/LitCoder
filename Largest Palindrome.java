 import java.util.Scanner;

public class Main {

    public static String makeLargestPalindrome(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] changed = new boolean[n];
        int mismatches = 0;

        // Step 1: Fix mismatches to make the string a palindrome
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - i - 1]) {
                chars[i] = chars[n - i - 1] = (char) Math.max(chars[i], chars[n - i - 1]);
                changed[i] = changed[n - i - 1] = true;
                mismatches++;
                k--; // Each mismatch uses one change
            }
        }

        // Step 2: Try to make the palindrome as large as possible
        for (int i = 0; i < n / 2 && k > 0; i++) {
            if (chars[i] != '9') {
                if (changed[i] || changed[n - i - 1]) {
                    // Already changed once, we only need one more change to set both to '9'
                    chars[i] = chars[n - i - 1] = '9';
                    k--;
                } else if (k >= 2) {
                    // Need two changes to set both to '9'
                    chars[i] = chars[n - i - 1] = '9';
                    k -= 2;
                }
            }
        }

        // Step 3: If we have an odd-length string, maximize the middle element
        if (n % 2 == 1 && k > 0) {
            chars[n / 2] = '9';
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: First line contains number of allowed changes
        int k = sc.nextInt();
        // Input: Second line contains the number as a string
        String s = sc.next();
        
        String result = makeLargestPalindrome(s, k);
        System.out.println(result);
        
        sc.close();
    }
}