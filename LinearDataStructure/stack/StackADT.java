package LinearDataStructure.stack;

public class StackADT {
    static final int  MAX=1000;
    int top;
    int[] st = new int[MAX];

     StackADT(){
        top=-1;
     }

     boolean isEmpty(){
        return top<0;
     }

     public void push(int val){
        if(top>=MAX){
         System.out.println("Stack Overflow");
         return;
        }
        st[++top]=val;
     }

     public int pop(){
      if(top<0){
       System.out.println("Stack Underflow");
       return -1;
      }
         int x = st[top--];
         return x;
   }

   public int peek()
   {
       if (top < 0) {
           System.out.println("Stack Underflow");
           return 0;
       }
       else {
           int x = st[top];
           return x;
       }
   }



    
}
