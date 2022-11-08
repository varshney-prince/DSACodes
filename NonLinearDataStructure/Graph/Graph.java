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
    
}
