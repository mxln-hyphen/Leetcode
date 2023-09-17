import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.flatten(null));
    }

    public Node flatten(Node head) {
        Deque<Node> stack = new ArrayDeque<>();
        Node p = head;
        while (p != null && (!stack.isEmpty()) || (p.child != null && p.next != null)) {
            if (p.child != null) {
                System.out.println(p.next.val);
                stack.push(p.next);
                p.child.prev = p;
                p.next = p.child;
                p.child = null;
            }
            if (p.next == null && p.child == null) {
                Node next = stack.pop();
                p.next = next;
                next.prev = p;
            }
            p = p.next;
        }

        return head;
    }
}