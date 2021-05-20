// KMP 알고리즘
public class KMP {

    public static void main(String args[]){
        String T =  "sadhasdgsdagdasgsadgabcdabcefasdgdsgasdgdsagdasg";
        String P =  "abcdabcef";
        int next[] = new int[P.length()];
        KMP_Preprocess(P, next);

        int result = KMP_Search(T, P, next);
        for(int i= result;i < P.length() + result;i++){
            System.out.print(T.charAt(i));
        }
    }

    //KMP 탐색을 하기 위한 전처리 과정
    static void KMP_Preprocess(String P, int next[]){
        // p[]: 패턴, M: 패턴의 길이
        // next[]: 불일치가 발생하면 이동할 위치를 저장
        int i = 0, j= -1;
        next[i] = -1;
        while(i<P.length()-1){
            while(j>= 0 && P.charAt(i) != P.charAt(j))
                j = next[j];
            i = i+1;
            j = j+1;
            next[i] = j;
        }
    }

    static int KMP_Search(String T, String P, int next[]){
        int i = 0, j = 0;
        while (i < T.length()){
            while(j>=0 && T.charAt(i) != P.charAt(j))
                j=next[j];
            i = i+1;
            j = j+1;
            if(j==P.length()){
                return i-j;
            }
        }
        return -1;
    }
}
