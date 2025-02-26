package leetcode.recursion;

public class SwapNodeInPairs {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

        print(listNode);
        listNode = swapPairs(listNode);
        print(listNode);

    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode second = head.next;
        head.next = swapPairs(head.next.next);
        second.next = head;

        return second;
    }

    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
