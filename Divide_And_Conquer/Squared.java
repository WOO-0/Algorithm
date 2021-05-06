//거듭 제곱

public class Squared {
    public static void main(String args[]) {
        int result = Interactive_Power(2, 10);
        System.out.println(result);
    }

    static int Interactive_Power(int x, int n) {
        // 반복문을 사용한 거듭 제곱
        // 총 n번의 곱셈이 사용되어 수행시간이 O(n)
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * x;
        }
        return result;
    }

    static int Recursive_Power(int x, int n) {
        // 분할 정복 기반의 거듭 제곱
        // 시간 복잡도를 O(log2n) 으로 줄일 수 있음
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            int y = Recursive_Power(x, n / 2);
            return y * y;
        } else {
            int y = Recursive_Power(x, (n - 1) / 2);
            return y * y * x;
        }
    }
}
