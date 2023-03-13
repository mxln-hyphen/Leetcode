class Solution {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        Solution solution = new Solution();
        System.out.println(solution.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;

        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = (s1.charAt(i) == s3.charAt(i)) && dp[i][0];
        }

        for (int j = 0; j < s2.length(); j++) {
            dp[0][j + 1] = (s2.charAt(j) == s3.charAt(j)) && dp[0][j];
        }


        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);

                dp[i + 1][j + 1] = (ch1 == ch3) && (dp[i][j + 1]) || (ch2 == ch3) && (dp[i + 1][j]);

            }
        }

        return dp[s1.length()][s2.length()];
    }
}