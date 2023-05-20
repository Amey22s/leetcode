/**
 * Definition for singly-linked list.
 * */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

class Solution {
    public boolean hasCycle(ListNode head) {


        // The main idea here is we use Floyd's hare tortoise approach.
        // We keep 2 pointers; slow and fast, where slow pointer moves 1 node 
        // at a time whereas fast pointer moves 2 nodes at a time.

        ListNode slow = head;
        ListNode fast = head;

        // We start with both pointers starting from head node and go one till we have a node for 
        // fast to go i.e. fast.next is not null. If there is a loop, this will never happen.
        // So the only way to get out of the loop in this case will be set to when slow
        // and fast pointers meet again(because of the difference in their speed they will
        // at some point.)

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return true;
            }
        }

        return false;

        

        // This is a O(n) time complexity solution as explained below:

        // Assume the length of list is n and so the max distance between slow and fast 
        // pointer there ever can be is n - 1. In each iteration as fast moves 2 steps and
        // slow moves 1 step, fast catches up by 1 step. So it will take at most n - 1 steps
        // to catch up which is O(n) time complexity worst case.
        
    }
}