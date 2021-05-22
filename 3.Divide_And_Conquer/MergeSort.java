
import java.util.LinkedList;
import java.util.List;

// 여러 개의 정렬된 자료의 집합을 병합하여 한 개의 정렬된 집합으로 만드는 방식
// 분할 정복 알고리즘 활용
//  - 자료를 최소 단위의 문제까지 나눈 후에 차례대로 정렬하여 최종 결과를 얻어냄
//  - top-down 방식
// 시간복잡도 O(logn)
public class MergeSort {
    public static void main(String args[]) {
        int arr[] = { 69, 10, 30, 2, 16, 31, 22 };
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(merge_sort(list));
    }
    // 병합 정렬 구현 시 사용되는 리스트 자료구좨는 배열, 연결 리스트로 구현
    // 배열 사용 : 분리/병합 과정에서 빈번한 자료의 비교 연산과 이동 연산 발생으로 비효율적임
    // 연결리스트 사용 : 배열 사용 시의 단점 극복으로 효과적인 구현 가능

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while (left.size() > i || right.size() > j) {
            if (left.size() > i && right.size() > j) {
                if (left.get(i) < right.get(j)) {
                    result.add(left.get(i));
                    i++;
                } else {
                    result.add(right.get(j));
                    j++;
                }
            } else if (left.size() > i) {
                result.add(left.get(i));
                i++;
            } else if (right.size() > j) {
                result.add(right.get(j));
                j++;
            }
        }
        return result;
    }

    static List<Integer> merge_sort(List<Integer> list) {
        if (list.size() == 1)
            return list;
        List<Integer> left, right;
        int middle = list.size() / 2;
        left = list.subList(0, middle);
        right = list.subList(middle, list.size());
        left = merge_sort(left);
        right = merge_sort(right);

        return merge(left, right);
    }
}
