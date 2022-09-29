interface a{
    void print();
}
interface b{
    void print();
    void display();
}
public class LinkedList  {
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

    public void display(){
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
