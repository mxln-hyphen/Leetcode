class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode p = head;
        ListNode answer = null;
        p.next = new ListNode(2);
        p=p.next;
        answer = p;
        p.next = new ListNode(0);
        p=p.next;
        p.next = new ListNode(-4);
        p=p.next;
        p.next = answer;
        Solution solution = new Solution();
        System.out.println(solution.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        int k = 0;
        do {
            p1 = p1.next != null ? p1.next : null;
            p2 = p2.next != null && p2.next.next != null ? p2.next.next : null;
            k += 1;
            if (p2 == null) {
                return null;
            }
        } while (p1 != p2);
        p1 = dummy;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}