package A3bfs;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.*;

public class A305게임맵 {
    public static void main(String[] args) {
        int[][] maps = new int[][]
                        {{1,0,1,1,1},
                         {1,0,1,0,1},
                         {1,0,1,1,1},
                         {1,1,1,0,1},
                         {0,0,0,0,1}};
        int answer = -1;
        int[] upDown = {1,0,0,-1}; //위 아래
        int[] leftRight = {0,-1,1,0}; //좌 우
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        int endWidth = maps[0].length;
        int endLength = maps.length;
        maps[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            for (int i = 0; i <4 ; i++) {
                int nx = x+upDown[i];
                int ny = y+leftRight[i];
                if(nx>=0 && ny>=0 && nx<endLength && ny<endWidth && maps[nx][ny]== 1){
                    queue.add(new int[]{nx,ny,distance+1});
                    maps[nx][ny]= -1;
                    if(nx==maps[0].length-1&&ny==maps.length-1){
                        answer = distance+1;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}


//강사님 풀이

//public class A305게임맵 {
//    public static void main(String[] args) {
//        int[][] maps = {{1,0,1,1,1},
//                {1,0,1,0,1},
//                {1,0,1,1,1},
//                {1,1,1,0,1},
//                {0,0,0,0,1}};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0,0});
//        maps[0][0] = -1;
//        int[] dx = {1,-1,0,0};
//        int[] dy = {0,0,1,-1};
//        int answer = -1;
//        while (!queue.isEmpty()){
//            int[] temp = queue.poll();
//            int x = temp[1];
//            int y = temp[0];
//            for(int i=0; i<4; i++){
//                int nx = x+dx[i];
//                int ny = y+dy[i];
//                if(nx>=0 && ny>=0 && nx<maps[0].length && ny<maps.length){
//                    if(maps[ny][nx]==1){
//                        queue.add(new int[]{ny, nx});
//                        maps[ny][nx]= maps[y][x]+1;
//                    }
//                }
//            }
//        }
//        if(maps[maps.length-1][maps[0].length-1] != 1){
//            answer = maps[maps.length-1][maps[0].length-1];
//        }
//        System.out.println(answer);
//    }
//}