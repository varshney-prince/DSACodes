package NonLinearDataStructure.Heap;

import java.util.*;
public class Heap {

    ArrayList<Integer> heap = new ArrayList<>();

    public void add(int val){
        heap.add(val);

        int x=heap.size()-1; // x is child index
        int par=(x-1)/2; // parent index

        while(heap.get(x)<heap.get(par)){
            int temp=heap.get(x);
            heap.set(x,heap.get(par));
            heap.set(par,temp);
        }
    }

    public int peek(){
        return heap.get(0);
    }

    private void heapify(int i){
        int left=2*i+1; // left child
        int right=2*i+2 ;// right child
        int minIndex=i;

        if(left <heap.size() && heap.get(minIndex)>heap.get(left)){
            minIndex=left;
        }

        if(right <heap.size() && heap.get(minIndex)>heap.get(right)){
            minIndex=right;
        }

        if(minIndex!=i){
            int temp=heap.get(i);
            heap.set(i,heap.get(minIndex));
            heap.set(minIndex, temp);

            heapify(minIndex);
        }
    }

    public int remove(){
        int data=heap.get(0);

        // Step 1 -> swap first and last element
        int temp = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.set(heap.size()-1,temp);

        // Step 2 -> delete last
        heap.remove(heap.size()-1);

        // Step 3 -> heapify
        heapify(0);
        
        return data;

    }

    
    
}
