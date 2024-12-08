import java.util.ArrayList;
import java.util.List;

public class leetCode129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<String> dfs(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfsHelper(root, "", res);
        return res;
    }

    private void dfsHelper(TreeNode node, String currentPath, List<String> res) {
        if (node == null) {
            return;
        }

        currentPath += node.val;

        if (node.left == null && node.right == null) {
            res.add(currentPath);
        } else {
            dfsHelper(node.left, currentPath, res);
            dfsHelper(node.right, currentPath, res);
        }
    }

    public int sumNumbers(TreeNode root) {
        List<String> resultsNumber = dfs(root);

        int sum = 0;
        for (String s : resultsNumber) {
            sum += Integer.valueOf(s);
        }

        return sum;
    }

}
