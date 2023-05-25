import java.util.*;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // The main idea is to use preorder list to get the current root, because in preorder
        // traversal the first element is the list will always be the root node.

        // Next, we need to figure out where to partition left and right subtrees for this root.
        // We do this by searching our current root in inorder list and whatever is to its left
        // consists of our left subtree and whatever is to its right is our right subtree.

        // So now we have our 2 subarrays (one for left subtree and othe for right subtree) using 
        // which we recursively call our buildTree function to build left and right subtrees and 
        // assign it to current root's left and right.

        // We stop and return Null when both arrays are empty.

        if(preorder.length == 0 && inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = getIndex(root.val, inorder);

        int[] preorderLeftSplit = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] inorderLeftSplit = Arrays.copyOfRange(inorder, 0, mid);

        int[] preorderRightSplit = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] inorderRightSplit = Arrays.copyOfRange(inorder, mid+1, inorder.length);

        root.left = buildTree(preorderLeftSplit,inorderLeftSplit);
        root.right = buildTree(preorderRightSplit,inorderRightSplit);

        return root;
        
    }

    private int getIndex(int root, int[] arr)
    {
        for(int i =0; i < arr.length; i++)
        {
            if(root == arr[i])
            {
                return i;
            }
        }

        return -1;
    }
}