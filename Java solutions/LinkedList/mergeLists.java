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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // The main idea here is that we keep a dummy node as a reference to which we 
        // keep adding nodes from our given lists.

        // We also need a temp reference pointer to this dummy node node to get the output
        // which is nothing but the next pointer of this dummy node. 

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        // We iterate over elements as long as both lists are non-empty. As soon as any one
        // of the lists becomes empty we stop adding elements to dummy.

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

        // Now we check if only one list has become empty or both. If only one is empty,
        // we add all the remaining elements from non-empty list to our dummy list.

        if(list1 != null)
        {
            dummy.next = list1;
        }

        if(list2 != null)
        {
            dummy.next = list2;
        }

        // Finally we return the next pointer of our original dummy node, which points to 
        // the first node in our merged list.

        return temp.next;

    }
}