package A2dfs;

import java.util.*;

public class A202DfsBasic2 {
    static List<List<Integer>> mylist = new ArrayList<>();
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3,7}, {4,8}, {4,9}, {5,10}};
        //단방향
        for(int i = 0 ; i<11 ; i++){
            mylist.add(new ArrayList<>());
        }
        for(int[] a : arr){
            mylist.get(a[0]).add(a[1]);
        }
//          {1 2 4 8} , {1 2 4 9} , {1 2 5 10} , {1 3 6} , {1 3 7}
        boolean[] visited = new boolean[11];
        List<Integer> loadlist = new ArrayList<>();

        dfs(1,visited,loadlist);

    }
    static void dfs(int start, boolean[] visited,List<Integer> loadlist){
        loadlist.add(start);
        visited[start] = true;
        if(mylist.get(start).isEmpty()){
            System.out.print(loadlist+" ");
        }
        for(int target:mylist.get(start)){
            if(!visited[target]){
                dfs(target,visited,loadlist);
                loadlist.remove(loadlist.size()-1);
            }

        }
    }
}

// 강사님 풀이

//public class A202DfsBasic2 {
//    static List<List<Integer>> adjList;
//    static List<List<Integer>> answer;
//    public static void main(String[] args) {
//        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3,7}, {4,8}, {4,9}, {5,10}};
//        adjList = new ArrayList<>();
//        for(int i=0; i<11; i++){
//            adjList.add(new ArrayList<>());
//        }
//        for(int[] a : arr){
//            adjList.get(a[0]).add(a[1]);
//        }
//        System.out.println(adjList);
////        {1,2,4,8}, {1,2,4,9}, {1,2,5,10}, {1,3,6}, {1,3,7}
//        answer=new ArrayList<>();
//        dfs(1, new ArrayList<>());
//        System.out.println(answer);
//    }
//    static void dfs(int start, List<Integer> temp){
//        temp.add(start);
//        if(adjList.get(start).isEmpty()){
//            answer.add(new ArrayList<>(temp));
//        }
//        for (int target : adjList.get(start)){
//            dfs(target,temp);
//            temp.remove(temp.size()-1);
//        }
//    }
//}