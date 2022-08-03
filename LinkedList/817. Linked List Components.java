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

//TC : O(nums.length) + O(n)
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        
        int count = 0;
        while(head != null){
            if(set.contains(head.val)){
                count++;
                
                while(head != null && set.contains(head.val) == true){
                    head = head.next;
                }
            }else{
                head = head.next;
            }
            
        }
        
        return count;
    }
}
