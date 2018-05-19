
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(){};

    public void setValue(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        ListNode curr = this;
        for(int elem: arr) {

            System.out.println(elem);
            curr.setValue(elem);
            curr.next = new ListNode();
            curr = curr.next;
        }

    }

    public void printList() {
        ListNode curr = this;
        System.out.println("The list is: ");
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("\n");
    }
}

