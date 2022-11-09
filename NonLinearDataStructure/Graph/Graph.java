package NonLinearDataStructure.Graph;
import java.util.*;
public class Graph {
    static class Edge{
        int src;
        int des;
        int wt;

        public Edge(int s ,int d , int wt){
            this.src=s;
            this.des=d;
            this.wt=wt;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph,boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.println(curr);
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph ){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph , int curr, boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            if(!vis[e.des]){
                dfsUtil(graph,e.des,vis);
            }
        }
    }
        
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;
                }
            }
        }

        return false;

    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph , boolean[] vis,int curr,int parent ){

        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            if(!vis[e.des] && detectCycleUtil(graph, vis, e.des, curr)){
                return true;
            }
            else if(vis[e.des] && e.des!=parent){
                return true;
            }

        }

        return false;

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] col = new int[graph.length];

        for(int i=0;i<col.length;i++){
            col[i]=-1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e =graph[curr].get(j);

                        if(col[e.des]==-1){
                            int nextCol=col[curr]==0?1:0;
                            col[e.des]=nextCol;
                            q.add(e.des);
                        }
                        else if(col[e.des]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }
    
}
