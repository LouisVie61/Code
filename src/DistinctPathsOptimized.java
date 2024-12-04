import java.util.*;

public class DistinctPathsOptimized {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        // dp[i] represents the number of distinct paths to reach City i
        int[] dp = new int[n + 1];
        dp[1] = 1;

        // Map to track the last occurrence of each divisor
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> divisors = getDivisors(a[i]);

            // Calculate dp[i] based on lastSeen entries for all divisors of a[i]
            for (int divisor : divisors) {
                if (lastSeen.containsKey(divisor)) {
                    dp[i] = (dp[i] + dp[lastSeen.get(divisor)]) % MOD;
                }
            }

            // Update lastSeen for all divisors of a[i]
            for (int divisor : divisors) {
                lastSeen.put(divisor, i);
            }
        }

        // The result is the value at dp[n], the number of ways to reach City n
        System.out.println(dp[n]);
    }

    // Utility to get all divisors of a number
    static List<Integer> getDivisors(int x) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != x / i) {
                    divisors.add(x / i);
                }
            }
        }
        return divisors;
    }
}
