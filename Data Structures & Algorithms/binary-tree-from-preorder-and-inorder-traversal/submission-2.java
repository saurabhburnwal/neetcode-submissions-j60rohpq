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
    private int start = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder);
    }

    public TreeNode build(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)   return null;
        TreeNode node = new TreeNode(preorder[start]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[start])
                mid = i;
        }
        start++;
        node.left = build(preorder,
                          Arrays.copyOfRange(inorder, 0, mid));
        node.right = build(preorder, 
                           Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return node;
    }
}

//        [3][4]
// p = [2,3,4]
//
//        [3][4]
//     [2] [3,4]
// p = [1,2,3,4] RLR
//
//        m
// i = [2,1,3,4] LRR
//        1
//      2   3
//            4
// p = [1,2,3,4]
// i = [2,1,3,4]
