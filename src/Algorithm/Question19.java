package Algorithm;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-22 14:06
 */
//Given a linked list, remove the n-th node from the end of list and return its head.
public class Question19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        new Question19().removeNthFromEnd(head, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> mapList = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        mapList.put(0, dummy);
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            ++len;
            mapList.put(len, tmp);
            tmp = tmp.next;
        }
        if (n > len) {
            return head;
        } else {
            if (n == 1) {
                mapList.get(len - 1).next = null;
                return dummy.next;
            } else if (n == len) {
                return head.next;
            } else {
                int index = len - n + 1;
                tmp = mapList.get(index).next;
                mapList.get(index - 1).next = tmp;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
