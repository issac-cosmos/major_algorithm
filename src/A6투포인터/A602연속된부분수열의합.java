package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A602연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        List<int[]> mylist = new ArrayList<>();
        int start = 0;
        int end = 0;
        int[] answer = {};
        int total= sequence[start];

        while (start<=end && end<sequence.length){
            if(start==end) {
                if(sequence[start]==k) {
                    mylist.add(new int[]{start, end});
                }
                end++;
                if(end<=sequence.length-1) {
                    total += sequence[end];
                }
            }else {

                if(total<k){
                    end++;
                    total+=sequence[end];
                }
                else if(total>k){

                    total-=sequence[start];
                    start++;
                }
                else {
                    mylist.add(new int[]{start, end});
                    end++;
                    total+=sequence[end];
                }

            }


        }
        int min =Integer.MAX_VALUE;
        for(int[] a : mylist){
            if (min>a[1]-a[0]) {
                min =a[1]-a[0];
                answer=new int[]{a[0],a[1]};
            }
        }
        System.out.println(Arrays.toString(answer));

    }
}
