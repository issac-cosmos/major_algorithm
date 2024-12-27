package A6투포인터;

public class A603숫자의표현 {
    public static void main(String[] args) {
        int n =15;
        int answer=0;
        int start= 1;
        int end = 1;

        int sum = 1;
        while (start<=n){

            if(sum<n){
                end++;
                sum+=end;
            }else if(sum==n){
                answer++;
                sum-=start;
                start++;
            }else {
                sum-=start;
                start++;
            }

        }
        System.out.println(answer);
    }
}
