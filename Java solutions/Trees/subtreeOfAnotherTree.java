/**
 * Definition for a binary tree node.
 */
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
 
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // The main idea here is to use our logic of checking if 2 trees are same
        // and applying it to each node in the main tree and check if we ever get a 
        // match. If we do, that returned true will propogate and make everything true.

        if(root == null)
            return false;

        return (isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));
        
    }

    // This is a helper function to check if 2 trees are same or not.

    private boolean isSameTree(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
        {
            return true;
        }

        if(root1 == null || root2 == null || root1.val != root2.val)
        {
            return false;
        }

        return (isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right));
    }
}