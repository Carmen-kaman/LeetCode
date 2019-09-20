package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-19 21:43
 */

//Trinocular operator
public class Question2Ans {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode curr = head;
        int num = 0;
        while (tmp1 != null || tmp2 != null) {
            int x = (tmp1 != null) ? tmp1.val : 0;
            int y = (tmp2 != null) ? tmp2.val : 0;
            int sum = num + x + y;
            num = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (tmp1 != null) tmp1 = tmp1.next;
            if (tmp2 != null) tmp2 = tmp2.next;

        }
        if (num > 0) {
            curr.next = new ListNode(num);
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
