import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(nums, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> NumToCount = new HashMap<>();
        for (int num : nums) {
            NumToCount.put(num, NumToCount.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : NumToCount.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                queue.add(entry);
                queue.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll().getKey();
        }
        return ret;

    }
}