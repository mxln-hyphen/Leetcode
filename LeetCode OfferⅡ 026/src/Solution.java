class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;

        Solution solution = new Solution();
        solution.reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next != null && quick.next.next != null ? quick.next.next : null;
        }
        ListNode p1 = head;
        ListNode p2 = reverseList(slow);
        while (p2.next != null) {
            ListNode itemup = p1.next;
            ListNode itemdown = p2.next;
            p1.next = p2;
            p2.next = itemup;
            p1 = itemup;
            p2 = itemdown;
        }
        return;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = first.next;
        while (second != null) {
            ListNode third = second.next != null ? second.next : null;
            second.next = first;
            first = second;
            second = third;

        }
        head.next = null;
        return first;
    }
}