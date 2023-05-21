/**
 * Definition for a binary tree node.
 */
class TreeNode {
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
 
class Solution {
    public TreeNode invertTree(TreeNode root) {

        // The main idea here is to divide the problem into subproblems.
        // Basically, starting from root we switch its left and right subtree.
        // Then we move down to its left subtree and do the same for that root.

        // We keep going down till we do not reach null, where we simply return
        // null.

        // Then we do the same for right subtree. Once we have perform this for
        // all the nodes, we are done so we simply return root as everthing below
        // it have been inverted.

        if(root == null)
            return root;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
        
    }
}