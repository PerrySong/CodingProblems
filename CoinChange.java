import java.util.Arrays;

public class CoinChange {
    /**
         You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

         Example 1:

         Input: coins = [1, 2, 5], amount = 11
         Output: 3
         Explanation: 11 = 5 + 5 + 1
         Example 2:

         Input: coins = [2], amount = 3
         Output: -1
         Note:
         You may assume that you have an infinite number of each kind of coin.
     */
    // T = O(n * m) n: coin's types, m = amount
    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount + 1];
        Arrays.fill(num, Integer.MAX_VALUE);
        // initial num
        num[0] = 0;
        for (int coin : coins) {
            if (coin <= amount)
                num[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin > 0 && 1 + num[i - coin] > 0) { // prevent int become negative
                    num[i] = Math.min(num[i - coin] + 1, num[i]);
                }
            }
        }

        return num[amount] == Integer.MAX_VALUE ? -1 : num[amount];
    }
}
