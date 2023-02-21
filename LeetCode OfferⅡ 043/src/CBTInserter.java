import java.util.ArrayDeque;
import java.util.Queue;

class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode p = root;
        while (p != null) {
            if (p.left != null && p.right != null) {
                queue.add(p.left);
                queue.add(p.right);
                queue.poll();
            } else if (p.left != null && p.right == null) {
                queue.add(p.left);
                break;
            } else {
                break;
            }
            p = queue.peek();
        }
    }

    public int insert(int v) {
        TreeNode fathernode = queue.peek();
        TreeNode newnode = new TreeNode(v);
        if (fathernode.left == null) {
            fathernode.left = newnode;
        } else {
            fathernode.right = newnode;
            queue.poll();
        }
        queue.add(newnode);
        return fathernode.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */