package NonLinearDataStructure.Trees;

import java.util.Scanner;

public class Tree {
    TreeNode root;

    public void createTree(){
        
        createTree(root);
    }

    public TreeNode createTree(TreeNode temp){
        Scanner sc = new Scanner(System.in);
        int rootData=sc.nextInt();
        temp.val=rootData;
        if(rootData==-1){
            return null;
        }

        temp.left=createTree(new TreeNode());
        temp.right=createTree(new TreeNode());
        return temp;
    }
    

    public void display(TreeNode root){
        if(root==null){
            return;
        }

        System.out.println(root.val);
        display(root.left);
        display(root.right);


    }

    public void display(){
        display(root);
    }

    public Tree(){
        this.root = new TreeNode();
    }
}
