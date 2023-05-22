from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        # The main idea here is we keep 2 boundary variables; min and max.
        # max is the maximum value permissible for current node and similarly, min
        # is the minimum value allowed.

        # We validate the BST by utilising the condition mentioned in the question:

        # 1. The value of current node has to be greater than all values in left subtree(i.e. max)
        #    and smaller than all values in right subtree(i.e. min)
        # 2. This above condition has to be true for all nodes in the tree, both left and right
        #    subtree.

        # We start the recursion by initializing max to positive infinity and min to negative infinity.
        # When we trickle down to left subtree, our max changes to current node val whereas when we 
        # trickle down right subtree, our min changes to current node value.

        def checkValidity(root: TreeNode, max: int, min: int) -> bool:

            if not root:
                return True

            return ((root.val < max and root.val > min) and 
                        checkValidity(root.left,root.val,min) and 
                        checkValidity(root.right,max,root.val))

        return checkValidity(root,float('inf'),float('-inf'))