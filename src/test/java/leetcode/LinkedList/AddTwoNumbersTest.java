package leetcode.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    ListNode l1;
    ListNode l2;
    ListNode resList;

    @BeforeEach
    public void setUp() {
        l1 = createList(new ListNode(), new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = createList(new ListNode(), new int[]{9, 9, 9, 9});
        resList = createList(new ListNode(), new int[]{8, 9, 9, 9, 0, 0, 0, 1});
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode actList = new AddTwoNumbers().solve(l1, l2);
        while (actList != null || resList != null) {
            int expVal = resList != null ? resList.val : null;
            int actVal = actList != null ? actList.val : null;
            testElementsAreEqual(expVal, actVal);
            actList = actList != null ? actList.next : null;
            resList = resList != null ? resList.next : null;
        }
    }

    public void testElementsAreEqual(Integer expVal, Integer actVal) {
        Assertions.assertEquals(expVal, actVal);
    }

    private ListNode createList(ListNode list, int[] A) {
        ListNode temp = list;
        for (int num : A) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        ListNode newHead = list.next;
        list.next = null;
        return newHead;
    }
}
