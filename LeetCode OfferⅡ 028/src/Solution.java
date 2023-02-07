class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.flatten());
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;
        falttenchild(head);
        return head;
    }

    Node falttenchild(Node p) {
        Solution solution = new Solution();
        Node item = p.next;
        Node ret = null;
        if (p.child != null) {
            p.next = p.child;
            p.next.prev = p;
            Node child = p.child;
            p.child = null;
            ret = solution.falttenchild(child);
            if (item != null) {
                ret.next = item;
                item.prev = ret;
            }
        }
        if (item == null) {
            return ret != null ? ret : p;
        } else {
            ret = solution.falttenchild(item);
            return ret;
        }
    }

}