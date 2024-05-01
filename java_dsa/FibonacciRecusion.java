import java.util.Arrays;

public class FibonacciRecusion {

    static final int max = 10000;
    static int[] fib = new int[max];
    public static void main(String[] args) {
        //System.out.println("1st Fibonacci number: "+fib(100));
        int[] fibresult = new int[100];
        fibDynamic(100,fibresult);
        System.out.println(Arrays.toString(fibresult));
    }
    static int fib(int n) {
        if(n<=1) 
            return n;
        else
            return fib(n-1)+fib(n-2);
    }

    static void fibDynamic(int n,int[] res) {
        
        if (n == 0) res[0] = 0;
        if (n == 1) res[1] = 1;
        if(fib[n] != 0 )
            return fib[n];
        fibDynamic(n-1, res) + fibDynamic(n-2, res);
        return fib[n];
    }
}
