import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        Solution solution = new Solution();
        System.out.println(solution.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));

        List<int[]> ret = new ArrayList<>();

        int[] next = intervals[0];
        for (int i = 0; i < intervals.length - 1; i++) {
            if (next[1] >= intervals[i + 1][0]) {
                next[1] = Math.max(intervals[i + 1][1], next[1]);
            } else {
                ret.add(next);
                next = intervals[i + 1];
            }
        }
        ret.add(next);
        int[][] result = new int[ret.size()][];
        return ret.toArray(result);
    }
}