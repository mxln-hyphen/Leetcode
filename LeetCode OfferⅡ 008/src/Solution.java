class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(15,nums));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;
        int item = nums[j];
        while (j < nums.length && i <= j) {
            if (item >= target) {
                if (j-i+1<answer)
                    answer=j-i+1;
                i++;
                if (i<=j) {
                    item -= nums[i-1];
                }
            } else{
                j++;
                if (j<nums.length) {
                    item += nums[j];
                }
            }
        }
        return answer==Integer.MAX_VALUE?0:answer;
    }
}