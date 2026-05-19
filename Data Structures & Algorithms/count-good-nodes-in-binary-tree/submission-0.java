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
    public int goodNodes(TreeNode root) {
        return countNode(root, -111);
    }

    public int countNode(TreeNode root, int max) {
        if (root == null)   return 0;
        if (root.val >= max) {
            max = Math.max(max, root.val);
            return 1 + countNode(root.left, max) + countNode(root.right, max);
        } else {
            return countNode(root.left, max) + countNode(root.right, max);
        }
    }
}

//             1
//           2   -1
//         3  4  n n

// max = -111 -> 1
// 1 + (2, 1) + (-1, 1)


