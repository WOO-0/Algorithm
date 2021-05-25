public class Coin {
    private static int coin[] ={6,4,1};
    static int memo[];
    public static void main(String args[]){
        // 사용할수 있는 동전 : 1원, 4원, 6원
        // 거스름돈 8원에 대한 최소 동전 개수?
        // 그리디 방법 : 6원, 1원, 1원
        // 최적해 : 4원, 4원
        memo = new int[8+1];
        for(int i=0;i<memo.length;i++){
            memo[i] = -1;
        }
        System.out.println(function1(8));
    }
    static int function(int money){
        // 재귀 알고리즘에 메모이제이션 적용
        int min = Integer.MAX_VALUE;
        if(memo[money] != -1){
            return memo[money];
        }
        if(money == 0){
            return 0;
        }
        else{
            for(int i=0;i<coin.length; i++){
                if(money - coin[i] >= 0){
                    int ret = function(money - coin[i]);
                    if(ret < min){
                        min = ret;
                    }
                }
            }
        }
        memo[money] = min + 1;
        return memo[money];
    }

    static int function1(int money){
        //동적 계획법을 이용
        int f[] = new int[money+1];
        f[0] = 0;
        for (int i=1;i<=money;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<coin.length;j++){
                if(i >= coin[j]){
                    if(f[i-coin[j]] < min)
                        min= f[i - coin[j]];
                }
            }
            f[i] = min +1;
        }
        for(int i=0;i<f.length;i++){
            System.out.print(f[i] + " ");
        }
        System.out.println();
        return f[money];
    }
}
