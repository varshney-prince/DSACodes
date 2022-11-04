package NonLinearDataStructure.Trees.BST;
import java.util.*;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    public Node insert(Node root ,int val){
        if(root==null){
            root= new Node(val);
            return root;
        }

        if(root.data>val){
            root.left=insert(root.left, val);
        }
        else{
            root.right=insert(root.right,val);
        }

        return root;
    }

    public boolean search(Node root , int val){
        if(root==null){
            return false;
        }

        if(root.data==val){
            return true;
        }

        if(root.data>val){
            return search(root.left, val);
        }
        else{
            return search(root.right, val);
        }


    }


    public Node delete(Node root ,int key){
        if(root.data<key){
            root.right=delete(root.right, key);
        }
        else if(root.data>key){
            root.left=delete(root.left, key);
        }
        else{
            // Case - 1 leaf node
            if(root.left==null && root.right==null){
                return null;
            }

            // Case - 2 Single child
            if(root.left==null){
                return root.right;
            }
            else if (root.right==null){
                return root.left;
            }

            // Case - 3 both Child

            Node IS = findInOrderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);

        }
        

        return root;

    }

    public void printRootToLeaf(Node root , ArrayList<Integer> path){
             if(root==null){
                return;
             }
             path.add(root.data);
             if(root.left==null && root.right==null){
                printPath(path);
             }

             printRootToLeaf(root.left, path);
             printRootToLeaf(root.right, path);
             path.remove(path.size()-1);
    }

    /*
     * Approch 1 take inorder of tree in arraylist and check if array is sorted or not
     * if arraylist is sorted then BST is valid
     * 
     * Approch 2 code given below
     */

    public boolean isValidBST(Node root,Node min ,Node max){
        if(root==null){
            return true;
        }

        if(min!=null && root.data<=min.data ){
            return false;
        }

        else if(max!=null && root.data>=max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }


    public Node mirror(Node root){
        if(root==null){
            return null;
        }

        Node leftMirror=mirror(root.left);
        Node rightMirror=mirror(root.right);

        root.left=rightMirror;
        root.right=leftMirror;
        return root;
    }


    private void printPath(ArrayList<Integer> path) {
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    private Node findInOrderSuccessor(Node root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public void printInRange(Node root , int k1 , int k2){
        if(root==null){
            return;
        }

        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }


    }

    public void inorder(Node root){
        if(root==null){
            return ;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public Node createBST(ArrayList<Integer> ar ,int start , int end){
        if(start>end){
            return null;
        }

        int mid=(start+end)/2;
        Node root = new Node(ar.get(mid));
        root.right=createBST(ar, mid+1, end);
        root.left=createBST(ar, start, mid-1);
        return root;

    }

    public Node balanceBST(Node root){
        // inorder seq O(n)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);

        // sorted order - balanced BST - O(n)
        root=createBST(inorder, 0, inorder.size()-1);
        return root;

    }

    private void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root==null){
            return ;
        }

        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

    class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST ,int size,int min , int max){
            this.isBST=isBST;
            this.min=min;
            this.size=size;
            this.max=max;
        }

        int maxBST=0;
        public Info largestBST(Node root){
            if(root==null){
                return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }

            Info leftInfo=largestBST(root.left);
            Info rightInfo=largestBST(root.right);
            int size=leftInfo.size+rightInfo.size+1;
            int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

            if(root.data<=leftInfo.max || root.data >=rightInfo.max){
                return new Info(false, size, min, max);
            }

            if(leftInfo.isBST && rightInfo.isBST){
                maxBST=Math.max(maxBST,size);
                new Info(true, size, min, max);
            }

            return new Info(false, size, min, max);

        }
    }
}
