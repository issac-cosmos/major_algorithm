package A3bfs;

import java.util.*;

public class A304가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge =new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        List<List<Integer>> mylist = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            mylist.add(new ArrayList<>());
        }
        for(int[] a : edge){
            mylist.get(a[0]).add(a[1]);
            mylist.get(a[1]).add(a[0]);
        }

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(1);
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        distance[0] = 0;
        visited[1] =true;
        while (!myQueue.isEmpty()){
            int temp = myQueue.poll();

            for(int target : mylist.get(temp)){
                if(!visited[target]) {
                    myQueue.add(target);
                    visited[target] = true;
                    distance[target] = distance[temp] + 1;
                }
            }
        }
        Arrays.sort(distance);
        for(int i= 1; i<distance.length;i++){
            if(distance[distance.length-1]==distance[i]){
                System.out.println(i);
            }
            else {
                continue;
            }
        }
    }

}

//강사 풀이

//public class A304가장먼노드 {
//
//    public static void main(String[] args) {
//        int n = 6;
//        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
//        List<List<Integer>> adjList = new ArrayList<>();
//        for(int i=0; i<n+1; i++){
//            adjList.add(new ArrayList());
//        }
//        for(int[] a : edge){
//            adjList.get(a[0]).add(a[1]);
//            adjList.get(a[1]).add(a[0]);
//        }
//
//        int[] distance = new int[n+1];
//        Arrays.fill(distance, -1);
//        distance[1]=0;
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        while (!queue.isEmpty()){
//            int temp = queue.poll();
//            for(int t : adjList.get(temp)){
//                if(distance[t] == -1){
//                    distance[t] = distance[temp]+1;
//                    queue.add(t);
//                }
//            }
//        }
//        int max = Arrays.stream(distance).max().getAsInt();
//        int count = (int)Arrays.stream(distance).filter(a->a==max).count();
//    }
//}