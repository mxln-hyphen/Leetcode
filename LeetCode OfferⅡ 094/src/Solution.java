class Solution {
    public static void main(String[] args) {
        String str = "aab";
        Solution solution = new Solution();
        System.out.println(solution.minCut(str));
    }

    public int minCut(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                char ch1 = s.charAt(j);
                char ch2 = s.charAt(i);
                if (ch1 == ch2 && (i <= j + 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }

        int dp[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}