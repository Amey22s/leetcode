/**
 * Definition for a binary tree node.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // The main idea here is we compare root val with p and q vals separately
        // and if the root lies between the 2 values, it means there is a split
        // and the current node has to be the lowest common ancestor.

        // This works because if both values are greater than root val, there has to be 
        // a node somewhere in right subtree who can be a common ancestor. So we search
        // in right subtree.

        // Similarly, if both values are smaller than root val, we search left subtree.


        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        if(root.val > p.val && root.val > q.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val < p.val && root.val < q.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}


