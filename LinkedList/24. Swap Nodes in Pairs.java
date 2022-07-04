//we will use two pointer concept, and move both pointers by distance 2!
//if (s.next == null) -> even number of nodes ke case me
//if (s.next.next == null) -> odd number of node ke case me
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null ){ //0 node or 1 node
            return head;
        }
        
        ListNode f = head;
        ListNode s = head.next;
        
        while(true){
            int temp = f.val;
            f.val = s.val;
            s.val = temp;
            
            if(s.next == null || s.next.next == null){
                break;
            }
            
            f = f.next.next;
            s = s.next.next;
        }
        
        return head;
    }
}
