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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    public void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] treeData = data.split(",");
        System.out.println(Arrays.toString(treeData));
        return dfs(treeData, new int[]{0});
    }

    public TreeNode dfs(String[] treeData, int[] idx) {
        if (treeData[idx[0]].equals("#"))   return null;
        TreeNode node = new TreeNode(Integer.parseInt(treeData[idx[0]]));
        idx[0]++;
        node.left = dfs(treeData, idx);
        idx[0]++;
        node.right = dfs(treeData, idx);
        return node;
    }
}

// [1, 2, #, #, 3, 4, #, #, 5, #, #]
//  i
// 1,2,#,#,3,4,#,#,5,#,#,
