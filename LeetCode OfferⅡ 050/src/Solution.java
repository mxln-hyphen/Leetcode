import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int targetSum;
    int answer;

    public static void main(String[] args) {
        String str = "715827882,715827882,null,715827882,null,1,null,715827882,null,715827882,null,715827882,null";
        Solution solution = new Solution();
        System.out.println(solution.pathSum(new TreeNode().Createtree(str), -3));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        answer = 0;
        this.targetSum = targetSum;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        PreOrderTraversal(root, 0, map);
        return answer;
    }

    public void PreOrderTraversal(TreeNode node, int num, Map<Integer, Integer> map) {
        if (node != null) {
            num += node.val;
            if (map.containsKey(num - targetSum))
                answer += map.getOrDefault(num- targetSum, 0);
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else
                map.put(num, 1);

            PreOrderTraversal(node.left, num, map);
            PreOrderTraversal(node.right, num, map);

            if (map.get(num) != 1) {
                map.replace(num, map.get(num) - 1);
            } else
                map.remove(num);
            num -= node.val;
        }
        return;
    }
}