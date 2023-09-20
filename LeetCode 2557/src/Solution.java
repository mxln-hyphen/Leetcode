import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCount(new int[]{1, 4, 6}, 6, 4));
    }

    public int maxCount(int[] banned, int n, long maxSum) {
        int[] newarrays = new int[banned.length + 2];
        System.arraycopy(banned, 0, newarrays, 0, banned.length);
        newarrays[newarrays.length - 1] = n + 1;
        newarrays[newarrays.length - 2] = 0;
        banned = newarrays;
        Arrays.sort(banned);
        int i = 0;
        int answer = 0;
        while (maxSum > 0 && i < banned.length - 1) {
            if (i < banned.length - 1 && banned[i + 1] - banned[i] != 1) {
                for (int j = banned[i] + 1; j < banned[i + 1]; j++) {
                    maxSum -= j;
                    answer++;
                    if (maxSum < 0)
                        break;
                }
            }
            i++;
        }
        return maxSum < 0 ? answer - 1 : answer;
    }
}