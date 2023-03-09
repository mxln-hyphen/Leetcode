class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.methodname);
    }

    public int rob(int[] nums) {
        int[][] dp = new int[2][2];
        int i = 0;

        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (i = 1; i < nums.length; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = dp[0][(i - 1) % 2] + nums[i];
        }
        return Math.max(dp[0][(i-1) % 2], dp[1][(i-1) % 2]);
    }
}