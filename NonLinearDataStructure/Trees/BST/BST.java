package NonLinearDataStructure.Trees.BST;

import javax.swing.JSpinner.DateEditor;

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


    public void inorder(Node root){
        if(root==null){
            return ;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
