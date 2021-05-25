//작업 스케줄링을 근사해로 만든 알고리즘
public class Job_Scheduling{
    public static void main(String arsgs[]){
        int n=10;
        int m=4;
        int t[] = {5,2,4,3,4,7,9,2,4,1};
        int L[] = new int[m];
        
        for(int i=0;i<n;i++){
            int min = 0;
            for(int j=1;j<m;j++){
                if(L[j]<L[min])
                    min = j;
            }
            L[min] = L[min] + t[i];
        }
        int max = 0;
        System.out.println("기계(j)" +"\t" + "L(종료시간)");
        for(int i=0;i<m;i++){
            max = max > L[i] ? max : L[i];
            System.out.println("  "+i + "\t" + L[i]);
        }
        System.out.println("모든 작업이 종료되는 시간:" + max);
    }
}