class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] answer = new int[nums.length];
        int maxanswer = 0;
        //偷第一家
        answer[0] = nums[0];
        answer[1] = answer[0];
        for (int i = 2; i < nums.length - 1; i++) {
            answer[i] = Math.max(answer[i - 2] + nums[i], answer[i - 1]);
        }
        maxanswer = answer[nums.length - 2];
        //不偷第一家,偷第二家
        answer = new int[nums.length];
        answer[0] = 0;
        answer[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            answer[i] = Math.max(answer[i - 2] + nums[i], answer[i - 1]);
        }
        maxanswer = Math.max(maxanswer, answer[nums.length - 1]);
        //不偷第一家和第二家
        answer = new int[nums.length];
        answer[0] = 0;
        answer[1] = 0;
        for (int i = 2; i < nums.length; i++) {
            answer[i] = Math.max(answer[i - 2] + nums[i], answer[i - 1]);
        }
        maxanswer = Math.max(maxanswer, answer[nums.length - 1]);
        return maxanswer;
    }
}