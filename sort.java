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

    private static void swap(int[] ar, int j,int k) {
        int temp=ar[j];
        ar[j]=ar[k];
        ar[k]=temp;
    }
    
}
