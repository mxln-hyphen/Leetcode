import java.util.*;

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
        if (str.length() == 0) {
            return null;
        }
        String[] args = str.split(",");
        Queue<String> strqueue = new ArrayDeque<>();
        Collections.addAll(strqueue, args);
        strqueue.poll();

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = NewNode(args[0]);
        queue.add(root);

        TreeNode p;
        while (!strqueue.isEmpty()) {
            p = queue.poll();
            p.left = NewNode(strqueue.poll());
            if (!strqueue.isEmpty())
                p.right = NewNode(strqueue.poll());
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);
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
