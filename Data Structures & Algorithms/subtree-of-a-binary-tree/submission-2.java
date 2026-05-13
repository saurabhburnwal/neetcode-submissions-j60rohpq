/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)    return true;
        boolean ans = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            ans = isSameTree(node, subRoot);
            if (ans == true)    return ans;
            if (node.left != null)  q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return ans;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(q == null) return p == null;
        
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
