import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int buttomleftval = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            buttomleftval = queue.peek().val;
            while (len > 0) {
                len--;
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
        }
        return buttomleftval;
    }
}
