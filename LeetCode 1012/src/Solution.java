class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDupDigitsAtMostN(1000));
    }

    public int numDupDigitsAtMostN(int n) {
        //boolean[] dp = new boolean[n + 1];
        int answer = 0;
        int k = 0;
        int digit = 1;
        while (k <= n - 10) {
            int item = k / 10;
            boolean[] dp = new boolean[10];
            for (int i = 0; i < digit - 1; i++) {
                if (dp[item % 10]) {
                    answer += 10;
                    k += 10;
                    break;//需要跳出两个循环
                } else {
                    dp[item % 10] = true;
                    item = item / 10;
                }
            }
            answer += digit - 1;
            k += 10;
            if (Math.pow(10, digit) == k)
                digit += 1;
        }

        int item = k-10 / 10;
        boolean[] dp = new boolean[10];
        for (int j = 0; j < digit - 1; j++) {
            if (dp[item % 10]) {
                answer += n-k+1;
                return answer;
            } else {
                dp[item % 10] = true;
                item = item / 10;
            }
        }
        for (int i = k; i < n+1; i++) {
            if(dp[i%10])
                answer++;
        }
        return answer;
    }
}