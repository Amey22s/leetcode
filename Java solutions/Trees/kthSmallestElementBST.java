import java.util.*;;
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
    public int kthSmallest(TreeNode root, int k) {

        // The main idea here for iterative solution is to implement a stack 
        // of your own to hold nodes you have been through till now.

        // We use preorder traversal, which is go as left as possible. Once you are at
        // null we check the top most element in stack. This is the node we process first.
        // So we pop it and every time we pop an element, we increment n by 1. When n equals
        // k, we know we have our kth smallest element by virtue of preorder traversal.

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int n = 0;

        while(cur != null || !stack.isEmpty())
        {
            while(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            
            n++;
            cur = stack.pop();

            if(n == k)
                return cur.val;
            
            cur = cur.right;
        }
        
        return -1;
    }
}