public class Dijkstra {
    
    private static int G[][] = {
        {0, 3, 5, 0, 0, 0},
        {0, 0, 1, 6, 0, 0},
        {0, 1, 0, 3, 6, 0},
        {0, 0, 0, 0, 2, 3},
        {0, 0, 0, 3, 0, 6},
        {0, 0, 0, 0, 0, 0}
    };
    private static int V = G.length;
    public static void main(String args[]){
        /* 
             3        1        3        2
        (1) ---> (2) ---> (3) ---> (4) ---> (5)
                                       \
                                        ---> (6)
                                         3
         */
        function(0);
    }
    // G: 그래프, r: 시작 정점, S: 선택된 정점 집합
    // D: 출발점에서 각 정점까지 최단 경로 가중치 합을 저장
    // P: 최단 경로 트리 저장, ADJ(u): 정점 u의 인접 정점 저장
    public static void function(int r){
        int D[] = new int[V];
        int P[] = new int[V];
        Boolean S[] = new Boolean[V];

        for(int i=0;i<V;i++){
            D[i] = Integer.MAX_VALUE;
            P[i] = -1;
            S[i] = false;
        }
        D[r] = 0;

        for (int count = 0; count < V - 1 ; count++) {
 
            int u = minDistance(D, S);
            S[u] = true;

            for (int v = 0; v < V; v++)
                if (G[u][v] != 0 && S[v] == false && G[u][v] + D[u] < D[v]) {
                    P[v] = u;
                    D[v] = G[u][v] + D[u];
                }
        }
        printDijkstra(D, P);
    }

    static int minDistance(int distance[], Boolean S[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (S[v] == false && distance[v] < min) {
                min = distance[v];
                min_index = v;
            }
        return min_index;
    }

    static void printDijkstra(int D[], int P[]) {
        System.out.print("정점:\t\t   ");
        for (int i = 0; i < V; i++){ 
            System.out.print((i+1) + " ");
        }
        System.out.print("\n거리(D):\t   ");
        for (int i = 0; i < V; i++){ 
            System.out.print(D[i] + " ");
        }
        System.out.println();
        System.out.print("최단 경로 트리(P): N ");
        for (int i = 1; i < V; i++){ 
            System.out.print((P[i]+1) + " ");
        }
    }
}
