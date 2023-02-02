import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{1,1,1},2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int answer = 0;
        for (int num :
                nums) {
            sum += num;
            answer += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}