package A1sort;

import java.util.*;

public class A102명예의전당 {
    public static void main(String[] args) {
        int k =3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] answer =new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            pq.add(score[i]);
            if(pq.size()>k )
            {
                pq.poll();
            }
            answer[i] = pq.peek();

        }
        System.out.println(Arrays.toString(answer));
    }

}
