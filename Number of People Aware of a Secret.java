 import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int delay = sc.nextInt();
        int forget = sc.nextInt();

        System.out.println(peopleAwareOfSecret(n, delay, forget));
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long peopleSharing = 0;
        long totalPeople = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                peopleSharing = (peopleSharing + dp[day - delay]) % MOD;
            }
            if (day - forget >= 1) {
                peopleSharing = (peopleSharing - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = peopleSharing;
        }

        for (int day = n - forget + 1; day <= n; day++) {
            totalPeople = (totalPeople + dp[day]) % MOD;
        }

        return (int) totalPeople;
    }
}