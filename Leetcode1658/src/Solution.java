import java.awt.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
        Solution solution = new Solution();

        System.out.println(solution.minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {
        //窗口长度
        int wlength = nums.length;

        while (wlength>0) {
            wlength = wlength - 1;
            int wleft = 0;
            int wright = wlength-1;
            x = x - nums[wright+1];
            int num = x;
            if (num==0){
                int answer=nums.length-wlength;
                return answer;
            }
            //窗口滑动
            for (int i = 0; i < nums.length-wlength; i++) {
                wleft++;
                wright++;
                num=num-nums[wleft-1]+nums[wright];
                if (num==0){
                    int answer=nums.length-wlength;
                    return answer;
                }
            }
        }
        return -1;
    }


}
