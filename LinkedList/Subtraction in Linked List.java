//TC : O(N)
class Solution{
    static Node reverse(Node head){
        Node prev = null, curr = head;
        while(curr != null){
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
    
    static int getSize(Node head){
        int sz = 0;
        while(head != null){
            head = head.next;
            sz++;
        }
        
        return sz;
    }
    
    static Node stripLeadingZeroes(Node curr){
        while(curr != null){
            if(curr.data != 0){
                break;
            }
            curr = curr.next;
        }
        
        if(curr == null) return new Node(0);
        else return curr;
    }
    
    static Node subLinkedList(Node l1, Node l2){
        //very important to remove leading zeroes if any
        l1 = stripLeadingZeroes(l1);
        l2 = stripLeadingZeroes(l2);

        int sz1 = getSize(l1); //get size of l1
        int sz2 = getSize(l2); //get size of l2
    
        Node small = l1; //lets assume l1 to be small 
        Node large = l2; //lets assume l2 to be small
        if(sz1 < sz2){
            small = l1;
            large = l2;
        }else if(sz2 < sz1){
            small = l2;
            large = l1;
        }else{
            Node t1 = l1;
            Node t2 = l2;
            
            while(t1 != null){
                if(t1.data < t2.data){
                    small = l1;
                    large = l2;
                    break;
                }else if(t2.data < t1.data){
                    small = l2;
                    large = l1;
                    break;
                }else{
                    t1 = t1.next;
                    t2 = t2.next;
                }
            }
        }
        
        Node revAns = subHelper(large, small);
        Node ans = reverse(revAns); //first reverse it 
        return stripLeadingZeroes(ans); //then trim the zeroes
    }
    
    public static void display(Node head){
        while(head != null){
            System.out.print(head.data);
            head = head.next;
        }
        System.out.println();
    }
    
    static Node subHelper(Node l1, Node l2){
        l1 = reverse(l1);
        l2 = reverse(l2);
        Node dummy = new Node(-1);
        Node dummyHead = dummy, dummyTail = dummy;
        int borrow = 0;
        while(l1 != null || l2 != null){
            int d1 = l1 == null ? 0 : l1.data;
            int d2 = l2 == null ? 0 : l2.data;
            
            int val = 0;
            if((d1 + borrow) < d2){
                val = (d1 + borrow + 10) - d2;
                borrow = -1;
            }else{
                val = (d1 + borrow) - d2;
                borrow = 0;
            }
            
            Node temp = new Node(val);
            dummyTail.next = temp;
            dummyTail = temp;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return dummyHead.next;
    }
}
