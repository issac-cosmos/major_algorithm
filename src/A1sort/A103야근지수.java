package A1sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A103야근지수 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0 ; i<works.length;i++)
        {
            pq.add(works[i]);
        }
        for(int i = 0 ; i<n ; i++){

            int temp= 0;
            temp=pq.peek()-1;
            if(pq.peek()==0){
                result =0;
                break;
            }
            pq.poll();
            pq.add(temp);
        }
        System.out.println(pq);
        while (!pq.isEmpty())
        {
            result += pq.peek()*pq.peek();
            pq.poll();
        }
        System.out.println(result);
    }
}
