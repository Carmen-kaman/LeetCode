package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-26 22:13
 */
//    Merge two sorted linked lists and return it as a new list.
//    The new list should be made by splicing together the nodes of the first two lists.

public class Question21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new Question21().mergeTwoLists(l1,l2);
        while (res!= null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        if (l1 == null && l2 == null) {
            return dummy.next;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode tmp = dummy;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    tmp.next = l2;
                    break;
                } else if (l2 == null) {
                    tmp.next = l1;
                    break;
                } else {
                    if (l1.val>l2.val){
                        tmp.next = l2;
                        l2 = l2.next;
                    }else {
                        tmp.next = l1;
                        l1 = l1.next;
                    }
                    tmp = tmp.next;
                }
            }
        }
        return dummy.next;
    }

   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
