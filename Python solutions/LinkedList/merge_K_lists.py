# Definition for singly-linked list.
from typing import Optional
from ast import List

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        if len(lists) < 1:
            return None

        # The main idea in this problem is to keep on merging 2 lists at a time 
        # and storing these merged lists in the original list.

        # We stop when we have just 1 merged list consisting of all the lists in the
        # given array.

        while len(lists) > 1:
            # We create a temp list to store newly created merged lists temporarily
            # which we then assign to tempLists at the end for size check.

            merge_lists = []

            # This for loop is the main part of this problem as here we are taking 2 lists
            # at a time an merging them reducing our time complexity to O(nlogk).

            # n is to merge 2 lists of size n whereas logk is the time to merge k lists
            # two at a time.

            for i in range(0,len(lists),2):
                # If our second pointer goes out of bound, we simply add first pointer list.
                if i+1 < len(lists):
                    merge_lists.append(self.mergeTwoLists(lists[i],lists[i+1]))
                else:
                    merge_lists.append(lists[i])

            lists = merge_lists

        # Finally we return the only element present in the tempList at index 0.

        return lists[0]

    # This is a helper function which merges 2 linked list based on our condition in the question.
    # It returns a ListNode which is the head of the merged list.

    def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:
        dummy = ListNode()
        temp = dummy

        while list1 and list2:
            if list1.val < list2.val:
                dummy.next = list1
                list1 = list1.next
            else:
                dummy.next = list2
                list2 = list2.next

            dummy = dummy.next

        if list1:
            dummy.next = list1

        if list2:
            dummy.next = list2

        return temp.next