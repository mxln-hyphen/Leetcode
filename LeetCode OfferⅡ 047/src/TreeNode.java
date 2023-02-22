import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode NewNode(String val) {
        if (!val.equals("null")) {
            return new TreeNode(Integer.parseInt(val));
        } else {
            return null;
        }
    }

    /**
     * 根据字符串构造二叉树
     *
     * @param str
     * @return
     */
    public TreeNode Createtree(String str) {
        String[] args = str.split(",");
        if (args.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = NewNode(args[0]);
        TreeNode p = root;
        int i = 1;
        while (i != args.length) {
            p.left = NewNode(args[i++]);
            if (p.left != null)
                queue.add(p.left);
            if (i != args.length) {
                p.right = NewNode(args[i++]);
                if (p.left != null)
                    queue.add(p.right);
            }
            p = queue.poll();
        }
        return root;
    }

    /**
     * 二叉树后序遍历（递归形式）
     */
    public List<TreeNode> PostOrderTraversal(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        PostOrderdfs(root, ret);
        return ret;
    }

    public TreeNode PostOrderdfs(TreeNode node, List<TreeNode> order) {
        while (node != null) {
            PostOrderdfs(node.left, order);
            PostOrderdfs(node.right, order);
            order.add(node);
        }
        return node;
    }


}
