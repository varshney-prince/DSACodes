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
    
    public void levelOrderTraversal(){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
 
            
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");
 
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

     /*
     * Algorithm: delete node in binary tree
     * 
     * Starting at the root, find the deepest and rightmost node in the binary tree
     * and the node which we want to delete.
     * Replace the deepest rightmost node’s data with the node to be deleted.
     * Then delete the deepest rightmost node.
     */
     public void deleteDeepest(TreeNode root,
             TreeNode delNode) {
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         q.add(root);

         TreeNode temp = null;

         // Do level order traversal until last node
         while (!q.isEmpty()) {
             temp = q.peek();
             q.remove();

             if (temp == delNode) {
                 temp = null;
                 return;

             }
             if (temp.right != null) {
                 if (temp.right == delNode) {
                     temp.right = null;
                     return;
                 } else
                     q.add(temp.right);
             }

             if (temp.left != null) {
                 if (temp.left == delNode) {
                     temp.left = null;
                     return;
                 } else
                     q.add(temp.left);
             }
         }
     }
 
// Function to delete given element
// in binary tree
public void delete(TreeNode root, int key) {
    if (root == null)
        return;

    if (root.left == null &&
            root.right == null) {
        if (root.val == key) {
            root = null;
            return;
        } else
            return;
    }

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    TreeNode temp = null, keyNode = null;

    // Do level order traversal until
    // we find key and last node.
    while (!q.isEmpty()) {
        temp = q.peek();
        q.remove();

        if (temp.val == key)
            keyNode = temp;

        if (temp.left != null)
            q.add(temp.left);

        if (temp.right != null)
            q.add(temp.right);
    }

    if (keyNode != null) {
        int x = temp.val;
        deleteDeepest(root, temp);
        keyNode.val = x;
    }
}
 

    public Tree(){
        this.root = new TreeNode();
    }
}
