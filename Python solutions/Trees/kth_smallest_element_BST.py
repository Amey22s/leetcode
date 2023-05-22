from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:

        # The main idea here for iterative solution is to implement a stack 
        # of your own to hold nodes you have been through till now.

        # We use preorder traversal, which is go as left as possible. Once you are at
        # null we check the top most element in stack. This is the node we process first.
        # So we pop it and every time we pop an element, we increment n by 1. When n equals
        # k, we know we have our kth smallest element by virtue of preorder traversal.

        stack = []
        cur = root
        n = 0

        while cur or stack:

            while cur:
                stack.append(cur)
                cur = cur.left
            
            n += 1
            cur = stack.pop()

            if n == k:
                return cur.val
            
            cur = cur.right
        
        return -1