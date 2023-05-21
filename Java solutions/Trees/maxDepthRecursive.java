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
    public int maxDepth(TreeNode root) {

        // This is the recursive version.

        // The main idea here is that starting from root node, we know if the current node
        // i.e. the root node is not null the max depth is 1 + maximum of depth among right
        // and left subtree.

        // So we use the recursive relation and build out final answer accordingly starting 
        // with depth 0 for null nodes at the bottom, depth 1 for leaf nodes and 1 + maximum
        // of left and right subtree for non leaf nodes.

        if(root == null)
        {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}