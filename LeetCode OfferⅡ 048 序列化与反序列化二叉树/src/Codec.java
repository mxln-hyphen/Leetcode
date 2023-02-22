import java.util.*;

public class Codec {
    public static void main(String[] args) {
        String str = "1,2";
        Codec codec = new Codec();
        TreeNode root = codec.deserialize(str);
        String answer = codec.serialize(root);
    }

    public static TreeNode NewNode(String val) {
        if (!val.equals("null")) {
            return new TreeNode(Integer.parseInt(val));
        } else {
            return null;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<String> ret = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode p = root;
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (p.val != -1001) {
                queue.add(p.left == null ? new TreeNode(-1001) : p.left);
                queue.add(p.right == null ? new TreeNode(-1001) : p.right);
                ret.add(String.valueOf(p.val));
            } else {
                ret.add("null");
            }
        }
        String answer = "";
        while (!ret.isEmpty()) {
            answer += new StringBuilder().append(ret.poll()).append(',');
        }
        return answer;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] args = data.split(",");
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
            if(!strqueue.isEmpty())
                p.right = NewNode(strqueue.poll());
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);
        }
        return root;
    }
}