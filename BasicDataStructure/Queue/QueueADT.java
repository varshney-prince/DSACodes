package BasicDataStructure.Queue;

public class QueueADT {

    static final int  MAX=1000;
    int front;
    int rear;
    int[] st = new int[MAX];

    QueueADT(){
        front=rear=0;
    }

     void enqueue(int val){
        if(rear==MAX){
            System.out.println("Queue is full");
            return;
        }
        else {   
            st[rear] = val;   
            rear++;   
        }   
    }

    void queueDequeue()  {   
        // check if queue is empty   
        if (front == rear) {   
            System.out.printf("\nQueue is empty\n");   
            return;   
        }   
     
        // shift elements to the right by one place uptil rear   
        else {   
            for (int i = 0; i < rear - 1; i++) {   
                st[i] = st[i + 1];   
            }   
     
         
      // set queue[rear] to 0  
            if (rear < MAX)   
                st[rear] = 0;   
     
            // decrement rear   
            rear--;   
        }   
        return;   
    }
    
    int peek(){
        return st[front];
    }
    
}
