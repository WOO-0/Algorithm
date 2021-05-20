// 고지식한 패턴 검색 알고리즘
public class BruteForce_String {
    public static void main(String args[]){
        String text = "GCGTATAACGCTAGT";
        String pattern = "GCTAG";
        int M=pattern.length(), N = text.length();
        int i=0,j=0;
        while(j<M && i<N){
            if(text.charAt(i) != pattern.charAt(j)){
                i = i-j;
                j = -1;
            }
            i = i+1;
            j = j+1;
        }
        if (j==M){
            // 패턴을 찾은 경우
            System.out.println(i-M);
        }
        else{
            //패턴을 찾지 못한 경우
            System.out.println(i);
        }
    }
}
