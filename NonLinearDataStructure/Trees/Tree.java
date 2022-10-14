package NonLinearDataStructure.Trees;

import java.util.*;

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
    

    private void displayPreOrder(TreeNode root){
        if(root==null){
            return;
        }

        System.out.println(root.val);
        displayPreOrder(root.left);
        displayPreOrder(root.right);


    }

    private void displayInorder(TreeNode root){
        if(root==null){
            return;
        }

       
        displayInorder(root.left);
        System.out.println(root.val);
        displayInorder(root.right);


    }

    private void displayPostorder(TreeNode root){
        if(root==null){
            return;
        }

       
        displayPostorder(root.left);
        System.out.println(root.val);
        displayPostorder(root.right);


    }


    public void display(){
        displayInorder(root);
    }

    public int size(){
        int s=size( root );
        return s;
    }

    private int size(TreeNode t){
        if(t==null){
            return 0;
        }

        int leftCount=size(t.left);
        int rightCount=size(t.right);
        int totalCount=leftCount+rightCount+1;
        return totalCount;

    }
          
    public int sum(){
        int s=sum(root);
        return s;
    }
    private int sum(TreeNode t){
        if(t==null){
            return 0;
        }

        int leftSum=sum(t.left);
        int rightSum=sum(t.right);
        int totalSum=leftSum+rightSum+t.val;
        return totalSum;


    }

    public int height(){
        int h=height(root);
        return h;
    }

    private int height(TreeNode root2) {
        if(root2==null){
            return -1;
        }

        int leftHeight=height(root2.left);
        int rightHeight=height(root2.right);

        int toalHeight=Math.max(leftHeight, rightHeight)+1;
        return toalHeight;
    }
    
    public int add(int a ,int b){
        return a+b;
    }

    public Tree(){
        this.root = new TreeNode();
    }
}
