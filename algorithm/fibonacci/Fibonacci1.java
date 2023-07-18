public class Fibonacci1 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i ++) {
            System.out.println(fibonnaci(i));
        }
    }

    public static int fibonnaci(int i) {
        if (i < 0)
            return 0;
        if (i == 1 || i == 2)
            return 1;
        return fibonnaci(i - 1) + fibonnaci(i - 2);
    }
}