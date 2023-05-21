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
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        // The main idea here is we create a queue and push root into it to begin with.

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Next we keep processing nodes in the queue till the queue is not empty.
        // We store the queue length which is nothing but number of elements at this level.
        // We also create a empty list to store elements at this level.

        // Then we iterate till we have not process all nodes at this level.
        // Processing a node means to pop it from the queue, if its non null, appending its
        // value to level list and adding its children to the queue.

        // Once we are done processing all elements at this level, we check level list, if 
        // not empty, we append it to our result list.

        while(!q.isEmpty())
        {
            int qLen = q.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < qLen; i++)
            {
                TreeNode temp = q.remove();

                if(temp != null)
                {
                    level.add(temp.val);
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            
            if(level.size() != 0)
            {
                res.add(level);
            }
        }

        // Finally we return our result list which is nothing but a list of all level lists
        // from all levels.
        
        return res;
       
    }
}