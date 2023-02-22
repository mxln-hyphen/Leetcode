class Solution {
    int sum = 0;

    public static void main(String[] args) {
        String str = "4,9,0,null,1";
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(new TreeNode().Createtree(str)));
    }

    public int sumNumbers(TreeNode root) {
        PreOrderTraversal(root, 0);
        return sum;
    }

    public void PreOrderTraversal(TreeNode node, int num) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                sum += num * 10 + node.val;
                return;
            } else {
                PreOrderTraversal(node.left, num * 10 + node.val);
                PreOrderTraversal(node.right, num * 10 + node.val);
            }
        }
        return;
    }
}