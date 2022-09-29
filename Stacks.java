import java.util.*;
public class Stacks {
	static void formMinNum(String str){
		
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i <= str.length(); i++) {
			
			st.push(i + 1);
			
			if(i == str.length() || str.charAt(i) == 'I') {
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		
	}
	
}

 static void nge(int[] ht) {
	int[] nge=new int[ht.length];
	Stack<Integer> st = new Stack<>();
    st.push(0);
	for(int i=1;i<ht.length;i++){
		while(!st.isEmpty() && ht[st.peek()]<ht[i]){
			System.out.println("nge of "+ ht[st.peek()] +" is "+ht[i]); 
			nge[st.pop()]=ht[i];

		}
		st.push(i);
	}

	while(!st.isEmpty()){
		System.out.println("nge of "+ ht[st.pop()] +" is -1"); 
	}
}

static void nse(int[] ht) {
	int[] nge=new int[ht.length];
	Stack<Integer> st = new Stack<>();
    st.push(0);
	for(int i=1;i<ht.length;i++){
		while(!st.isEmpty() && ht[st.peek()]>ht[i]){
			System.out.println("nge of "+ ht[st.peek()] +" is "+ht[i]); 
			nge[st.pop()]=ht[i];

		}
		st.push(i);
	}

	while(!st.isEmpty()){
		System.out.println("nge of "+ ht[st.pop()] +" is -1"); 
	}
}
    
	public static void main(String[] args) {
		String str = "IDIIIIDD";
		//formMinNum(str);

		
		int[] ht = { 100, 80, 60, 70, 60, 75, 85 };
		//pge(ht);
		pse(ht);
		//Next greater element
		//nse(ht);
       
		}

	private static void pse(int[] ht) {
		int[] pse = new int[ht.length];
		pse[0]=-1;
		Stack<Integer> st = new Stack<>();
		st.push(0);

		for(int i=1;i<ht.length;i++){
			while(!st.isEmpty() && ht[st.peek()]>=ht[i]){
				st.pop();
			}

			if(!st.isEmpty()){
				pse[i]=ht[st.peek()];
			}
			else{
				pse[i]=-1;
			}
			st.push(i);
		}
		System.out.print(Arrays.toString(pse));
	}

	private static void pge(int[] ht) {
		int[] pge = new int[ht.length];
		pge[0]=-1;
		Stack<Integer> st = new Stack<>();
		st.push(0);

		for(int i=1;i<ht.length;i++){
			while(!st.isEmpty() && ht[st.peek()]<=ht[i]){
				st.pop();
			}

			if(!st.isEmpty()){
				pge[i]=ht[st.peek()];
			}
			else{
				pge[i]=-1;
			}
			st.push(i);
		}
		System.out.print(Arrays.toString(pge));
	}

	
    }
    
