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
    public boolean isSameTree(TreeNode p, TreeNode q) {


        // The main here is to divide the problem into different scenarios and
        // compare 2 nodes at a time.

        // 1. When both nodes are null they are same so return true.
        // 2. When only one of the 2 is null, they can never be the same so return false.
        // 3. When both are not null and both nodes have different values return false.

        // After comparing 2 current nodes we move on and compare their subtrees. We do
        // the same comparison recursively for each node. If the current nodes are same
        // and there subtrees are same then the whole trees are same.

        if(p == null && q == null)
            return true;

        if(p == null || q == null || p.val != q.val)
            return false;
        
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
        
    }
}