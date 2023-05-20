/**
 * Definition for singly-linked list.
 * */

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode reverseList(ListNode head) {

        // The main idea here is we keep an extra pointer behind our given head.
        // Now as we traverse through the given list nodes, we keep attaching our prev node
        // to current head. We also keep moving our prev node further with head so
        // utlimately we have our reverse linked list head in prev.

        ListNode prev = null;
        
        while(head != null)
        {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        // Finally we return our new head for our reverse linked list.

        return prev;
    }
}