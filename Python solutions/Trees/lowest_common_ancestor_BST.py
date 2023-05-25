# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # The main idea here is we compare root val with p and q vals separately
        # and if the root lies between the 2 values, it means there is a split
        # and the current node has to be the lowest common ancestor.

        # This works because if both values are greater than root val, there has to be 
        # a node somewhere in right subtree who can be a common ancestor. So we search
        # in right subtree.

        # Similarly, if both values are smaller than root val, we search left subtree.

        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        
        return root