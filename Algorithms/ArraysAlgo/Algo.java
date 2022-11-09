package Algorithms.ArraysAlgo;

public class Algo {

    // Kdanes Algo - Maximum sum subArray

    public static void maxSumSubArray(int[] ar){
        int maxSum=0;
        int currSum=0;

        for(int i=0;i<ar.length;i++){
            currSum+=ar[i];
            if(currSum>maxSum){
                maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }

        System.out.print(maxSum);
    }
    
}
