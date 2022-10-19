package NonLinearDataStructure.Trees.EasyQuestions;

public class Easy {
    
    public static int fib(int n ){
        if(n<2){
            return n ;
        }
        int a= fib(n-1)+fib(n-2);
    
        return a;
        
    }

    public static int hcf(int a,int b ){
        int hcf=0;
        int min=Math.min(a,b);
        
        for(int i = min; i>0; i--) {
         if( a%i == 0 && b%i == 0 ){
            hcf = i;
            break;
         }
      }
      
      return hcf;
        
    }

    public static int lcm(int a,int b){
        int pro=a*b;
        int hcf=hcf(a, b);
        int lcm=pro/hcf;
        return lcm;
    }
}
