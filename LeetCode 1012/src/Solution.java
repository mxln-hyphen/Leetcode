class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDupDigitsAtMostN(100));
    }

    public int numDupDigitsAtMostN(int n) {
        boolean[] dp = new boolean[n + 1];
        int answer = 0;
        int k = 0;
        int digit = 1;
        while (k <= n - 10) {
            if (dp[k / 10]) {
                for (int i = k; i < k + 10; i++) {
                    dp[i] = true;
                }
                answer += 10;
            } else {
                int item = k / 10;
                for (int i = 0; i < digit - 1; i++) {
                    dp[k + item % 10] = true;
                    item = item / 10;
                }
                answer += digit - 1;
            }
            k += 10;
            if (Math.pow(10, digit) == k)
                digit += 1;
        }
        for (int i = k; i < n + 1; i++) {
            if (dp[i / 10]) {
                answer += 1;
            } else {
                int digits = i % 10;
                int item = i/10;
                while (item > 0) {
                    if (digits == item%10) {
                        answer += 1;
                        break;
                    } else {
                        item = item / 10;
                    }
                }
            }

        }
        return answer;
    }
}