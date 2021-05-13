// 4 Queen 문제
public class Queen {
    static boolean chk[][] = new boolean[4][4];

    public static void main(String args[]) {
        function(0);
    }

    static boolean check(int x,int y){
        for (int i = 0 ;i< x ;i++){
            if(chk[i][y]== true)
                return false;
            if (y+(x-i) < 4){
                if(chk[i][y+(x-i)] == true)
                    return false;    
            }
            if(y-(x-i)>=0){
                if(chk[i][y-(x-i)] == true)
                    return false;
            }
        }
        return true;
    }

    static void function(int x) {
        if (x == 4) {
            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    System.out.print(chk[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(check(x,i)){
                chk[x][i]= true;
                function(x+1);
                chk[x][i] = false;
            }
        }
    }
}
