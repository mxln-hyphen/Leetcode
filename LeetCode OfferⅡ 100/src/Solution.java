import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.methodname);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            Integer[] intline = line.toArray(new Integer[line.size()]);
            int prev = dp[0];
            dp[0] = dp[0] + intline[0];
            if (i == triangle.size() - 1) {
                answer = Math.min(answer, dp[0]);
            }
            for (int j = 1; j < intline.length; j++) {
                int item = Math.min(prev, j != intline.length - 1 ? dp[j] : Integer.MAX_VALUE) + intline[j];
                prev = dp[j];
                dp[j] = item;
                if (i == triangle.size() - 1) {
                    answer = Math.min(answer, dp[j]);
                }
            }
        }
        return answer == Integer.MAX_VALUE ? dp[0] : answer;

    }
}