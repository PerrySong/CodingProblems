public class PalindromeLinkedList {
    /**
         Given a singly linked list, determine if it is a palindrome.

         Example 1:

         Input: 1->2
         Output: false
         Example 2:

         Input: 1->2->2->1
         Output: true
         Follow up:
         Could you do it in O(n) time and O(1) space?
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;
        ListNode p1 = head;
        ListNode p3 = head.next;

        while(p3 != null && p3.next != null) {
            p1 = p1.next;
            p3 = p3.next.next;
        }
        //Reverse linkedlist
        p1 = p1.next;
        ListNode prev = null;
        ListNode next = p1.next;
        while(p1 != null) {
            p1.next = prev;
            prev = p1;
            p1 = next;
            if(next != null)
                next = next.next;
        }
        p1 = prev;
        while(p1 != null) {
            if(head.val != p1.val)
                return false;
            p1 = p1.next;
            head = head.next;
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(isPalindrome(b));

    }
}
