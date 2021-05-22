//퀵 정렬 - 주어진 배열을 두 개로 분할하고, 각각을 정렬
// - 분할 시 기준 아이템(pivot item) 중심으로 이보다 작은 것은 왼편, 큰 것은 오른편에 위치시킴
// - 분할 과정에서 선택된 피봇들이 자기 자리를 찾음 -> 매 분할 과정에서 어느 정도 정렬이 이루어짐
// - 부분 정렬 후 병합 불 필요
// 피봇이 최소값이나 최대값이 선택 될 경우 O(n^2)의 정렬 알고리즘과 차이가 없어짐 -> 분할할 자료의 중간값에 까가운 값일 수록 좋다
public class QuickSort {
    public static void main(String args[]) {
        int arr[] = { 10, 20, 5, 8, 2, 4, 13, 6, 1 };
        func(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void func(int A[], int l, int r) {
        if (l < r) {
            int s = partition2(A, l, r);
            func(A, l, s - 1);
            func(A, s + 1, r);
        }
    }

    static int partition(int A[], int l, int r) {
        // Hore-Partition 알고리즘
        int p = A[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (A[i] <= p)
                i++;
            while (A[j] > p)
                j--;
            if (i < j)
                swap(i, j, A);
        }
        swap(l, j, A);
        return j;
    }

    static int partition2(int A[], int l, int r) {
        // Lomuto partition 알고리즘
        int x = A[r];
        int i = l;
        for (int j = i; j < r; j++) {
            if (A[j] <= x) {
                swap(i, j, A);
                i++;
            }
        }
        swap(i, r, A);
        return i;
    }

    static void swap(int x, int y, int A[]) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
}