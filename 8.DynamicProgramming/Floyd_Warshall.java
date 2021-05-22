import java.io.*;

public class Floyd_Warshall {
    public static void main(String args[]){
        int D[][] = {
            {0,4,2,5, 100},
            {100,0,1,100,4},
            {1,3,0,1,2},
            {-2,100,100,0,2},
            {100,-3,3,1,0}
        };
        AllPairsShortest(D);
    }
    // D[i][j]L i에서 j로 가는 최단 경로 가중치 합
    // 최초 D[i][j]에는 간선(i,j)의 가중치 저장, i에서 j로 간선이 없으면 무한
    static void AllPairsShortest(int D[][]){
        int n = D.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(D[i][j] + " ");
            System.out.println();
        }
    }
}