import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int G[][] = 
    {{0,1,1,0,1,0,0,0},
    {1,0,0,1,1,1,0,0},
    {1,0,0,0,1,0,0,0},
    {0,1,0,0,0,1,0,0},
    {1,1,1,0,0,0,1,0},
    {0,1,0,1,0,0,1,0},
    {0,0,0,0,1,1,0,1},
    {0,0,0,0,0,0,1,0}};
    static Queue<Integer> queue = new LinkedList<Integer>();
    static boolean visited[] = new boolean[G[0].length];
    static int D[] = new int[G[0].length];
    static int P[] = new int[G[0].length];
    public static void main(String args[]){

        function(0);
        System.out.print("정점:    ");
        for(int i=0;i<G[0].length;i++)
            System.out.print((i+1)+" ");
        System.out.println();
        
        System.out.print("거리(D): ");
        for(int i=0;i<G[0].length;i++)
            System.out.print(D[i]+" ");
        System.out.println();
        
        System.out.print("경로(P): ");
        for(int i=0;i<G[0].length;i++)
            System.out.print((P[i]+1)+" ");    
    }
    static void function(int v){
        // 임의 정점 방문 시 시작 정점에서의 최단 경로 확인 가능
        // D[]: 최단 거리, P[]: 최단 경로
        D[v] = 0; P[v] = v;
        queue.add(v);
        visited[v] = true;
        while(!queue.isEmpty()){
            v = queue.poll();
            for(int w=0;w<G.length;w++){
                if(G[v][w]==1 && visited[w] == false){
                    queue.add(w);
                    visited[w] = true;
                    D[w] = D[v]+1;
                    P[w] = v;
                }
            }
        }
    }
}
