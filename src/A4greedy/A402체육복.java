package A4greedy;

import java.util.Arrays;

public class A402체육복 {
    public static void main(String[] args) {
        int n =5;
        int[] lost = new int[]{2,4};
        int[] reserve = new int[]{3};
        int[] student1 = new int[n+1];
        int[] student2 = new int[n+1];
        Arrays.fill(student2,1);
        Arrays.fill(student1,1);
        for(int i=0;i<lost.length;i++){

            student1[lost[i]]--;
            student2[lost[i]]--;
        }
        student1[0]=0;
        student2[0]=0;

        int caseup= 0;
        int casedown = 0;
        for(int i = 0;i<reserve.length;i++){
            if(student1[reserve[i]]==1&&student1[reserve[i]-1]==0){
                student1[reserve[i]-1]++;
            }
        }
        for(int i = 0;i<reserve.length;i++){
            if(student2[reserve[i]]==1&&student2[reserve[i]+1]==0){
                student2[reserve[i]+1]++;
            }
        }


        for(int a : student1){
            caseup+=a;
        }

        for(int a : student2){
            casedown+=a;
        }
        System.out.println(Arrays.toString(student1));
        System.out.println(Arrays.toString(student2));
        int answer = Math.max(caseup,casedown);
        System.out.println(answer);

    }
}
//gpt 풀이
//import java.util.*;
//
//class Solution {
//    public int solution(int n, int[] lost, int[] reserve) {
//        int[] students = new int[n + 1];
//        Arrays.fill(students, 1); // 모든 학생이 체육복 1개씩 가지고 있음
//
//        // 잃어버린 학생의 체육복 감소
//        for (int l : lost) {
//            students[l]--;
//        }
//
//        // 여분을 가진 학생의 체육복 증가
//        for (int r : reserve) {
//            students[r]++;
//        }
//
//        // 체육복을 빌려주는 과정
//        for (int i = 1; i <= n; i++) {
//            if (students[i] == 0) { // 체육복이 없는 학생
//                if (i > 1 && students[i - 1] == 2) { // 왼쪽 학생이 여분이 있는 경우
//                    students[i]++;
//                    students[i - 1]--;
//                } else if (i < n && students[i + 1] == 2) { // 오른쪽 학생이 여분이 있는 경우
//                    students[i]++;
//                    students[i + 1]--;
//                }
//            }
//        }
//
//        // 체육복을 가진 학생 수 계산
//        int answer = 0;
//        for (int i = 1; i <= n; i++) {
//            if (students[i] > 0) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}