
// 이진 검색
// - 자료의 가운데에 있는 항목의 키 값과 비교하여 다음 검색의 위치를 결정하고 검색을 계속 진행하는 방법
// - 자료가 정렬된 상태여야 한다.
// - 목적 키를 찾을 때까지 이진 검색을 순환적으로 반복 수행 -> 검색 범위를 반으로 줄여나가기 때문에 보다 빠르게 검색을 수행
// 반복 구조
// - 자료의 삽입, 삭제 발생 시 배열의 상태를 항상 정렬 상태로 유지하는 추가 작업이 필요

public class BinarySearch {
    public static void main(String args[]){
        int A[] = {2,4,7,9,11,13,19,23};
        int answer = func(A,0,A.length-1,11);
        System.out.println(answer);
    }
    static int func(int A[],int low,int high, int key){
        if (low>high)
            return -1;
        int mid = (low+high) / 2;
        if(key == A[mid])
            return mid;
        else if(key <A[mid])
            return func(A,low,mid,key);
        else
            return func(A,mid+1,high,key);
    }
}
