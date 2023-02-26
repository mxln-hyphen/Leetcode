import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((p1, p2)
                -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.add(new int[]{i, 0});
        }

        List<List<Integer>> ret = new LinkedList<>();
        while (!minHeap.isEmpty() && k-- > 0) {
            int[] item = minHeap.poll();
            ret.add(Arrays.asList(nums1[item[0]], nums2[item[1]]));

            if (item[1] < nums2.length-1) {
                minHeap.add(new int[]{item[0], item[1] + 1});
            }
        }
        return ret;
    }
}