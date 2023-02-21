import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
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

    TreeNode(String val) {
        if (val != "null") {
            this.val = Integer.parseInt(val);
        }
    }


    public TreeNode Createtree(String[] args) {
        if (args.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(args[0]);
        TreeNode p = root;
        for (String arg : args) {
            if (p.left==null)
        }
    }

}
