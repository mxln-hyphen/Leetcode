import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        }

    public long minimizeArrayValue(int[] nums) {
        long min = Arrays.stream(nums).min().getAsInt();
        long max = Arrays.stream(nums).max().getAsInt();
        long low = min;
        long top = max;
        long mid;
        while (low < top) {
            mid = (low + top) / 2;
            boolean success = true;
            long have = 0;
            for (int i = 0; i < nums.length; i++) {
                have += mid - nums[i];
                if (have < 0) {
                    success = false;
                    break;
                }
            }
            if (success) {
                top = mid;
            } else {
                low = mid + 1;
            }
            //System.out.prlongln("["+low+","+mid+","+top+"]");
        }
        return low;
    }


}