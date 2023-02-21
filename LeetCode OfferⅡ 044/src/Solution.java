import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode().Createtree("1,3,2,5,3,null,9");

        Solution solution = new Solution();
        System.out.println(solution.largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        int layernum = 1;
        int layermax = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (p != null) {
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                layermax = p.val > layermax ? p.val : layermax;
            } else {

            }
            layernum--;
            if (layernum == 0) {
                answer.add(layermax);
                layermax = Integer.MIN_VALUE;
                layernum = queue.size();
            }
        }
        return answer;
    }
}