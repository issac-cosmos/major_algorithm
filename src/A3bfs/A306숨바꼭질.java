package A3bfs;

import java.util.*;

public class A306숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{N,0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;

        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            int position= temp[0];
            int distance = temp[1];

            if(position== K){
                System.out.println(distance);
                return;
            }
            int[] nextposition = {position-1,position+1,position*2};
            for(int next : nextposition){
                if(next>=0 && next<=100000 && !visited[next]){
                    visited[next] = true;
                    pq.add(new int[]{next,distance+1});
                }
            }
        }
    }
}

//기현님 풀이

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        if (nk[0]>=nk[1]) {
//            System.out.println(nk[0]-nk[1]);
//            return;
//        }
//        System.out.println(solution(nk[0], nk[1]));
//
//    }
//    public static int solution(int n, int k){
//        int[] dp = new int[k+2];
//        for (int i = 0; i<=k+1; i++) {
//            dp[i] = Math.abs(i-n);
//        }
//
//        for (int i = n; i<=k; i++){
//            int min;
//            if (i %2==0) min = dp[i/2]+1;
//            else min = Math.min(dp[(i-1)/2], dp[(i+1)/2])+2;
//            dp[i] = Math.min(dp[i],min);
//        }
//        return dp[k];
//    }
//}
