package NonLinearDataStructure.Trees;

import java.util.*;

public class Tree {

    static class Info{
        int diameter;
        int height;
        public Info(int dia ,int ht){
            this.diameter=dia;
            this.height=ht;
        }
    }

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

 public Info diameter(TreeNode root){
    if(root==null){
        return new Info(0, 0);
    }

    Info leftInfo=diameter(root.left);
    Info righInfo=diameter(root.right);
    int selfDia=leftInfo.height+righInfo.height+1;

    int dia=Math.max(Math.max(leftInfo.diameter,righInfo.diameter),selfDia);
    int ht = Math.max(leftInfo.height,righInfo.height)+1;

    return new Info(dia, ht);

 }

 public boolean isSubTree(TreeNode root,TreeNode subRoot){

    if(root == null){
        return false;
    }

    if(root.val==subRoot.val){
        if(isIdentical(root,subRoot)){
            return true;
        }
    }

    return isSubTree(root.left,subRoot) || isSubTree(root.right, subRoot);
 }
 

    private boolean isIdentical(TreeNode root2, TreeNode subRoot) {
        if(root2==null && subRoot==null){
            return true;
        }
        else if(root2==null || subRoot==null || root2.val!=subRoot.val){
            return false;
        }

        if(!isIdentical(root2.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(root2.right, subRoot.right)){
            return false;
        }
        return true;
    }

    class Top{
        TreeNode node;
        int hd;
        public Top(TreeNode node ,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public void topView(TreeNode root){

        Queue<Top> q =new LinkedList();

        HashMap<Integer , TreeNode> map = new HashMap<>();

        int min=0 , max=0;
        q.add(new Top(root,0));

        while(!q.isEmpty()){
            Top curr =q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }

            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node);
            }

            if(curr.node.left!=null){
                q.add(new Top(curr.node.left, curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }

            if(curr.node.right!=null){
                q.add(new Top(curr.node.right, curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }
        }

        for(int i=min ;i<=max;i++){
            System.out.print(map.get(i).val+" ");
        }

        System.out.println();        
    }

public static void Klevel(TreeNode root , int level ,int k){
    if(root==null){
        return;
    }

    if(level==k){
        System.out.print(root.val + " ");
        return;
    }

    Klevel(root.left, level+1, k);
    Klevel(root.right, level+1, k);
}

public TreeNode lca(TreeNode lca ,int n1,int n2){
    ArrayList<TreeNode> path1 = new ArrayList<>();
    ArrayList<TreeNode> path2 = new ArrayList<>();

    getPath(root,n1,path1);
    getPath(root,n2,path2);

    int i=0;

    for(;i<path1.size() && i<path2.size();i++){
        if(path1.get(i)!=path2.get(i)){
            break;
        }
    }

    TreeNode lca1=path1.get(i-1);
    return lca1;

}

    public boolean getPath(TreeNode root2, int n1, ArrayList<TreeNode> path1) {
        if(root==null){
            return false;
        }

        path1.add(root2);

        boolean foundLeft=getPath(root2.left, n1, path1);
        boolean foundRight=getPath(root2.right, n1, path1);

        if(foundLeft || foundRight){
            return true;
        }
        path1.remove(path1.size()-1);
        return false;
}

public int minDist(TreeNode root ,int n1 ,int n2){
    TreeNode lca = lca(root, n1, n2);
    int dis1=lcaDis(lca,n1);
    int dis2=lcaDis(lca,n2);

    return dis1+dis2;
}

    private int lcaDis(TreeNode lca, int n1) {
        if(root==null){
            return -1;
        }

        if(root.val==n1){
            return 0;
        }

        int leftDis=lcaDis(lca.left, n1);
        int rightDis=lcaDis(lca.right, n1);

        if(leftDis==-1 && rightDis==-1){
            return -1;
        }
        else if(leftDis==-1){
            return rightDis+1;
        }
        else{
            return leftDis+1;
        }

    }

    public int KAncestor(TreeNode root , int n ,int k){
        if(root==null){
            return -1;
        }

        if(root.val==n){
            return 0;
        }

        int leftDis=KAncestor(root.left, n, k);
        int rightDis=KAncestor(root.right, n, k);

        if(leftDis==-1 && rightDis==-1){
            return -1;
        }

        int max=Math.max(leftDis,rightDis);

        if(max+1==k){
            System.out.println(root.val);
        }

        return max+1;
    }

    public int sumTree(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftChild=sumTree(root.left);
        int rightChild=sumTree(root.right);

        int data=root.val;
        root.val=leftChild+rightChild+root.left.val+root.right.val;
        return data;
    }

    public Tree(){
        this.root = new TreeNode();
    }
}
