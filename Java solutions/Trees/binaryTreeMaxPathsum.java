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

    private int res;
    public int maxPathSum(TreeNode root) {


        // The main idea for this problem is that we can choose both paths
        // only once throughout the all the nodes in the tree.

        // Once we decide where the split has to be made, there on we can only
        // choose left or right subtree value.

        // So we begin with creating a res variable which will hold our final answer
        // and we initialize with root.val.

        res = root.val;

        // Here we are calling our helper function with root to begin with.
        // This value return gives us the max subtree path sum if we keep choosing
        // one path or other at each node.
        
        int temp = getMaxWithOneSplit(root);

        // Finally we return whichever of the 2 is greater, our internally computed res
        // with one instance of choosing both subtrees or the returned value from our
        // helper function.
        
        return Math.max(temp,res);
        
    }

    // Now we create an helper function to iterate over all nodes and at each 
    // node we make a decision either go left or right to get the max value.

    // When we reach null we return 0.
    // To handle negative values, we use comparison of a returned value with 0.

    // So say if a node has both subtree path sum as negative, then there is no
    // point in choosing either one and we simply add 0 to current node val.

    // At each node we also calculate the max value if we did not split and chose
    // both(as we can do it once) and update our res if we get a bigger value.

    // But when return a subtree path sum, we return current root.val + max
    // of right and left subtree path sum as we are assuming we are chosing one way
    // or another at each node.

    private int getMaxWithOneSplit(TreeNode root)
    {
        if(root == null)
            return 0;
            
        int left = getMaxWithOneSplit(root.left);
        int right = getMaxWithOneSplit(root.right);

        left = Math.max(left,0);
        right = Math.max(right,0);

        res = Math.max(res,root.val+left+right);

        return root.val + Math.max(left,right);
    }
}