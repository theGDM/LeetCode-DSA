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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode dummyTail = dummy;
        
        head = head.next;
        while(head != null){
            int sum = 0;
            
            while(head.val != 0){
                sum += head.val;
                head = head.next;
            }
            
            ListNode temp = new ListNode(sum); //make new node
            dummyTail.next = temp;
            dummyTail = dummyTail.next;
            head = head.next; //next iteration
        }
        
        return dummyHead.next;
    }
}

//2nd Approach, with sc = O(1)
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
    public ListNode mergeNodes(ListNode head) {
        ListNode alternateTrav = head.next; //alternate traversal to count the sum inbetween nodes with 0 val
        ListNode mainTrav = head; //mainTrav to keep res track
        
        int currSum = 0;
        while(alternateTrav != null){
            if(alternateTrav.val == 0){
                mainTrav.val = currSum;
                if(alternateTrav.next != null){
                    mainTrav.next = alternateTrav;
                    mainTrav = mainTrav.next;
                }
                currSum = 0;
            }
            
            currSum += alternateTrav.val;
            alternateTrav = alternateTrav.next;
        }
        
        mainTrav.next = null;
        return head;
    }
}
