import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(new LinkedList<>(), nums);
        return answer;
    }

    public void helper(List<Integer> onelist, int[] candidates) {
        if (onelist.size() == candidates.length) {
            if (!answer.contains(onelist)) {
                answer.add(new LinkedList<>(onelist));
            }
            onelist = new LinkedList<>();
            return;
        } else{
            for (int candidate : candidates) {
                if (!onelist.contains(candidate)) {
                    onelist.add(candidate);
                    helper(onelist, candidates);
                    onelist.remove(onelist.size() - 1);
                }
            }
        }
    }
}