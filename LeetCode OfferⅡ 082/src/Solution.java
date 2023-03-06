import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(nums, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(new LinkedList<>(), 0, candidates, target);
        return answer;
    }


    public void helper(List<Integer> onelist, int i, int[] candidates, int sum) {
        if (sum == 0) {
            if(!answer.contains(onelist)) {
                answer.add(new LinkedList<>(onelist));
            }
            onelist = new LinkedList<>();
            return;
        } else if (sum > 0 && i < candidates.length) {
            helper(onelist, i + 1, candidates, sum);

            onelist.add(candidates[i]);
            helper(onelist, i + 1, candidates, sum - candidates[i]);
            onelist.remove(onelist.size() - 1);
        }
    }
}