package leetcode.LinkedList;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">...</a>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public ListNode solve(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            sum = sum / 10;
        }
        ListNode head = dummyHead.next;
        dummyHead.next = null;
        return head;
    }
}
