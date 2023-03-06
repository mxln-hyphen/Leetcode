import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean[] index;

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        index = new boolean[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        helper(new ArrayList<>(), nums, 0, answer);
        return answer;
    }

    public void helper(List<Integer> onelist, int[] candidates, int idx, List<List<Integer>> answer) {
        if (idx == candidates.length) {
            answer.add(new ArrayList<>(onelist));
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (index[i] || (i > 0 && candidates[i] == candidates[i - 1] && !index[i - 1])) {
                    continue;
                }
                onelist.add(candidates[i]);
                index[i] = true;
                helper(onelist, candidates, idx + 1,answer);
                index[i] = false;
                onelist.remove(idx);

            }
        }
    }
}