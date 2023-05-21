from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        # The main idea here is to divide the problem into subproblems.
        # Basically, starting from root we switch its left and right subtree.
        # Then we move down to its left subtree and do the same for that root.

        # We keep going down till we do not reach null, where we simply return
        # null.

        # Then we do the same for right subtree. Once we have perform this for
        # all the nodes, we are done so we simply return root as everthing below
        # it have been inverted.

        if not root:
            return root
        
        temp = root.left
        root.left = root.right
        root.right = temp

        self.invertTree(root.left)
        self.invertTree(root.right)

        return root

