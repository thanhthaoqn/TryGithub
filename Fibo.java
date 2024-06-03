package J1.S.P0001;

public class Fibo {

   

    public static void main(String[] args) {
        System.out.println("The first 45 Fibonacci numbers:");
        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    }

    // fibo(0)= 0
    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2));

    }

}


