import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    Queue<Integer> queue = new PriorityQueue<>();
    int size;
    int k;

    public KthLargest(int k, int[] nums) {
        size = k;
        this.k = k;
        for (int num : nums) {
            if (queue.size() < k)
                queue.add(num);
            else {
                int item = queue.poll();
                queue.add(item > num ? item : num);
            }
        }
    }

    public int add(int val) {
        if (queue.size() < k)
            queue.add(val);
        else {
            int item = queue.poll();
            queue.add(item > val ? item : val);
        }

        return queue.peek();
    }
}