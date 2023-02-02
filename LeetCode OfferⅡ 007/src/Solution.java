import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        Solution solution = new Solution();
        List<List<Integer>> answer = solution.threeSum(nums);
        System.out.println(answer.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            answer = twoSum(nums, i, answer);
            int item = nums[i];
            while (i < nums.length && nums[i] == item) {
                i++;
            }
        }

        return answer;
    }

    public List<List<Integer>> twoSum(int[] nums, int i, List<List<Integer>> answer) {
        int j = i + 1;
        int k = nums.length-1;
        while (j < k & j < nums.length) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int item = nums[j];
                while (j < nums.length && nums[j] == item) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] > 0) {
                k--;
            } else {
                j++;
            }
        }
        return answer;
    }

}