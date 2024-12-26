package A5dp;

public class A501DpBasic {
    public static void main(String[] args) {
//        1,4,5 로 13을 만들수 있는 조합중에 가장 작은 조합의 개수
        int target = 13;
        int[] numbers = {1,4,5};
        if(target%10== 0){
            int a=target/5;
            System.out.println(a);
        }


    }
}
