import java.util.*;

public class Fibonacci
{
    public static ArrayList<Integer> fibMem = null;

    public static void main(String[] args)
    {
        fibMem = new ArrayList<Integer>(Collections.nCopies(10, 0));
        System.out.println(fib(5));
        System.out.println(fib(8));
        System.out.println(fib(2));
        System.out.println(fib(7));
    }

    public static int fib(int n)
    {
        int num = fibMem.get(n);
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (num == 0) {
            num = fib(n-1) + fib(n-2);
            fibMem.add(n, num);
            return num;
        } else {
            return num;
        }
    }
}
