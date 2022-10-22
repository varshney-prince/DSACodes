package NonLinearDataStructure.Tries;

public class Tries {

    private class Node{
        Node[] children = new Node[26];
        boolean eow=false;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    Node root = new Node();

    public void insert(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }

            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public boolean search(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }

            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    
}
