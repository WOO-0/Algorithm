import java.util.Arrays;

// 동전 거스름돈 문제

public class Coin {
    static int coin[] = {500,400,100,50, 10};
    static int best = Integer.MAX_VALUE;
    public static void main(String args[]){
        int choices[] = new int[10];
        coinChange(choices,0,800);
    }
    // coins[] : 동전의 금액을 저장, choices[]: 선택한 동전들 집합
    // best - 거스름돈에 대한 최소 동전 개수
   // N: 현재 방문 노드의 높이, money: 거스름돈 금액
    static void coinChange(int choices[], int N, int money){
        int newChoices[] = Arrays.copyOf(choices, choices.length);
        if(best<=N)
            return;
        if(money == 0){
            if(best > N){
                best = N;
            }
            for(int i=0;i<newChoices.length;i++){
                System.out.print(newChoices[i] + " ");
            }
            System.out.println();
        }else{
            for (int i=0; i<coin.length; i++){
                if(money - coin[i] >= 0){
                    newChoices[N] = coin[i];
                    coinChange(newChoices, N+1, money - coin[i]);
                }
            }
        }
    }
}
