import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 알고리즘 15591번 문제 MooTube(Silver)
// 그래프 이론, 그래프 탐색
public class B_15591 {
    static int N,Q,k[],v[];
    static boolean visit[];
    static List<Node> []G;
    static class Node{
        int dest;
        int value;
        Node(int _dest, int _value){
            this.dest = _dest;
            this.value = _value;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // (1<= N <= 5000)
        Q = Integer.parseInt(st.nextToken());
        G = new ArrayList[N];

        for(int i=0;i<N;i++){
            G[i] = new ArrayList<Node>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken())-1;
            int dest = Integer.parseInt(st.nextToken()) -1;
            int value = Integer.parseInt(st.nextToken());
            G[src].add(new Node(dest,value));
            G[dest].add(new Node(src,value));
        }

        k = new int[Q];   //
        v = new int[Q];   // K=ki라면 동영상 vi를 보고 있는 소들에게 몇 개의 동영상이 추천될 지 묻는것??
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            k[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            visit = new boolean[N];
            System.out.println(search(v[i]-1,k[i]) - 1);
        }
        
    }

    static int search(int node, int k){
        int answer = 1;
        visit[node] = true;
        for(int i=0;i<G[node].size();i++){
            if(visit[G[node].get(i).dest] == false && G[node].get(i).value>=k)
                answer += search(G[node].get(i).dest,k);
        }
        return answer;
    }
}
