// 순열 - 서로 다른 것들 중 몇 개를 뽑아서 한 줄로 나열 하는 것
//      - n! -> N개의 요소를 순서대로 나열하는 모든 경우의 수
//      - 다수 문제들이 순서화된 요소들의 집합에서 최선의 경우를 찾는 것 ex) 외판원 문제

public class Permutation {
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6};
        perm(arr,0);
    }

    static void swap(int i,int j,int arr[]){
        int tmp= arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void perm(int arr[],int k){
        if(k==arr.length){
            printArray(arr);
        }
        else{
            for(int i=k;i<arr.length;i++){
                swap(k,i,arr);
                perm(arr,k+1);
                swap(k,i,arr);
            }
        }
    }

    static void Func1(){
        //반복문을 통한 순열 생성
        for(int i1=0;i1<3;i1++){
            for(int i2=0;i2<3;i2++){
                if(i1 != i2){
                    for(int i3=0;i3<3;i3++){
                        if(i3 != i1 && i3 != i2){
                            System.out.printf("%d %d %d\n",i1,i2,i3);
                        }
                    }
                }
            }
        }
    }
}
