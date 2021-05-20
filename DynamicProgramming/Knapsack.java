public class Knapsack {
    private static int weight[] = {5,4,6,3};
    private static int value[] = {10,40,30,50};
    private static int NUM_OF_ITEM = weight.length;
    static int maxValue = 0;
    public static void main(String args[]){
        System.out.println(function1(10,0,0));
    }

    static void function(int W, int k, int curValue){
        //배낭 문제 완전 검색 알고리즘
        if(W >= 0){
            if(k == NUM_OF_ITEM){
                System.out.println(W+" "+curValue);
                if(maxValue <= curValue)
                    maxValue = curValue;

            } else{
                function(W-weight[k], k+1, curValue + value[k]);
                function(W, k+1, curValue);
            }
        }
    }
    
    static int function1(int W, int k,int curValue){
        // 동적 계획법을 적용한 상향식 최적해 산출 알고리즘
        int K[][] = new int[weight.length+1][W+1];
        for(int i=1;i<=weight.length;i++){
            for(int w=1;w<=W;w++){
                if(weight[i-1]>w)
                    K[i][w] = K[i-1][w];
                else
                    K[i][w] = Math.max(K[i-1][w-weight[i-1]]+value[i-1], K[i-1][w]);
            }
        }
        for(int i=0;i<=weight.length;i++){
            for(int j=0;j<=W;j++){
                System.out.print(K[i][j] + " ");
            }
            System.out.println();
        }
        return K[weight.length][W];
    }
}
