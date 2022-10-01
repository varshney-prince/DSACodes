package BasicDataStructure.List;public class LinkedListADT  {

  
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
