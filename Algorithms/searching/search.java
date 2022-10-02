package Algorithms.searching;

public class search {

    public static int  binarySearch(int[] ar,int val){
        int res=0;
        int l=0;
        int h=ar.length-1;
        

        while(l<=h){
            int m =l+(h-l)/2;        //              0   1    2   3  4   5   6
            if(ar[m]==val){         //int[] ht = { 100, 80, 60, 70, 60, 75, 85 };
                res= m;
                break;
            }
            else if(val>ar[m]){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        return res;

    }
    
}
