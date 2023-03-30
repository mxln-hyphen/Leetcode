class Solution {
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        Solution solution = new Solution();
        System.out.println(solution.shortestCommonSupersequence(str1, str2));
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String[][] dp = new String[2][str2.length() + 1];

        dp[0][0] = "";

        for (int j = 1; j <= str2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + str2.charAt(j - 1);
        }

        int i;

        for (i = 1; i <= str1.length(); i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + str1.charAt(i - 1);
                } else {
                    String itemstr1 = dp[(i - 1) % 2][j] + str1.charAt(i - 1);
                    String itemstr2 = dp[i % 2][j - 1] + str2.charAt(j - 1);
                    dp[i % 2][j] = itemstr1.length() <= itemstr2.length() ?
                            itemstr1 : itemstr2;
                }
            }
        }

        return dp[(i-1)%2][str2.length()];
    }
}