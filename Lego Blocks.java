import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(legoWall(n, m));
    }

    public static long legoWall(int n, int m) {
        long[] waysToFillRow = new long[m + 1];
        waysToFillRow[0] = 1;

        // Calculate number of ways to fill a row of width m
        for (int i = 1; i <= m; i++) {
            if (i >= 1) waysToFillRow[i] = (waysToFillRow[i] + waysToFillRow[i - 1]) % MOD;
            if (i >= 2) waysToFillRow[i] = (waysToFillRow[i] + waysToFillRow[i - 2]) % MOD;
            if (i >= 3) waysToFillRow[i] = (waysToFillRow[i] + waysToFillRow[i - 3]) % MOD;
            if (i >= 4) waysToFillRow[i] = (waysToFillRow[i] + waysToFillRow[i - 4]) % MOD;
        }

        long[] totalWays = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            totalWays[i] = powMod(waysToFillRow[i], n, MOD);
        }

        long[] solidWalls = new long[m + 1];
        solidWalls[1] = totalWays[1];
        for (int i = 2; i <= m; i++) {
            solidWalls[i] = totalWays[i];
            for (int j = 1; j < i; j++) {
                solidWalls[i] = (solidWalls[i] - (solidWalls[j] * totalWays[i - j]) % MOD + MOD) % MOD;
            }
        }

        return solidWalls[m];
    }

    public static long powMod(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}