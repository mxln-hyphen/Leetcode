import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.methodname);
    }

    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length - 1][arr.length - 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = k > 0 && k < j ? dp[j][k] + 1 : 2;
                result = result > dp[i][j] ? result : dp[i][j];
            }
        }
        return result != 2 ? result : 0;
    }
}