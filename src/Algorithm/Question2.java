package Algorithm;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-19 18:54
 */

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class Question2 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l = new Question2().addTwoNumbers(l1, l2);
        new Question2().getInteger(l);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tmp = null;
        boolean plus = false;
        while (l1 != null || l2 != null || plus) {
            int num1 = -1;
            int num2 = -1;
            if (l1 == null) {
                num1 = 0;
            }
            if (l2 == null) {
                num2 = 0;
            }
            if (num1 == 0 && num2 == 0 && plus){
                tmp.next = new ListNode(1);
                plus = false;
            } else {
                int num = -1;
                if (num1 == -1) {
                    num1 = l1.val;
                    l1 = l1.next;
                }
                if (num2 == -1) {
                    num2 = l2.val;
                    l2 = l2.next;
                }
                if (plus) {
                    num = num1 + num2 + 1;
                } else {
                    num = num1 + num2;
                }
                if (num >= 10){
                    num = num % 10;
                    plus = true;
                }else {
                    plus = false;
                }
                if (result == null) {
                    result = new ListNode(num);
                    tmp = result;
                } else {
                    tmp.next = new ListNode(num);
                    tmp = tmp.next;
                }
            }

        }
        return result;
    }

    public int getInteger(ListNode l) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int result = 0;
        while (l != null) {
            result = result + (int) (Math.pow(10, i) * l.val);
            l = l.next;
            ++i;
        }
        System.out.println(result);
        return result;
    }

    //    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
