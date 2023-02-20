import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 4, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        /**
         * 在数组前后分别添加一个-1作为边界
         */
        int[] zero = new int[1];
        zero[0] = -1;
        int[] item = new int[heights.length + 2];
        System.arraycopy(zero, 0, item, 0, 1);
        System.arraycopy(heights, 0, item, 1, heights.length);
        item[item.length - 1] = -1;
        heights = item;

        int[] leftlen = new int[heights.length];
        int answer = -1;

        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] >= heights[stack.peek()]) {
                leftlen[i] = 0;
                stack.push(i);
            } else {
                int rightlen = 0;
                leftlen[i] = 0;
                while (heights[stack.peek()] > heights[i]) {
                    int k = stack.pop();
                    answer = answer > (rightlen + leftlen[k] + 1) * heights[k] ? answer :
                            (rightlen + leftlen[k] + 1) * heights[k];
                    leftlen[i] += 1 + leftlen[k];
                    rightlen = leftlen[i];
                }
                stack.push(i);
            }
        }
        return answer == -1 ? 0 : answer;
    }
}