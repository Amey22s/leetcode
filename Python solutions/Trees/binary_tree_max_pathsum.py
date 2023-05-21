from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:

        # The main idea for this problem is that we can choose both paths
        # only once throughout the all the nodes in the tree.

        # Once we decide where the split has to be made, there on we can only
        # choose left or right subtree value.

        # So we begin with creating a res variable which will hold our final answer
        # and we initialize with root.val.

        self.res = root.val

        # Now we create an helper function to iterate over all nodes and at each 
        # node we make a decision either go left or right to get the max value.

        # When we reach null we return 0.
        # To handle negative values, we use comparison of a returned value with 0.

        # So say if a node has both subtree path sum as negative, then there is no
        # point in choosing either one and we simply add 0 to current node val.

        # At each node we also calculate the max value if we did not split and chose
        # both(as we can do it once) and update our res if we get a bigger value.

        # But when return a subtree path sum, we return current root.val + max
        # of right and left subtree path sum as we are assuming we are chosing one way
        # or another at each node.

        def getMaxWithOneSplit(self, root: TreeNode) -> int:

            if not root:
                return 0
            
            left = getMaxWithOneSplit(self,root.left)
            right = getMaxWithOneSplit(self,root.right)

            left = max(left,0)
            right = max(right,0)

            self.res = max(self.res,root.val+left+right)

            return root.val + max(left,right)

        # Here we are calling our helper function with root to begin with.
        # This value return gives us the max subtree path sum if we keep choosing
        # one path or other at each node.
        
        temp = getMaxWithOneSplit(self,root)

        # Finally we return whichever of the 2 is greater, our internally computed res
        # with one instance of choosing both subtrees or the returned value from our
        # helper function.
        
        return max(temp,self.res)