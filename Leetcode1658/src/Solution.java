import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4};
        int x = 5;
        Solution solution = new Solution();
        solution.minOperations(nums, x);
    }

    public int minOperations(int[] nums, int x) {
        int[][] result = new int[nums.length + 1][nums.length + 1];
        int[][] operatetime = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[0][i] = x;
            result[i][0] = x;
        }
        for (int i = 0; i < operatetime.length; i++) {
            operatetime[0][i] = 0;
            operatetime[i][0] = 0;
        }
        putresult(result,operatetime);
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < nums.length + 1; j++) {
                //处理表格左值
                int leftopt = operatetime[i][j-1];
                int rnum = nums[nums.length-(i+j-2-leftopt)];
                if (rnum<result[i][j-1]){
                    result[i][j]=result[i][j-1]-rnum;
                    operatetime[i][j]=operatetime[i][j];
                }
                //处理表格上值
                int upopt = operatetime[i-1][j];
                int lnum = nums[upopt];
                if (lnum<result[i][j-1]&result[i][j-1]-lnum<result[i][j]){
                    result[i][j]=result[i][j-1]-lnum;
                    operatetime[i][j]=operatetime[i][j]+1;
                }
            }
        }
        return 1;
    }

    public void putresult(int[][] result, int[][] operatetime) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < operatetime.length; i++) {
            for (int j = 0; j < operatetime.length; j++) {
                System.out.printf("%d ", operatetime[i][j]);
            }
            System.out.println();
        }
    }
}
