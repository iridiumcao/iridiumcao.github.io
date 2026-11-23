public class Fibonacci1 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i ++) {
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci(int i) {
        if (i < 0)
            return 0;
        if (i == 1 || i == 2)
            return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}