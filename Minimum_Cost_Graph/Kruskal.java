import java.util.Arrays;
import java.util.StringTokenizer;

class Graph {
    class Edge implements Comparable<Edge>{
        int src, dest, weight; 
  
        public int compareTo(Edge compareEdge) 
        { 
            return this.weight - compareEdge.weight;
        }
    };
    class Subset{
        int parent, rank;
    }

    int V, E;
    Edge edge[];

    Graph(int _V, int _E) 
    { 
        this.V = _V; 
        this.E = _E; 
        edge = new Edge[E]; 
        for (int i=0; i<E; i++) 
            edge[i] = new Edge(); 
    } 

    int Find_Set(Subset subsets[], int i) 
    { 
        if (subsets[i].parent != i) 
            subsets[i].parent = Find_Set(subsets, subsets[i].parent); 
  
        return subsets[i].parent; 
    } 
  

    void Union(Subset subsets[], int x, int y) 
    { 
        int xroot = Find_Set(subsets, x); 
        int yroot = Find_Set(subsets, y); 
  
        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 
  
        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    }

    void MST_KRUSKAL(){
        Edge result[] = new Edge[V];
        for (int i=0; i<V; ++i) 
            result[i] = new Graph.Edge(); 
  
        // Step 1:  모든 간선들을 가중치 순으로 오름차순 정렬
        Arrays.sort(edge); 

        Subset subsets[] = new Subset[V]; 
        for(int i=0; i<V; ++i) 
            subsets[i]=new Subset(); 

        for (int v = 0; v < V; ++v) 
        { 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 

        int e = 0;
        int i = 0;
        while (e < V - 1) 
        { 
            // Step 2: 가중치가 가장 작은 간선을 선택
            Edge next_edge = new Edge(); 
            next_edge = edge[i++]; 
  
            int x = Find_Set(subsets, next_edge.src); 
            int y = Find_Set(subsets, next_edge.dest); 
  
            // 같은 집합에 포함되어 있지 않다면 집합에 포함시킴
            if (x != y) 
            { 
                result[e++] = next_edge; 
                Union(subsets, x, y); 
            } 
        } 
  
        System.out.println("Following are the edges in " +  
                                     "the constructed MST"); 
        for (i = 0; i < e; ++i) 
            System.out.println(result[i].src+" -- " +  
                   result[i].dest+" == " + result[i].weight); 
    } 
}

public class Kruskal{
    public static void main(String args[]){
    /*
        (0)------51------(6)
         | \  \          / |
         | 32   31      25 |
         |   \     \  /    |
         |  (1)-21-(2)     |
         |            \    |
         |     (3)     \   |
         |    /    \   46  |
         |  18      34   \ |
         | /           \  \|
        (5)------40------(4)
    */
    /*
            (1)  
           / | \______    
          /  |  \      \  
         /   |   \      \ 
       (0)  (2)  (6)    (3)
                        / \
                       /   \
                     (5)   (4)
        
    */
        int V = 7;  // 정점의 수 
        int E = 11;   // 간선의 수 
        Graph graph = new Graph(V, E); 
        String str = 
        "0 32 31 -1 -1 60 51 " +
        "32 0 21 -1 -1 -1 -1 " +
        "31 21 0 -1 46 -1 25 " +
        "-1 -1 -1 0 34 18 -1 " +
        "-1 -1 46 34 0 40 51 " +
        "60 -1 -1 18 40 0 -1 " +
        "51 -1 25 -1 51 -1 0 ";
        StringTokenizer st = new StringTokenizer(str, " ");
        int cnt = 0;
        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input != -1 && i<j){
                    graph.edge[cnt].src = i;
                    graph.edge[cnt].dest = j;
                    graph.edge[cnt].weight = input;
                    cnt+=1;
                }
            }
        }
  
        graph.MST_KRUSKAL(); 
    }
   
}