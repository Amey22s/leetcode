from ast import List
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        # The main idea is to use preorder list to get the current root, because in preorder
        # traversal the first element is the list will always be the root node.

        # Next, we need to figure out where to partition left and right subtrees for this root.
        # We do this by searching our current root in inorder list and whatever is to its left
        # consists of our left subtree and whatever is to its right is our right subtree.

        # So now we have our 2 subarrays (one for left subtree and othe for right subtree) using 
        # which we recursively call our buildTree function to build left and right subtrees and 
        # assign it to current root's left and right.

        # We stop and return Null when both arrays are empty.

        if not preorder and not inorder:
            return None

        root = TreeNode(preorder[0])
        mid = inorder.index(root.val)

        root.left = self.buildTree(preorder[1:mid+1],inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:],inorder[mid+1:])

        return root