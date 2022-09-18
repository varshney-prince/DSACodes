public class LinkedList {
    Node head;

    void insert(int val){
        if(head==null){
            head=new Node(val);
        }
        Node temp =head;
        while(temp!=null){
         temp=temp.next;
        }
        Node n = new Node(val);
        n.next=null;
        temp.next=n;

    }

    void display(){
        if(head==null){
            System.out.println("List is empty");
        }

        Node temp=head;

        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
           }
    }
}
