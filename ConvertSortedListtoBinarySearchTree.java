import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

    //Memory exceed version:
//    public TreeNode sortedListToBST(ListNode head) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        ListNode curr = head;
//        while(curr != null) {
//            arr.add(curr.val);
//        }
//        return helper(arr, 0, arr.size());
//    }
//
//    private TreeNode helper(ArrayList<Integer> arr, int start, int end) {
//        if(start == end) return null;
//        int mid = start + (end - start) / 2;
//        TreeNode node = new TreeNode(mid);
//        node.left = helper(arr, start, mid);
//        node.right = helper(arr, mid, end);
//        return node;
//
//    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {

        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;

        //pick the middle
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;

        }

        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);

        //recursively call this function for two sub list

        return node;
        //return node
    }


    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        ListNode list = new ListNode(arr);
        list.printList();
        ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();
        TreeNode root = c.sortedListToBST(list);
        root.printTreePreorder();
    }
}
