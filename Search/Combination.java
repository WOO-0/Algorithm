// 조합 - 서로 다른 n개의 원소 중 r개를 순서 없이 골라낸 것 -> nCr

public class Combination {
    public static void main(String args[]) {
        tr = new int[3];
        comb(an.length, tr.length);
    }

    static int an[] = { 1, 3, 5, 7, 9 }; // n개의 원소를 가지고 있는 배열
    static int tr[]; // r개의 크기의 배열, 조합이 임시 저장될 배열

    static void print_array_t() {
        for (int i = 0; i < tr.length; i++) {
            System.out.printf("%d ", tr[i]);
        }
        System.out.println();
    }

    static void comb(int n, int r) {
        if (r == 0)
            print_array_t();
        else if (n < r)
            return;
        else {
            tr[r - 1] = an[n - 1];
            comb(n - 1, r - 1);
            comb(n - 1, r);
        }
    }
}
