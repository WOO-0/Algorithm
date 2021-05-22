import java.util.Stack;

public class DFS {
    static int G[][] = 
        {{0,1,1,0,1,0,0,0},
        {1,0,0,1,1,1,0,0},
        {1,0,0,0,1,0,0,0},
        {0,1,0,0,0,1,0,0},
        {1,1,1,0,0,0,1,0},
        {0,1,0,1,0,0,1,1},
        {0,0,0,0,1,1,0,1},
        {0,0,0,0,0,1,1,0}};
    static boolean visited[] = new boolean[G[0].length];
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String args[]){
        // DFS_Recursive(0);
        DFS_Iterative(0);
    }
    // 입력> G: 그래프, v: 시작 정점
    // visited[]: 정점의 방문 정보 표시, FALSE로 초기화
    // ADJ(G,v): 그래프 G에서 v의 인접정점 집합
    static void DFS_Recursive(int v){
        System.out.println(v+1);
        visited[v] = true;
        for (int i=0;i<G.length;i++){
            if(G[v][i]==1 && visited[i]== false){
                DFS_Recursive(i);
            }
        }
    }
    static void DFS_Iterative(int v){
        stack.push(v);

        while(!stack.isEmpty()){
            if(visited[v] == false){
                System.out.println(v+1);
                visited[v] = true;
            }else{
                v = stack.pop();
            }
            for(int i = 0; i<G.length;i++){
                if(G[v][i] == 1 && visited[i] == false){
                    stack.push(i);
                    v=i;
                    break;
                }
            }
        }
    }

}
