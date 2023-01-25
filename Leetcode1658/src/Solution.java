import java.awt.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1,1};
        int x = 5;
        Solution solution = new Solution();

        System.out.println(solution.minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {
        int left = -1;
        int right = 0;
        int num = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = right; i < nums.length; i++) {
            num += nums[i];
        }
        while (left<right&right<=nums.length) {
            if (num == x) {
                if (answer > (left + 1) + (nums.length - right)) {
                    answer = (left + 1) + (nums.length - right);
                }
                if (right < nums.length)
                    num -= nums[right];
                right++;
            } else if (num > x) {
                if (right < nums.length)
                    num -= nums[right];
                else break;
                right++;
            } else if (num < x) {
                if (left < nums.length)
                    num += nums[left + 1];
                else break;
                left++;
            }
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else return answer;

    }


}
