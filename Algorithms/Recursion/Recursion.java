package Algorithms.Recursion;

import java.util.ArrayList;

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

    public static ArrayList<Integer> search(int target ,int index,int[] arr,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }

        if(arr[index]==target){
            list.add(index);
        }
           
         
        return search(target, index+1, arr, list);

    }

    public static ArrayList<Integer> search1(int target ,int index,int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }

        if(arr[index]==target){
            list.add(index);
        }
           
         
        list.addAll(search(target, index+1, arr, list));
        return list;

    }

    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    static ArrayList<String> subseqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRet(p + ch, up.substring(1));
        ArrayList<String> right = subseqRet(p, up.substring(1));

        left.addAll(right);
        return left;
    }
    
}
