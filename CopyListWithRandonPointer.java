import java.util.ArrayList;

public class CopyListWithRandonPointer {
    // T(n) = O(n ^ 2)
    // Space complexity: O(n)


     /** Definition for singly-linked list with a random pointer. */
     class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
     }

    // T(n) = O(n ^ 2)
    // Space complexity: O(n)

//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) return null;
//
//        RandomListNode copyRoot = new RandomListNode(head.label);
//        RandomListNode copyCur = copyRoot;
//        RandomListNode oriCur = head;
//
//        ArrayList<RandomListNode> oriNodeList = new ArrayList<RandomListNode>();
//        ArrayList<RandomListNode> copyNodeList = new ArrayList<RandomListNode>();
//
//
//
//        oriNodeList.add(head);
//        copyNodeList.add(copyRoot);
//        //Copy linkedlist without random reference
//        //Add origin list to nodeList.
//
//        while (oriCur != null && oriCur.next != null) { //O(n)
//
//            oriCur = oriCur.next;
//            oriNodeList.add(oriCur); //Add
//
//            copyCur.next = new RandomListNode(oriCur.label);
//            copyCur = copyCur.next;
//            copyNodeList.add(copyCur);
//        }
//
//
//
//        //Find the index in nodelist of each node's random reference
//        for (int i = 0; i < oriNodeList.size(); i++) { //O(n)
//            oriCur = oriNodeList.get(i);
//            copyCur =copyNodeList.get(i);
//
//            if (oriCur.random == null) continue;
//            for (int j = 0; j < oriNodeList.size(); j++) { //O(n)
//                if (oriCur.random == oriNodeList.get(j)) {
//                    copyCur.random = copyNodeList.get(j);
//                }
//            }
//        }
//
//        return copyRoot;
//    }

    // T(n) = O(n)
    // Space = O(n)

//     public RandomListNode copyRandomList(RandomListNode head) {
//         HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//         RandomListNode cur = head;

//         //Build map
//         while (cur != null) {
//             map.put(cur, new RandomListNode(cur.label));
//             cur = cur.next;
//         }

//         cur = head;

//         //Set next and random
//         while (cur != null) {
//             map.get(cur).next = map.get(cur.next);
//             map.get(cur).random = map.get(cur.random);
//             cur = cur.next;
//         }
//         return map.get(head);

    //     }
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}
