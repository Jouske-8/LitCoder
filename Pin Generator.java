// Code Accuracy 100.00%
// Code Quality 88.54%
// Code Accuracy 92.69%
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        StringBuilder r = new StringBuilder();
        
        for (String n : in) {
            int sum = 0;
            for (char c : n.toCharArray()) sum += c - '0';
            while (sum > 9) {
                int temp = 0;
                while (sum > 0) {
                    temp += sum % 10;
                    sum /= 10;
                }
                sum = temp;
            }
            if (sum % 2 == 1) r.append((char)('a' + sum - 1));
            else r.append(sum);
        }
        System.out.println(r);
    }
}
