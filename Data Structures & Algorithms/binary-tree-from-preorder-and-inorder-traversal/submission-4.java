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
    private Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int l, int r) {
        if (l > r)  return null;
        TreeNode node = new TreeNode(preorder[start]);
        int m = map.get(node.val);
        start++;
        node.left = build(preorder, l, m - 1);
        node.right = build(preorder, m + 1, r);
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
