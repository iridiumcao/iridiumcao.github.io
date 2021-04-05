public class ThreeEqual {
    public static void main(String... args) {
        if (Integer.parseInt(args[0]) == Integer.parseInt(args[1])
                && Integer.parseInt(args[0]) == Integer.parseInt(args[2])) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}