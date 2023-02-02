import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] nums={0,1,0};
        Solution solution = new Solution();
        System.out.println(solution.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int answer = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(map.getOrDefault(sum, -2)!=-2) {
                int k = i - map.getOrDefault(sum, 0);
                answer = answer < k ? k : answer;
            }
            map.put(sum, map.getOrDefault(sum, -2) == -2 ? i : map.getOrDefault(sum, -2));
        }
        return answer;
    }
}