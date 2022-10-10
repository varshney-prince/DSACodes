import java.util.ArrayList;

import Algorithms.Recursion.Recursion;
import BasicDataStructure.List.LinkedListADT;

public class Main {
    public static void main(String[] args) {
        //LinkedListADT list = new LinkedListADT();
       // list.addLast(1);
        //list.delete(1);
        //list.print();
        int[] ar = {1,2,3,4,4,5,6};
        ArrayList<Integer> list = new ArrayList<>();
         System.out.println(Recursion.search(4, 0, ar, list));       
       
    }
    
}
