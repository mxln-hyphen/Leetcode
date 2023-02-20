import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        String[] matrix = {"10100","10111","11111","10010"};

        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(matrix));
    }

    public int maximalRectangle(String[] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[] item = new int[matrix[0].length()];
        int answer = -1;
        for (String s : matrix) {
            for (int i = 0; i < matrix[0].length(); i++) {
                item[i] = (s.charAt(i)-'0') == 1 ? 1 + item[i] : 0;
            }
            answer = largestRectangleArea(item) > answer ? largestRectangleArea(item) : answer;
        }
        return answer;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}