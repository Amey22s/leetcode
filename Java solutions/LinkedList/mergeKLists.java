import java.util.*;
/**
 * Definition for singly-linked list.
 */ 
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // For this problem we need a DS whose size variable so we first convert 
        // given array to array list.

        List<ListNode> tempLists = new ArrayList<>();

        for(ListNode list : lists)
        {
            tempLists.add(list);
        }

        if(tempLists.size() < 1)
        {
            return null;
        }

        // The main idea in this problem is to keep on merging 2 lists at a time 
        // and storing these merged lists in the original list.

        // We stop when we have just 1 merged list consisting of all the lists in the
        // given array.

        while(tempLists.size() > 1)
        {
            // We create a temp list to store newly created merged lists temporarily
            // which we then assign to tempLists at the end for size check.

            List<ListNode> mergeLists = new ArrayList<>();

            // This for loop is the main part of this problem as here we are taking 2 lists
            // at a time an merging them reducing our time complexity to O(nlogk).

            // n is to merge 2 lists of size n whereas logk is the time to merge k lists
            // two at a time.

            for(int i = 0; i < tempLists.size(); i = i + 2)
            {
                // If our second pointer goes out of bound, we simply add first pointer list.
                if(i+1 < tempLists.size())
                {
                    mergeLists.add(mergeTwoLists(tempLists.get(i),tempLists.get(i+1)));
                }
                else
                {
                    mergeLists.add(tempLists.get(i));
                }
            }
            tempLists = mergeLists;
        }

        // Finally we return the only element present in the tempList at index 0.

        return tempLists.get(0);
        
    }

    // This is a helper function which merges 2 linked list based on our condition in the question.
    // It returns a ListNode which is the head of the merged list.

    private ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                dummy.next = list1;
                list1 = list1.next;
            }
            else
            {
                dummy.next = list2;
                list2 = list2.next;
            }

            dummy = dummy.next;
        }

        if(list1 != null)
        {
            dummy.next = list1;
        }

        if(list2 != null)
        {
            dummy.next = list2;
        }

        return temp.next;
    }
}