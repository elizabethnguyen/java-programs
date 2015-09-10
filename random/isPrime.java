import java.util.*;

public class isPrime
{
    public static void main(String[] args)
    {
        isPrime(Integer.parseInt(args[0]));
    }

    public static void isPrime(int n) {
        if (n == 2) {
            System.out.println("2 is prime");
            return;
        }
        if (n % 2 == 0) {
            System.out.println(n + " is not prime");
            return;
        }
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrtN; i +=2) {
            if (n % i == 0) {
                System.out.println(n + " is not prime");
                return;
            }
        }

        System.out.println(n + " is prime");
    }
}
