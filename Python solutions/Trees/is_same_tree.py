from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:

        # The main here is to divide the problem into different scenarios and
        # compare 2 nodes at a time.

        # 1. When both nodes are null they are same so return true.
        # 2. When only one of the 2 is null, they can never be the same so return false.
        # 3. When both are not null and both nodes have different values return false.

        # After comparing 2 current nodes we move on and compare their subtrees. We do
        # the same comparison recursively for each node. If the current nodes are same
        # and there subtrees are same then the whole trees are same.

        if not p and not q:
            return True
        if not p or not q or p.val != q.val:
            return False
        
        return (self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right))