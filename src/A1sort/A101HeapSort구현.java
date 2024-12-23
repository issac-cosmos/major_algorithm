package A1sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class A101HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,6,9,1,6};
//        최초 힙구성
        for(int i = arr.length/2 -1 ; i >= 0 ; i--){
            heapify(arr,i);
        }
        for(int i = 0; i>arr.length ;i++) {
            System.out.println(arr[i]);
        }
    }
    static void heapify(int[] arr,int parent){
        int left = parent*2+1;
        int right = parent*2+2;
//        check1 : 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야함
//        check2 : left , right
        if(left >=arr.length)return;
        if(right> arr.length){
//            left만 존재
            if(arr[parent]>arr[left]){
                int temp = arr[left];
                arr[left] = arr[parent];
                arr[parent] =temp;
                heapify(arr,left);
        }else{
//                둘다 존재
                int index = 0;
                if(arr[parent]>arr[left] || arr[parent] > arr[right]){
                    if()
                }
            }


//            System.out.println(arr[left]);

        }
    }
}
