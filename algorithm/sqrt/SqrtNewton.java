/**
 * 这部分代码来自《算法·第4版》
 */
public class SqrtNewton {
    public static void main(String[] args) {
        System.out.println(sqrt(1.0));
        System.out.println(sqrt(2.0));
        System.out.println(sqrt(3.0));
        System.out.println(sqrt(4.0));
        System.out.println(sqrt(5.0));
    }

    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }

        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }
}