
// A Java program for Prim's Minimum Spanning Tree (MST) algorithm. 
// The program is for adjacency matrix representation of the graph 

public class Prim {
    // private static int graph[][] = new int[][] { 
    //     { 0, 11, 100, 17, 100,100,100,100,100,100 },
    //     { 11, 0, 100, 100, 45,100,100, 100, 100, 100 },
    //     { 100, 100, 0, 18, 100, 100, 5, 100, 100, 100 },
    //     { 17, 100, 18, 0, 8, 100, 100, 3, 100, 100 },
    //     { 100, 45, 100, 8, 0, 9, 100, 100, 7, 100 },
    //     { 100, 100, 100, 100, 9, 0, 100, 100, 100, 6 }, 
    //     { 100, 100, 5, 100, 100, 100, 0, 59, 100, 100 },
    //     { 100, 100, 100, 3, 100, 100, 59, 0, 4, 100 },
    //     { 100, 100, 100, 100, 7, 100, 100, 4, 0, 12 },
    //     { 100, 100, 100, 100, 100, 6, 100, 100, 12, 0 },
    //     };
    
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
    private static int graph[][] = new int[][] {
        {0, 32, 31, 10000, 10000, 60, 51},
        {32, 0, 21, 10000, 10000, 10000, 10000},
        {31, 21, 0, 10000, 46, 10000, 25},
        {10000, 10000, 10000, 0, 34, 18, 10000},
        {10000, 10000, 46, 34, 0, 40, 51},
        {60, 10000, 10000, 18, 40, 0, 10000},
        {51, 10000, 25, 10000, 51, 10000, 0}
    };
    private static final int V = graph.length;
    static int minDistance(int distance[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && distance[v] < min) {
                min = distance[v];
                min_index = v;
            }
        return min_index;
    }

    static void printMST(int nearest[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(i + " - " +nearest[i] + "\t" + graph[i][nearest[i]]);
    }

    static void MST_PRIM(int r) { // G:그래프, r:시작점
        int nearest[] = new int[V];         // 정점이 트리에 연결될 때 사용된 간선 정보 저장
        int distance[] = new int[V];        // 파이에 저장된 간선의 가중치 저장
        Boolean mstSet[] = new Boolean[V];  

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        distance[r] = 0;    // 키 값을 0으로 초기화
        nearest[r] = -1;

        for (int count = 0; count < V - 1; count++) {
 
            int u = minDistance(distance, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < distance[v]) {
                    nearest[v] = u;
                    distance[v] = graph[u][v];
                }
        }

        System.out.println();
        for (int i = 0; i < V; i++)
            System.out.print(nearest[i] + " ");
        System.out.println();
        printMST(nearest, graph);
    }

    public static void main(String[] args) {
        /*
         * Let us create the following graph
         *     (0)
         *      |
         *     (2)
         *   /  |  \
         * (1) (4) (6)
         *      |
         *     (3)
         *      |
         *     (5)
         */

        MST_PRIM(0);
    }
}