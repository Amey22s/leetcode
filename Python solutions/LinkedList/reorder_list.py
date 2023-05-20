from typing import Optional
# Definition for singly-linked list.

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # The main idea here we need to first find out mid point of the list.
        # This divides the list in 2 parts, out of which we reverse the second 
        # part. 

        # Once we have these 2 lists, we merge them. But this merge is based on
        # just interleaving 2 lists one node at a time starting from first list
        # and doesn't depend on any condition.

        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # The second list starts from mid + 1 and we cut off the 2 lists by 
        # assigning null to mid node's next.

        right = slow.next
        slow.next = None
        left = head

        right = self.reverseList(right)

        head = self.mergeLists(left,right)
        

    # This is a helper function to reverse a linkedList given a head node.

    def reverseList(self, list: ListNode) -> ListNode:
        prev = None

        while list:
            temp = list.next
            list.next = prev
            prev = list
            list = temp

        return prev


    # This is a helper function to merge two list just by interleaving them one
    # node at a time irrespective of their values.

    def mergeLists(self, list1: ListNode, list2: ListNode) -> ListNode:
        dummy = ListNode()
        temp = dummy

        first = True

        while list1 and list2:
            if first:
                dummy.next = list1
                list1 = list1.next
                first = False
            else:
                dummy.next = list2
                list2 = list2.next
                first = True

            dummy = dummy.next

        if list1:
            dummy.next = list1

        if list2:
            dummy.next = list2

        return temp.next