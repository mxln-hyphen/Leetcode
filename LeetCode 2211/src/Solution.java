import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countCollisions("RLRSLL"));
    }

    public int countCollisions(String directions) {
        int[] nums = new int[directions.length()];
        for (int i = 0; i < directions.length(); i++) {
            switch (directions.charAt(i)) {
                case 'R':
                    nums[i] = 1;
                    break;
                case 'L':
                    nums[i] = -1;
                    break;
                case 'S':
                    nums[i] = 0;
                    break;
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(nums[0]);
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (now == 1)
                deque.push(now);
            else if (now == 0) {
                if (!deque.isEmpty() && deque.peek() != 0)
                    while (!deque.isEmpty() && deque.peek() == 1) {
                        deque.pop();
                        answer += 1;
                    }
                deque.push(now);
            } else {
                if (!deque.isEmpty() && deque.peek() == 1) {
                    answer += 2;
                    deque.pop();
                    while (!deque.isEmpty() && deque.peek() == 1) {
                        deque.pop();
                        answer += 1;
                    }
                    deque.push(0);
                } else if (!deque.isEmpty() && deque.peek() == 0) {
                    answer += 1;
                } else {
                    deque.push(now);
                }


            }
        }
        return answer;
    }
}