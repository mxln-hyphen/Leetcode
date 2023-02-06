class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode p = l1;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        p = l2;
        p.next = new ListNode(6);
        p = p.next;
        p.next = new ListNode(4);

        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode answer = new ListNode(0);
        ListNode p = answer;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            p.next = new ListNode((carry + a + b) % 10);
            carry = (carry + a + b) / 10;
            p = p.next;
            l1 = l1 != null && l1.next != null ? l1.next : null;
            l2 = l2 != null && l2.next != null ? l2.next : null;
        }
        if (carry != 0) {
            p.next = new ListNode(1);
        }
        return reverseList(answer.next);
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