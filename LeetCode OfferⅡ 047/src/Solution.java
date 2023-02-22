import java.lang.management.BufferPoolMXBean;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root != null) {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left == null && root.right == null && root.val == 0){
                return null;
            }
        }
        return root;
    }
}
