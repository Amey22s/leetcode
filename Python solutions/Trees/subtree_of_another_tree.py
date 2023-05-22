from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        # The main idea here is to use our logic of checking if 2 trees are same
        # and applying it to each node in the main tree and check if we ever get a 
        # match. If we do, that returned true will propogate and make everything true.

        if not root:
            return False

        return (self.isSameTree(root,subRoot) or self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot))

    # This is a helper function to check if 2 trees are same or not.

    def isSameTree(self, root1: TreeNode, root2: TreeNode) -> bool:
        if not root1 and not root2:
            return True

        if not root1 or not root2 or root1.val != root2.val:
            return False

        return (self.isSameTree(root1.left,root2.left) and self.isSameTree(root1.right,root2.right))