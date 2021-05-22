import java.util.Arrays;

public class TSP {
    private static int MAX = 1000;
    private static int map[][] = {
        {0,2,9,MAX},
        {1,0,6,4},
        {MAX,7,0,8},
        {6,3,MAX,0}
    };
	private static int n = map.length;
    public static int D[][];

	public static void main(String args[]) throws Exception {
    	D = new int[n][1 << (n)];

        for (int i = 0; i < n; i++) {
				Arrays.fill(D[i], MAX);
		}
        tsp(0,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<(1<<n);j++)
                System.out.print(D[i][j] + " ");
            System.out.println();
        }
	}

	private static int tsp(int cur, int visit) {
		if (visit == (1 << n) - 1)
			return map[cur][0];
            
		if (D[cur][visit] != MAX)
			return D[cur][visit];

		for (int i = 0; i < n; i++) {
			if ((visit & (1 << i)) == 0 && map[cur][i] != 0) { // 방문을 안했는데 길이 있으면 방문한다.
				D[cur][visit] = Math.min(D[cur][visit], map[cur][i] + tsp(i, visit | (1 << i)));
			}
		}
		return D[cur][visit];
	}
}