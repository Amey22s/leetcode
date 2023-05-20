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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // The main idea here is we use 2 pointer approach, where we keep 
        // one pointer(left) to one place before head of given list using a dummy node.

        // The second pointer(right), we move it ahead first individually by n places.

        ListNode right = head;
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;

        while(n > 0)
        {
            right = right.next;
            n--;
        }

        // Then we move move both pointers until right doesn't reach end of list.
        // At this point the left pointer will be one place behind the node to be
        // deleted.

        while(right != null)
        {
            left = left.next;
            right = right.next;
        }

        // Now we simply skip the node infront of left pointer.

        left.next = left.next.next;

        // Finally we return our head which is nothing but the next pointer of dummy node.

        return dummy.next;
        
    }
}