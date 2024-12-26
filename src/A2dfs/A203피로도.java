package A2dfs;

import java.util.*;

public class A203피로도 {
    static int answer= -1;
    public static void main(String[] args) {
        int k =80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int depth = 0;

        boolean[] visited = new boolean[dungeons.length];


        dfs(k,dungeons,visited,depth);
        System.out.println(answer);

    }
    static void dfs(int stackK,int[][] dungeons,boolean[] visited,int depth){

        if(stackK>0) {
            for (int i = 0; i < dungeons.length; i++) {

                if (stackK < dungeons[i][0] || visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(stackK - dungeons[i][1], dungeons, visited, depth + 1);
                visited[i] = false;
            }
            answer = Math.max(answer, depth);
        }
    }
}

//강사님 풀이

//public class A203피로도 {
//    static int answer;
//    static int static_k;
//    static int static_count;
//    public static void main(String[] args) {
//        int k=80;
//        int[][] dungeons = {{80, 20}, {50,40}, {30,10}};
//        static_k = k;
//        boolean[] visited = new boolean[dungeons.length];
//        dfs(dungeons, visited);
//        System.out.println(answer);
//    }
//
//    static void dfs(int[][] dungeons, boolean[] visited){
//        if(static_count > answer){
//            answer = static_count;
//        }
//        for (int i=0; i<dungeons.length;i++){
//            if(dungeons[i][0] <= static_k && !visited[i]){
//                visited[i] = true;
//                static_k -= dungeons[i][1];
//                static_count+=1;
//                dfs(dungeons, visited);
//                visited[i] = false;
//                static_k += dungeons[i][1];
//                static_count-=1;
//            }
//        }
//    }
//}
