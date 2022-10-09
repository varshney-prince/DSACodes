package Algorithms.Recursion;

public class Recursion {

    public static int sumOfDigit(int n){
        if(n==0){
            return 0;
        }
        return n%10+sumOfDigit(n/10);
    }

    public static int productOfDigit(int n){
        if(n==0){
            return 1;
        }
        return n%10*productOfDigit(n/10);
    }

    public static int reverse(int n){
        if(n==0){
            return 0;
        }
        return n%10+reverse(n/10)*10;
    }
    public static void sortArray(int[] arr,int i){
        if(i==arr.length-1){
            return;
        }
        int minIndex=i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[minIndex]){
                minIndex=j;
            }
        }
        int temp=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=temp;
        sortArray(arr, i+1);
    }
    
}
