package fib;
public class fib {

    public static int fib(int n) {
        if(n < 2){
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }


    public static void main(String[] args) {
        int n = 6;
        int result = fib(n);

        System.out.println(result);
    }
}
