
public class PowerSet {
    static int arr[] = {3,6,7,1};
    public static void main(String args[]){
        int bit[] = new int[4];
        function1(bit,4,0);
    }   
    static void print_bit_array(int bit[]){
        for(int i=0;i<arr.length;i++){
            if(bit[i]==1){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    static void function1(int bit[],int n,int k){ // k: 선택한 횟수(현재 노드의 높이), n: 모든 선택수(트리의 높이)
        if (k == n){
            print_bit_array(bit);
        }else{
            bit[k] = 0;
            function1(bit, n, k+1);
            bit[k] = 1;
            function1(bit,n,k+1);
        }

    }

    static void function(int bit,int n, int k){ 
        if(k == n){
            System.out.println(bit);
        }
        else{
            bit = bit << 1;
            function(bit, n, k+1);
            bit = bit+1;
            function(bit, n, k+1);
        }
    } 
}
