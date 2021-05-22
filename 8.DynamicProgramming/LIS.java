import java.util.Arrays;

public class LIS {
    public static void main(String args[]){
        func1();
    }    
    static void func(){
        int S[] = {3,2,6,4,5,1};
        int lis[] = new int[S.length]; 
        for(int i=0;i<S.length;i++){
            lis[i] = 1;
            for(int j= 0;j<i;j++){
                if(S[j] < S[i] && 1+lis[j]>lis[i])
                    lis[i] = 1+lis[j];
            }
        }

        for(int i=0;i<lis.length;i++){
            System.out.print(lis[i] + " ");
        }
    }
    static void func1(){
        //이진 탐색을 활용한 방법의 알고리즘 동작 과정
        // 시간 복잡도 : O(nlogn)
        int S[] = {8,2,4,3,6,11,7,10,14,5};
        int lis[] = new int[S.length];
        int C[] = new int[S.length];
        Arrays.fill(C,Integer.MAX_VALUE);
        C[0]= -Integer.MAX_VALUE;
        for(int i=0;i<S.length;i++){
            int s = BS(C,0,C.length-1,S[i]);
            C[s] = S[i];
            lis[i] = s;
        }

        for(int i=0;i<lis.length;i++){
            System.out.print(lis[i] + " ");
        }
    }
    static int BS(int A[],int low,int high, int key){
        //이진 탐색
        if (low>high)
            return -1;
        else if (low == high)
            return low;
            
        int mid = (low+high) / 2;
        if(key == A[mid])
            return mid;
        else if(key < A[mid])
            return BS(A,low,mid,key);
        else
            return BS(A,mid+1,high,key);
    }
}
