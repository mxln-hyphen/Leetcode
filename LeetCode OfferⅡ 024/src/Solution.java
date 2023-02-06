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
        System.out.println(solution.reverseList(head));
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
        head.next=null;
        return first;
    }
}