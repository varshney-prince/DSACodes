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
    
	public static void main(String[] args) {
		String str = "IDIIIIDD";
		formMinNum(str);
       
		}
    }
    
