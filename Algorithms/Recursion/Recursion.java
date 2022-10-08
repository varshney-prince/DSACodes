package Algorithms.Recursion;

public class Recursion {

    public static int sumOfDigit(int n){
        if(n==0){
            return 0;
        }
        return n%10+sumOfDigit(n/10);
    }
    
}
