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

    public boolean isValidBST(TreeNode root) {

        // The main idea here is we keep 2 boundary variables; min and max.
        // max is the maximum value permissible for current node and similarly, min
        // is the minimum value allowed.

        // We validate the BST by utilising the condition mentioned in the question:

        // 1. The value of current node has to be greater than all values in left subtree(i.e. max)
        //    and smaller than all values in right subtree(i.e. min)
        // 2. This above condition has to be true for all nodes in the tree, both left and right
        //    subtree.

        // We start the recursion by initializing max to positive infinity and min to negative infinity.
        // When we trickle down to left subtree, our max changes to current node val whereas when we 
        // trickle down right subtree, our min changes to current node value.


        return checkValidity(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private boolean checkValidity(TreeNode root, long max, long min)
    {
        if(root == null)
            return true;

        return ((root.val > min && root.val < max) &&
                checkValidity(root.left, root.val, min) &&
                checkValidity(root.right, max, root.val));
    }

}
    