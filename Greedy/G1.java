// 동전 거스름돈 문제
public class G1 {
    static int arr[] = { 500, 100, 50, 10 };

    public static void main(String args[]) {
        g1(800);
    }

    static void g1(int money) {
        for (int i = 0; i < arr.length; i++) {
            if (money - arr[i] < 0) {
                continue;
            } else {
                System.out.println(arr[i]);
                money = money - arr[i];
                i -= 1;
            }
        }
    }
}
