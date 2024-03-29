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

//Create New List
//TC : O(N + K) where NN is the number of nodes in the given list. If kk is large, it could still require creating many new empty lists.
//SC : O(Max(N, k))
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int N = getSize(head);
        
        int width = N / k; //on avg there are N / k nodes in each part
        int intialParts = N % k; //these first N % k parts have an extra item
        
        ListNode curr = head;
        for(int i = 0; i < k; ++i){
            ListNode dummy = new ListNode(-1);
            ListNode dHead = dummy, dTail = dummy;
            for(int j = 0; j < width + (i < intialParts ? 1 : 0); ++j){
                ListNode temp = new ListNode(curr.val);
                dTail.next = temp;
                dTail = temp;
                if(curr != null) curr = curr.next;
            }
            
            res[i] = dHead.next;
        }
        
        return res;
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

//Splitiing the Original List
//TC : O(N + K) where NN is the number of nodes in the given list. If kk is large, it could still require creating many new empty lists.
//SC : O(k)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int N = getSize(head);
        
        int width = N / k; //on avg there are N / k nodes in each part
        int intialParts = N % k; //these first N % k parts have an extra item
        
        ListNode curr = head;
        for(int i = 0; i < k; ++i){
            res[i] = curr;
            ListNode temp = curr;
            for(int j = 0; j < width + (i < intialParts ? 1 : 0) - 1; ++j){
                if(temp != null) temp = temp.next;
            }
            
            if(temp != null){
                curr = temp.next;
                temp.next = null;
            }
        }
        
        return res;
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
