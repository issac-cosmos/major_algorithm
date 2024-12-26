package A3bfs;

import java.util.*;

public class DfsBfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        int[][] goingto = new int[M][2];
        for(int i = 0; i<M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            goingto[i]= new int[]{a,b};
        }
        List<List<Integer>> mylist = new ArrayList<>();
        for(int i= 0 ; i<N+1 ; i++){
            mylist.add(new ArrayList<>());
        }
        for(int[] a : goingto){
            //양방향
            mylist.get(a[0]).add(a[1]);
            mylist.get(a[1]).add(a[0]);
        }
        boolean[] visited =new boolean[N+1];
        dfs(mylist,V,visited);   //인접리스트 , 시작포인트 , 방문체크

        System.out.println("");

        Queue<Integer> myQueue = new LinkedList<>();
        visited = new boolean[N];
        myQueue.add(V);
        visited[V-1]= true;
        while (!myQueue.isEmpty()){
            int temp = myQueue.poll();
            System.out.print(temp+" ");
            for(int target : mylist.get(V)){
                myQueue.add(target);
                visited[target]=true;

            }
        }


    }
    static void dfs(List<List<Integer>> mylist , int V ,boolean[] visited){
        visited[V] = true;
        System.out.print(V+" ");
        for(int a: mylist.get(V)){
            if(!visited[a]){
                dfs(mylist, a,visited);
            }
        }
    }
}
