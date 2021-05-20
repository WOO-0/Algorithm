
public class Boyer_Moore {
    public static void main(String args[]) {
        String T = "a pattern matching algorithm";
        String P = "rithm";
        int M = P.length();
        char[] skip = new char[M];
        for (int i = 0; i < M; i++)
            skip[i] = P.charAt(M - i - 1);

        int i = M - 1;
        int j = 0;
        while (i < T.length() && j < M) {
            if (T.charAt(i) != skip[j]) {
                for (j = 0; j < M; j++) {
                    if (T.charAt(i) == skip[j]) {
                        break;
                    }
                }
                i += j;
                j = 0;
            } else {
                j += 1;
                i -= 1;
            }
        }
        if (j == M) {
            for (int k = i+1; k < M + (i+1); k++) {
                System.out.print(T.charAt(k));
            }
            System.out.println(" " + (i+1));
        }
    }
}
