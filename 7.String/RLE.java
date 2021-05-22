public class RLE {
    public static void main(String args[]){
        RLEncoding("AABBBBBBBCCC");
        char output[][] = {{'A','B','C'},{'2','7','3'}}; //A2 B7 C3
        RLDecoding(output);
    }

    private static int MAXCOUNT = 255;
    static void RLEncoding(String input){
        int count = 0;
        char prev = input.charAt(0);
        char curr = '\0';
        int tmp=0;
        while(count<input.length()){
            curr = input.charAt(count);
            if(prev == curr && count < MAXCOUNT){
                count = count + 1;
            }
            else{
                System.out.println(prev+" "+(count-tmp));
                tmp = count;
            }
            prev = curr;
        }
        System.out.println(curr + " " +(count-tmp));
    }

    static void RLDecoding(char[][] input){
        char curr;
        int count = 0;
        int i = 0;
        while(i < input[0].length){
            curr = input[0][i];
            count = input[1][i]-48;
            while(count >0){
                System.out.print(curr);
                count = count-1;
            }
            i++;
        }
    }
}
