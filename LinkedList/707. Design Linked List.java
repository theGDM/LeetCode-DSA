class MyLinkedList {
    public static class LinkedList{
        int val;
        LinkedList next;
    }
    
    LinkedList head;
    LinkedList tail;
    int size;
    
    
    public int get(int index) {
        if(size == 0){
            System.out.println("List is empty");
            return -1;
        }else if(index < 0 || index >= size){
            System.out.println("Invalid arguments");
            return -1;
        }else{
            LinkedList curr = head;
            for(int i = 0; i < index; ++i){
                curr = curr.next;
            }
            return curr.val;
        }
    }
    
    public void addAtHead(int val) {
        LinkedList temp = new LinkedList();
        temp.val = val;
        if(size == 0){
            head = temp;
            tail = temp;
        }else{
            temp.next = head;
            head = temp;
        }
        ++size;
    }
    
    public void addAtTail(int val) {
        LinkedList temp = new LinkedList();
        temp.val = val;
        if(size == 0){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        ++size;
    }
    
    public void removeAtHead(){
        if(size == 0){
           System.out.println("List is empty");
           return; 
        }else if(size == 1){
            head = null;
            tail = null;
            size = 0;
        }else{
            head = head.next;
            --size;
        }
    }
    
    public void removeAtTail(){
        if(size == 0){
           System.out.println("List is empty");
           return; 
        }else if(size == 1){
            head = null;
            tail = null;
            size = 0;
        }else{
            LinkedList curr = head;
            for(int i = 0; i < size - 2; ++i){
                curr = curr.next;
            }
            tail = curr;
            curr.next = null;
            --size;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
           System.out.println("Invalid arguments");
           return;
        }else if(index == 0){
            addAtHead(val);
        }else if(index == size){
            addAtTail(val);
        }else{
            LinkedList temp = new LinkedList();
            temp.val = val;
            LinkedList curr = head;
            for(int i = 0; i < index - 1; ++i){
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;    
            ++size;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(size == 0){
            System.out.println("List is empty");
            return;
        }else if(index < 0 || index >= size){
           System.out.println("Invalid arguments");
           return;
        }else if(index == 0){
            removeAtHead();
        }else if(index == size - 1){
            removeAtTail();
        }else{
            LinkedList prev = head;
            for(int i = 0; i < index - 1; ++i){
                prev = prev.next;
            }
            prev.next = prev.next.next;
            --size;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
