import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestValues());
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        int layernum = 1;
        int layermax = -1;
        int layersize = 1;
        while (!queue.isEmpty()) {
            if (p != null) {
                queue.add(p.left);
                queue.add(p.right);
                layermax = p.val > layermax ? p.val : layermax;
            }
            layernum--;
            if (layernum == 0) {
                answer.add(layermax);
                layermax = -1;
                layersize *= 2;
                layernum = layersize;
            }
            p = queue.poll();
        }
        return answer;
    }
}