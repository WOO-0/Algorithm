public class Fibonacci{
    static int memo[];
    public static void main(String args[]){
        int n = 7;
        memo = new int[n+1];
        memo[1] = 1;
        System.out.println(function2(n));
    }
    
    static int function(int x){
        //재귀를 이용한 피보나치
        if(x<2)
            return x;
        else{
            return (function(x-1) + function(x-2));
        }
    }
    static int function1(int n){
        // 메모이제이션을 적용한 알고리즘
        if (n >= 2 && memo[n] == 0)
            memo[n] = function1(n-1) + function1(n-2);
        return memo[n];
    }
    static int function2(int n){
        // 동적 계획법을 적용해서 피보나치수를 구하는 알고리즘
        // 재귀 알고리즘 구현에 비해 수행속도 빠름 -> 중복 계산이 없기 때문에
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
