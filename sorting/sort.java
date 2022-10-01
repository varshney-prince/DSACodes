package sorting;
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

    static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
             for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }

             }
            }
        
        System.out.println("bubble sort -> "+Arrays.toString(arr));
    }
   
    public static  void mergeSort(int[] arr ,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr,l,m,r);
           
        }


    }
    private static void merge(int[] arr, int l, int m, int r) {
        int n1=m-l+1;
        int n2=r-m;
        
        int[] ar1=new int[n1];
        int[] ar2=new int[n2];

        for(int i=0;i<n1;i++){
           ar1[i]=arr[l+i];
        }

        for(int j=0;j<n2;j++){
            ar2[j]=arr[m+j+1];
        }

        int i=0,j=0;
        int k=l;

        while(i<n1 && j<n2){
            if(ar1[i]<=ar2[j]){
                arr[k]=ar1[i];
                i++;
            }
            else{
                arr[k]=ar2[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=ar1[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=ar1[j];
            j++;
            k++;
        }
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
    
   
    public static void QuickSort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                swap(nums, s, e);
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        QuickSort(nums, low, e);
        QuickSort(nums, s, hi);
    }



    private static void swap(int[] ar, int j,int k) {
        int temp=ar[j];
        ar[j]=ar[k];
        ar[k]=temp;
    }
    
}
