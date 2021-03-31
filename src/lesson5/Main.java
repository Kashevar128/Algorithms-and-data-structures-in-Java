package lesson5;

public class Main {
    public static void main(String[] args) {
//        System.out.println(fact(5));
        System.out.println(recFact(5));

//        System.out.println(fibo(47));
        System.out.println(recFibo(10));

//        System.out.println(triangleNum(5));
//        System.out.println(recTriangleNum(5));

        System.out.println(multiply(3,8));
        System.out.println(recMultiply(3,8));

        System.out.println(exponention(5, 7));

    }

    public static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static int recFact(int n) {
        if (n == 1) {
            return 1;
        }
        return recFact(n - 1) * n;
    }

    public static long fibo(long n) {
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    public static long recFibo(long n) {
        System.out.print(n + " ");
        if (n < 3) {
            return 1;
        }

        return recFibo(n - 1) + recFibo(n - 2);
    }

    public static long triangleNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long recTriangleNum(int n) {
        if (n == 1) {
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }

    public static int multiply(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        return value;
    }

    public static int recMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }
     public static int exponention(int number, int degree) {
        if (degree == 1) return  number;
        return number * exponention(number,degree - 1);
     }

}
