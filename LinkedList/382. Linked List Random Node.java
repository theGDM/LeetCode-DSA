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
class Solution {
    int size = 0;
    ListNode curr = null;
    //TC : O(N), N is the size of the LL
    public Solution(ListNode head) {
        curr = head;
        while(head != null){
            size++;
            head = head.next;
        }
    }
    
    //TC : O(N * n), n is the numbers of getRandom Calls
    public int getRandom() {
        int x = (int)Math.floor(Math.random() * size);
        ListNode temp = curr;
        for(int i = 0; i < x; ++i){
            temp = temp.next;
        }
        
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
