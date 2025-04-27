package leetcode;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Q2_AddTwoNumbers {

    public static void main(String[] args) {
        runTests(new Q2_AddTwoNumbers()::addTwoNumbers);
        runTests((l1, l2) -> new Q2_AddTwoNumbers().addListsRecursive(l1, l2, 0));
    }

    public static void runTests(BiFunction<ListNode, ListNode, ListNode> solution) {
        assertTrue(
                isEqual(
                        toListNode(new int[]{7, 0, 8}),
                        solution.apply(toListNode(new int[]{2, 4, 3}), toListNode(new int[]{5, 6, 4}))
                )
        );
        assertTrue(
                isEqual(
                        toListNode(new int[]{0}),
                        solution.apply(toListNode(new int[]{0}), toListNode(new int[]{0}))
                )
        );
        assertTrue(
                isEqual(
                        toListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1}),
                        solution.apply(toListNode(new int[]{9,9,9,9,9,9,9}), toListNode(new int[]{9,9,9,9}))
                )
        );
    }

    private static ListNode toListNode(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    private static boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry + getValue(l1) + getValue(l2);
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            l1 = moveNext(l1);
            l2 = moveNext(l2);
        }

        return dummyHead.next;
    }


    private ListNode addListsRecursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry + getValue(l1) + getValue(l2);
        ListNode node = new ListNode(sum % 10);

        node.next = addListsRecursive(moveNext(l1), moveNext(l2), sum / 10
        );

        return node;
    }

    private int getValue(ListNode node) {
        return node != null ? node.val : 0;
    }

    private ListNode moveNext(ListNode node) {
        return node != null ? node.next : null;
    }

    public static class ListNode {
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
}
