package A3bfs;

import java.util.*;

public class A301BfsBasic1 {
    public static void main(String[] args) {
//        방문할수있는 정점이 여러개인경우 , 정점번호가 작은것들을 먼저 방문
//        bfs알고리즘 형식의 방문순서를 출력. 출발은 0부터
        int[][] edge = {{0,2}, {0,1},{1,3},{2,3},{2,4}};
//        bfs로 방문시 0 1 2 3 4
        List<List<Integer>> mylist = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            mylist.add(new ArrayList<>());
        }
//        인접리스트에 담기. (양방향)
        for(int[] a : edge){
            mylist.get(a[0]).add(a[1]);
            mylist.get(a[1]).add(a[0]);
        }
        for(List<Integer> a : mylist){
            a.sort(Comparator.naturalOrder());
        }
        boolean[] visited = new boolean[5];
//        bfs알고리즘을 구현하기위한 Queue생성
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0);
        visited[0] = true;
//          queue가 비워질때까지, 방문을 지속.
//          queue가 비워신다는것은 더이상 갈곳이 없을때를 의미. 이때 코드 종료.
        while (!myQueue.isEmpty()){
            int temp = myQueue.poll();
            System.out.println(temp);
            for(int target : mylist.get(temp)){
                if(!visited[target]){
                    myQueue.add(target);
//                    queue에 add하는 시점에 boolean값 세팅
                    visited[target] = true;
                }
            }
        }


    }
}