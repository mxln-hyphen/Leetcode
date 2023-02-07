class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;


        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next != null && quick.next.next != null ? quick.next.next : null;
        }
        ListNode p1 = head;
        ListNode p2 = reverseList(slow);
        while (p2 != null) {
            if(p1.val!=p2.val)
                return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
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