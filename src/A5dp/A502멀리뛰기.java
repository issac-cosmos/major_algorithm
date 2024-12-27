package A5dp;

public class A502멀리뛰기 {
    public static void main(String[] args) {
        int n = 5;
        long answer = 0;

//        int[] jump = new int[2002];
//
//        jump[1]=1;
//        jump[2]=2;
//
//        for(int i = 3 ; i<=n+1 ; i++){
//            jump[i] = (jump[i - 1] + jump[i - 2])%1234567;
//        }
//        answer = jump[n];
//        System.out.println(answer);
        if(n==1){
            answer=1;
        }else if(n==2){
            answer=2;
        }else {
            int fir= 1;
            int sec= 2;
            for(int i =2 ; i<=n ; i++){
                fir=(fir+sec)%1234567;
                int temp = fir;
                fir = sec;
                sec= temp;
            }
        answer = fir;
        }
        System.out.println(answer);

    }
}
