import java.util.Arrays;

public class sort {

    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
             int last=arr.length-i-1;
             int maxIndex=find(arr,0,last);
             swap(arr, last, maxIndex);
            }
        
        System.out.println(Arrays.toString(arr));
    }
   
    private static int find(int[] arr, int i, int last) {
        int Max=i;
        for(int j=i;j<=last;j++){
            if(arr[j]>arr[Max]){
                Max=j;
            }
        }
        return Max;
    }
    


    private static void swap(int[] ar, int j,int k) {
        int temp=ar[j];
        ar[j]=ar[k];
        ar[k]=temp;
    }
    
}
