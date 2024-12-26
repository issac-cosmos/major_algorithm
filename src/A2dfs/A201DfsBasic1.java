package A2dfs;

import java.util.*;

public class A201DfsBasic1 {
    public static void main(String[] args) {
//        방문할수있는 정점이 여러개인경우 , 정점번호가 작은것들을 먼저 방문
//        dfs알고리즘 형식의 방문순서를 출력. 출발은 0부터
        int[][] edge = {{0,2}, {0,1},{1,3},{2,3},{2,4}};
//        dfs로 방문시 0 1 3 2 4
        List<List<Integer>> mylist = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            mylist.add(new ArrayList<>());
        }
        for(int[] a : edge){
            mylist.get(a[0]).add(a[1]);
//        양방향인경우
            mylist.get(a[1]).add(a[0]);
        }
        System.out.println(mylist);
        //        정점번호가 작은것부터 방문하기 위한 정렬

        for(int i =0; i <mylist.size();i++){
            mylist.get(i).sort(Comparator.naturalOrder());
        }
        boolean[] visited= new boolean[5];
        dfs(mylist,visited,0);


    }
    static void dfs(List<List<Integer>> mylist,boolean[] visited,int start) {

        visited[start] = true;
        System.out.println(start);
        for (int a : mylist.get(start)) {
            if (!visited[a]) {
                dfs(mylist,visited, a);
            }
        }
    }
}
