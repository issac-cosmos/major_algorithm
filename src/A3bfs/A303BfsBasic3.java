package A3bfs;

import java.util.*;

public class A303BfsBasic3 {
    public static void main(String[] args) {
        int[][] edge = {{0,2}, {0,1},{1,3},{2,3},{2,4}};
        int[] distance = new int[5];
//        0에서 출발해서 4번 노드까지 도달하는 최단거리 구하기
        int targetNode = 4;
        List<List<Integer>> mylist = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            mylist.add(new ArrayList<>());
        }
        for(int[] a : edge){
            mylist.get(a[0]).add(a[1]);
            mylist.get(a[1]).add(a[0]);
        }
        for(List<Integer> a : mylist){
            a.sort(Comparator.naturalOrder());
        }
        boolean[] visited = new boolean[5];
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0);
        visited[0] = true;
        distance[0]=0;

        while (!myQueue.isEmpty()){
            int temp = myQueue.poll();
//            System.out.println(temp);
            for(int target : mylist.get(temp)){
                if(!visited[target]){
                    myQueue.add(target);
                    visited[target] = true;

                    distance[target]=distance[temp]+1;
                    if(target == targetNode){
                        break;
                    }//targetNode를 발견시 더이상의 distance를 구하기 위한 작업을 할필요가없음.
                }
            }
        }
        System.out.println(distance[targetNode]);
    }
}
