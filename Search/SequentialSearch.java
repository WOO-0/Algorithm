//순차 검색- 리스트에서 키 값을 찾기 위한 완전 검색 방법
//리스트에 포함된 모든 자료들을 처음부터 하나씩 읽어서 키 값과 비교 하는 방법
public class SequentialSearch{
    public static void main(String args[]){
        int arr[] = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(_SequentialSearch(arr,5));
    }
    static int _SequentialSearch(int A[],int key){
        int i = 0;
        while(A[i] != key){
            i++;
        }
        if(i<A.length)
            return i;
        else 
            return -1;
    }
}