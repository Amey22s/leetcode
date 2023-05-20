# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # The main idea here is we keep an extra pointer behind our given head.
        # Now as we traverse through the given list nodes, we keep attaching our prev node
        # to current head. We also keep moving our prev node further with head so
        # utlimately we have our reverse linked list head in prev.

        prev = None
        
        while head:
            temp = head.next
            head.next = prev
            prev = head
            head = temp

        # Finally we return our new head for our reverse linked list.

        return prev