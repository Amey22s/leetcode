from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:

        # This is the recursive version.

        # The main idea here is that starting from root node, we know if the current node
        # i.e. the root node is not null the max depth is 1 + maximum of depth among right
        # and left subtree.

        # So we use the recursive relation and build out final answer accordingly starting 
        # with depth 0 for null nodes at the bottom, depth 1 for leaf nodes and 1 + maximum
        # of left and right subtree for non leaf nodes.

        if not root:
            return 0
        
        return 1 + max(self.maxDepth(root.left),self.maxDepth(root.right))