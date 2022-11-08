//TC : O(N)
class Solution{
    //Function to reverse a linked list.
   
    Node reverseList(Node head){
        int size = getSize(head);
        reverseHelper(head, head, size, 0);
        return head;
    }
    
    public Node reverseHelper(Node left, Node right, int size, int count){
        if(left == null){
            return right;
        }
        
        right = reverseHelper(left.next, right, size, count + 1);
        
        if(count >= size / 2){
            swap(left, right);
        }
        
        return right.next;
    }
    
    public void swap(Node l, Node r){
        int temp = l.data;
        l.data = r.data;
        r.data = temp;
    }
    
    static int getSize(Node head){
        int sz = 0;
        while(head != null){
            head = head.next;
            sz++;
        }
        
        return sz;
    }
}
