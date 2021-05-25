import java.util.Arrays;

//이항 계수, nCr, 파스칼의 삼각형
public class Binomial_Coefficient {
    static int B[][];
    public static void main(String args[]){
        // System.out.println(bino(7,4));
        int n = 5;
        int r = 3;
        B = new int[n+1][r+1];
        for(int i=0;i<B.length;i++){
            Arrays.fill(B[i], -1);
        }
        // System.out.println(bino(n,r));
        // System.out.println(bino1(n,r));
        System.out.println(bino2(n,r));
    }
    static int bino(int n,int k){
        //재귀 호출을 이용한 이항 계수의 계산
        if(k==0 || n == k)
            return 1;
        else 
            return bino(n-1,k-1) + bino(n-1,k);
    }
        
    static int bino1(int n, int r){
        //중복 호출을 피하기 위하여 메모이제이션을 이용한 이항 계수의 계산
        if(r==0 || n==r)
            return 1;
        if(B[n][r]!=-1)
            return B[n][r];
        B[n][r] = bino1(n-1,r-1) + bino1(n-1,r);
        return B[n][r];
    }

    static int bino2(int n,int k){
        int f[][] = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j == 0 || i==j)
                    f[i][j] = 1;
                else
                    f[i][j] = f[i-1][j-1] + f[i-1][j];
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
        return f[n][k];
    }
}
