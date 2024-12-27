package A5dp;

import java.util.Arrays;

public class A503정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7},
                            {3, 8},
                            {8, 1, 0},
                            {2, 7, 4, 4},
                            {4, 5, 2, 6, 5}};
        int answer = 0;


        for(int i = 1; i<triangle.length ; i++){
            for(int j = 0; j<triangle[i].length ; j++){
                if(j==0) {
                    triangle[i][j] += triangle[i-1][j];
                }else if(i==j) {
                    triangle[i][j] += triangle[i-1][j-1];
                }else if(triangle[i-1][j-1]>=triangle[i-1][j]){
                    triangle[i][j]+=triangle[i-1][j-1];
                }else {
                    triangle[i][j]+=triangle[i-1][j];
                }
            }
        }
        for(int a : triangle[triangle.length-1]){
           answer=Math.max(answer,a);
        }
        System.out.println(answer);
    }
}
