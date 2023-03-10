class Solution {
    public static void main(String[] args) {
        String str = "00110";
        Solution solution = new Solution();
        System.out.println(solution.minFlipsMonoIncr(str));
    }

    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[2][2];
        char[] str = s.toCharArray();

        dp[0][0] = str[0] == '0' ? 0 : 1;
        dp[1][0] = str[0] == '1' ? 0 : 1;

        int i;
        for (i = 1; i < str.length; i++) {
            if (str[i] == '0') {
                dp[0][i % 2] = dp[0][(i - 1) % 2];
                dp[1][i % 2] = Math.min(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]) + 1;
            } else {
                dp[0][i % 2] = dp[0][(i - 1) % 2] + 1;
                dp[1][i % 2] = Math.min(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            }
        }

        return Math.min(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
    }
}