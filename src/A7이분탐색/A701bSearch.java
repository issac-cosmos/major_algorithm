package A7이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A701bSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int treesCounts = Integer.parseInt(inputs[0]);
        int needMiter = Integer.parseInt(inputs[1]);

        int[] trees = new int[treesCounts];

        String[] inputs2 = br.readLine().split(" ");

        for (int i = 0; i < treesCounts; i++) {
            int a = Integer.parseInt(inputs2[i]);

            trees[i] = a;
        }

        Arrays.sort(trees);

        int start = 1;
        int end = trees[trees.length-1];
        int maxLength = 0;

        while (start <= end) {
//            이분탐색을 위한 mid조건 설정.
            int mid = (start+end)/2;

//            int로 할 경우 나무의 길이가 매우 크기 때문에 범위초과할 가능성이 있다.
            long count = 0;
            for (int i = 0; i < trees.length; i++) {
                if (trees[i] - mid > 0) {
//                    0보다 작을 경우에도 count에 넣으면 count값 왜곡되기에 조건문 추가.
                    count += trees[i]-mid;
                }
            }

//            같다 라는 조건을 쓸 경우 실제 최적의 값임에도 불구하고
//            maxLength에 안담길 수 있으므로 >=사용.
            if (count >= needMiter) {
                maxLength = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(maxLength);
    }
}
