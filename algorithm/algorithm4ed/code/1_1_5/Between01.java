public class Between01 {
    public static void main(String... args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        System.out.println(isBetween01(x, y));
    }

    public static boolean isBetween01(double x, double y) {
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            return true;
        }
        return false;
    }
}