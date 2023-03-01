import java.util.Random;

class Solution {
    int answer = 0;
    int k;

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int end = nums.length - 1;
        int start = 0;
        this.k = nums.length - k + 1;
        quicksort(nums, start, end);
        return answer;
    }

    public void quicksort(int[] nums, int start, int end) {
        if (end > start) {
            int mid = partition(nums, start, end);
            if (mid == k-1) {
                answer = nums[k-1];
            } else if (mid > k-1) {
                quicksort(nums, start, mid - 1);
            } else {
                quicksort(nums, mid + 1, end);
            }
        } else {
            answer = nums[k-1];
        }
    }

    public int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);

        int p1 = start - 1;
        for (int p2 = start; p2 < end; p2++) {
            if (nums[p2] <= nums[end]) {
                p1++;
                swap(nums, p1, p2);
            }
        }
        p1++;
        swap(nums, p1, end);
        return p1;
    }

    public void swap(int[] nums, int a, int b) {
        int item = nums[a];
        nums[a] = nums[b];
        nums[b] = item;
    }
}