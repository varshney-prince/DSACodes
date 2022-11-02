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
}
