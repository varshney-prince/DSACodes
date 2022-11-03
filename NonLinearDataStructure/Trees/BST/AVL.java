package NonLinearDataStructure.Trees.BST;

public class AVL {

    class Node{
        int data , height;
        Node left , right;

        Node(int data){
            this.data=data;
            height=1;
        }
    }

    Node root;

    public int height(Node root){
        if(root==null){
            return 0;
        }

        return root.height;
    }


    int max(int a , int b){
        return (a>b) ? a:b;
    }

    // Left rotate subtree rootted with x

    Node rotateRight(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //Perform rotation
        x.right=y;
        y.left=T2;

        //Updates Height
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;

        //return new root
        return root;

    }

   
   // Left rotate subtree rootted with x

    Node rotateLeft(Node x){
        Node y = x.right;
        Node T2 = y.left;

        //Perform rotation
        y.left=x;
        x.right=T2;

        //Updates Height
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;

        //return new root
        return root;

    }

    //Get Balance factor of node
    int getBalance(Node root){
        if(root==null){
            return 0;
        }

        return height(root.left)-height(root.right);
    }

    public Node insert(Node root , int key){
        if(root==null){
            return new Node(key);
        }

        if(key < root.data){
            root.left=insert(root.left, key);
        }
        else if(key>root.data){
            root.right=insert(root.right, key);
        }
        else{
            return root;
        }

        // update root height
        root.height=1+ Math.max(height(root.left),height(root.right));

        // Get roots balance factor
        int bf=getBalance(root);

        // Left Left Case
        if(bf>1 && key<root.left.data){
            return rotateRight(root);
        }

        // Right Right Case
        if(bf<-1 && key > root.right.data){
            return rotateLeft(root);
        }

        // Left Right Case
        if(bf>1 && key>root.left.data){
            root.left=rotateLeft(root);
            return rotateRight(root);
        }

        // Right Left Case
        if(bf<-1 && key <root.right.data){
            root.right=rotateRight(root);
            return rotateLeft(root);
        }

        return root ; // returned if AVL balanced

        

        
    }


    
}
