class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        helper(cost.length - 1, dp, cost);
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    private void helper(int i, int[] dp, int[] cost) {
        if (i >= 2 && dp[i] == 0) {
            helper(i - 1, dp, cost);
            helper(i - 2, dp, cost);
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return;
    }

}