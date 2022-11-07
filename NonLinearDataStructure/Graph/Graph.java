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
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
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

    public static void dfs(ArrayList<Edge>[] graph , int curr, boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            if(!vis[e.des]){
                dfs(graph,e.des,vis);
            }
        }
    }
    
}
