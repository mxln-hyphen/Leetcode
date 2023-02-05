class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy1 = new ListNode(0);
        dummy1.next = headA;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = headB;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode pshort = p1 == null ? p2 : p1;
        ListNode plong = p1 != null ? headA : headB;
        while (pshort != null && plong != null) {
            pshort = pshort.next;
            plong = plong.next;
        }
        pshort = p1 == null ? headA : headB;
        while (pshort != null && plong != null) {
            if(pshort==plong){
                return pshort;
            }
            pshort = pshort.next;
            plong = plong.next;
        }
        return null;
    }
}