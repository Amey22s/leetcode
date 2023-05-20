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
    public void reorderList(ListNode head) {

        // The main idea here we need to first find out mid point of the list.
        // This divides the list in 2 parts, out of which we reverse the second 
        // part. 

        // Once we have these 2 lists, we merge them. But this merge is based on
        // just interleaving 2 lists one node at a time starting from first list
        // and doesn't depend on any condition.

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // The second list starts from mid + 1 and we cut off the 2 lists by 
        // assigning null to mid node's next.

        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;

        right = reverseList(right);

        head = mergeLists(left,right);
        
    }

    // This is a helper function to reverse a linkedList given a head node.

    private ListNode reverseList(ListNode list)
    {
        ListNode prev = null;

        while(list != null)
        {
            ListNode temp = list.next;
            list.next = prev;
            prev = list;
            list = temp;
        }

        return prev;
    }

    // This is a helper function to merge two list just by interleaving them one
    // node at a time irrespective of their values.

    private ListNode mergeLists(ListNode list1, ListNode list2)
    {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        boolean first = true;

        while(list1 != null && list2 != null)
        {
            if(first)
            {
                dummy.next = list1;
                list1 = list1.next;
                first = false;
            }
            else
            {
                dummy.next = list2;
                list2 = list2.next;
                first = true;
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