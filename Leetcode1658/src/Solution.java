import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,20,1,1,3};
        int x = 10;
        Solution solution = new Solution();

        System.out.println(solution.minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {
        int[][] result = new int[nums.length][nums.length];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = 0;
            }
        }
        result[0][0] = x;
        //putresult(result);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                int lnum = nums[i - 1];
                if (result[i - 1][0] >= lnum) {
                    result[i][0] = result[i - 1][0] - lnum;
                } else {
                    result[i][0] = -1;
                    break;
                }
            }
            if (result[i][0] == 0) {
                if (i + 0 < answer) {
                    answer = i + 0;
                }
            }
            for (int j = 1; j < nums.length; j++) {
                int rnum = nums[nums.length - j];
                if (result[i][j - 1] >= rnum) {
                    result[i][j] = result[i][j - 1] - rnum;
                } else {
                    result[i][j] = -1;
                    break;
                }
                if (result[i][j] == 0) {
                    if (i + j < answer) {
                        answer = i + j;
                    }
                }
            }
        }
        //putresult(result);
        if (answer== Integer.MAX_VALUE){
            answer=-1;
        }
        return answer;
    }

    public void putresult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        }

    }
}
