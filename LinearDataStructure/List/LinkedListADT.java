package LinearDataStructure.List;public class LinkedListADT  {

  
    SinglyNode head;
    int size;

    public void addLast(int val){
        SinglyNode node = new SinglyNode(val);
        if(head==null){
            head=node;
            size++;
            return;
        }
        SinglyNode last =findLastNode(head);
        last.next=node;
        size++;
      
    }

    private SinglyNode findLastNode(SinglyNode head2) {
        SinglyNode temp =head2;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }

    public void delete(int key){
        if(head==null){
            System.out.println("List is empty");
            return;
        }

        SinglyNode temp=head;
        SinglyNode prev=null;
        
        // If head node itself holds the key to be deleted
        if (temp != null && temp.val == key) {
            head = temp.next; 
            return;
        }
           
         // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.val != key) {
            prev = temp;
            temp = temp.next;
        }
        
        // If key was not present in linked list
        if(temp==null){
            System.out.println("Key not present");
           return;
        }
        prev.next=temp.next;
        print();

    }
    
    public void addFirst(int val){
        SinglyNode node = new SinglyNode(val);
        if(head==null){
            head=node;
            size++;
            return;
        }
        node.next=head;
        head=node;
        size++;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public boolean search(int key){
        SinglyNode temp=head;
        while(temp!=null){
            if(temp.val==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    

    public void print(){
        if(head==null){
            System.out.println("List is Empty");
        }
        SinglyNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"-> ");
            temp=temp.next;
        }

    }

   

    

   
}
