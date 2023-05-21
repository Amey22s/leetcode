from typing import Optional
from ast import List
import collections
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        res = []

        # The main idea here is we create a queue and push root into it to begin with.

        queue = collections.deque()
        queue.append(root)

        # Next we keep processing nodes in the queue till the queue is not empty.
        # We store the queue length which is nothing but number of elements at this level.
        # We also create a empty list to store elements at this level.

        # Then we iterate till we have not process all nodes at this level.
        # Processing a node means to pop it from the queue, if its non null, appending its
        # value to level list and adding its children to the queue.

        # Once we are done processing all elements at this level, we check level list, if 
        # not empty, we append it to our result list.

        while queue:

            q_len = len(queue)

            level = []

            for i in range(q_len):
                temp = queue.popleft()

                if temp:
                    level.append(temp.val)

                    queue.append(temp.left)
                    queue.append(temp.right)
            
            if level:
                res.append(level)

        # Finally we return our result list which is nothing but a list of all level lists
        # from all levels.
        
        return res