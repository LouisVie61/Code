public class leetCode322 {
    // int[] coin with length = n.
    // amount.
    // return the way contains the fewest amount of coint to make the value equal to amount.

    // int[] coin = {1, 2, 5} amount = 11;
    // 11 = 5 + 5 + 1;
    // answer = 3;

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j : coins) {
                if (i >= j) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
