public class GreatestCommonDivisor {

    /**
     * 
     * 求最大公约数，递归版本
     * 
     * @param a
     * @param b
     * @return
     */
    public static long calculateGcd(long a, long b) {
        if (a < 0 || b < 0) {
            System.out.println("Only accept numbers greater than 0.");
        }

        if (b == 0) {
            return a;
        }

        long r = a % b;

        return calculateGcd(b, r);
    }

    /**
     * 
     * 求最大公约数，非递归版本
     * 
     * @param a
     * @param b
     * @return
     */
    public static long calculateGcd2(long a, long b) {
        if (a < 0 || b < 0) {
            System.out.println("Only accept numbers greater than 0.");
        }

        if (b == 0) {
            return a;
        }

        while (true) {
            long r = a % b;
            if (r == 0) {
                break;
            }
            a = b;
            b = r;
        }

        return b;
    }

    public static void main(String[] args) {
        long a = 48;
        long b = 18;

        long gcd = calculateGcd(a, b);
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd);

        long gcd2 = calculateGcd2(a, b);
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd2);
    }
}