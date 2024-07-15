import java.util.Deque;
import java.util.ArrayDeque;

public class AddTwoSumLL {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0, r =0, i=0;
        Deque<Integer> q = new ArrayDeque<>();
        ListNode head = null;
        ListNode prev = null;

        while(l1 != null || l2 != null || c > 0) {
            i = c + (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val); // 12
            r = i%10; // 2
            c = i/10; // 1
            //q.add(r);
            ListNode ln = new ListNode(r);
            if(head == null)
                head = ln;
            if(prev != null)
                prev.next = ln;
            prev = ln;


            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        // process queue and construct listnode
        /*ListNode head = null;
        ListNode prev = null;
        while(!q.isEmpty()) {
            ListNode ln = new ListNode(q.remove());
            if(head == null)
                head = ln;
            if(prev != null)
                prev.next = ln;
            prev = ln;
        }*/
        return head;
    }
    
    public static void main(String[] args) {

    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}