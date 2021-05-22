public class Permutation {
    public static void main(String args[]){
        int arr[] = new int[4];
        function(arr, 0,arr.length);
    }
    static void print_array(int order[]){
        for(int i=0;i<order.length;i++){
            System.out.print(order[i] + " ");
        }
        System.out.println();
    }
    static void function(int order[], int k,int n){
        if (k == n){
            print_array(order);
        }else{
            boolean check[] = new boolean[n];
            for(int i=0;i<k;i++){
                check[order[i]] = true;
            }
            for(int i=0;i<n;i++){
                if(check[i] == false){
                    order[k] = i;
                    function(order,k+1,n);
                }
            }
        }
    }
}   
