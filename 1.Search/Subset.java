// 부분 집합 - 최적의 답이 전체 값들의 부분 집합인 알고리즘들이 존재 ex) 배낭(knapsack) 문제, 부분집합의 개수 = 2^n
// 바이너리 카운팅 - 비트표현을 이용해서 부분집합을 생성하는 가장 자연스럽고 간단한 방법
//                - 부분집합을 사전적 순서로 생성할 때도 효과적
public class Subset {
    public static void main(String args[]){
        subset_BC();    
    }
    static void subset_BC(){
        // 바이너리 카운팅을 통한 부분집합 생성 코드
        int arr[] = {3,6,7,1,5,4};
        int n = arr.length-1;
        for(int num = 0; num < (1<<n); num++)
        {
            for(int i=0;i<n;i++){
                if( (num & (1<<i)) != 0){
                    System.out.printf("%d ",arr[i]);
                }
            }
            System.out.printf("\n");
        }
    }
    
}
