/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//brute force O(n2);
class Solution {
    public int pairSum(ListNode head) {
        if(head == null){
            return 0;
        }
        
        int size = getSize(head); //O(n)
        int left = 0;
        int right = size - 1;
        
        int max = Integer.MIN_VALUE;
        while(left < right){ //O(n)
            ListNode ln = getNodeAt(head, left);//O(n)
            ListNode rn = getNodeAt(head, right);//O(n)
            
            //work
            max = Math.max(max, ln.val + rn.val);
            
            //updation
            left++;
            right--;
        }
        
        return max;
    }
    
    public ListNode getNodeAt(ListNode head, int idx){
        for(int i = 0; i < idx; ++i){
            head = head.next;
        }
        
        return head;
    }
    
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        
        return size;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//Optimized O(n);
class Solution {
    public int pairSum(ListNode head) {
        if(head == null){
            return 0;
        }
        
        ListNode mid = getMid(head); //O(n)
        ListNode second = mid.next; //first part
        mid.next = null; //2nd part
        
        //reverse the 2nd part
        second = reverse(second); //O(n)
        
        int max = Integer.MIN_VALUE;
        while(head != null){
            max = Math.max(max, head.val + second.val);
            head = head.next;
            second = second.next;
        }
        
        return max;
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
}
