/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */

class GfG{
    Node flatten(Node root){
	    if(root == null || root.next == null){ //0 or 1 node return it
	        return root;
	    }
	    
	    Node b = flatten(root.next);
	    return merge2SortedList(root, b); //postorder me merge kara do
    }
    
    Node merge2SortedList(Node first, Node second){
        Node head = new Node(-1);
        Node tail = head;
        
        while(first != null && second != null){
            if(first.data <= second.data){
                tail.bottom = first;
                first = first.bottom;
                tail = tail.bottom;
            }else{
                tail.bottom = second;
                second = second.bottom;
                tail = tail.bottom;
            }
        }
        
        if(first == null) tail.bottom = second;
        else tail.bottom = first;
        return head.bottom;
    }
}
