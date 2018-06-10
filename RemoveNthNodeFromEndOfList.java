public class RemoveNthNodeFromEndOfList {
    /**
         Given a linked list, remove the n-th node from the end of list and return its head.

         Example:

         Given linked list: 1->2->3->4->5, and n = 2.

         After removing the second node from the end, the linked list becomes 1->2->3->5.
         Note:

         Given n will always be valid.

         Follow up:

         Could you do this in one pass?
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        for(int i = 0; i < n; i++) {
            node1 = node1.next;
        }
        if(node1 == null) {
            head = head.next;
            return head;
        }
        while(node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return head;
    }
}
