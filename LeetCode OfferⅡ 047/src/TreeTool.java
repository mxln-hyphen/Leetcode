import java.util.ArrayList;
import java.util.List;

public class TreeTool {
    /**
     * 二叉树后序遍历（递归形式）
     */
    static public List<TreeNode> PostOrderTraversal(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        PostOrderdfs(root, ret);
        return ret;
    }

    private static TreeNode PostOrderdfs(TreeNode node, List<TreeNode> order) {
        while (node != null) {
            PostOrderdfs(node.left, order);
            PostOrderdfs(node.right, order);
            order.add(node);
        }
        return node;
    }
}
