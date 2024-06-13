// Ref: https://iridiumcao.github.io/algorithm/chief/content.html

public class Chief2 {
    public static void main(String[] args) {
        int[] a = { 0, 1 };// 0表示不是小偷，1表示是小偷
        int[] b = { 0, 1 };
        int[] c = { 0, 1 };
        int[] d = { 0, 1 };
        for (int i : a) {
            for (int j : b) {
                for (int k : c) {
                    for (int m : d) {
                        int count = 0;
                        count += (i != 1) ? 1 : 0;
                        count += (k == 1) ? 1 : 0;
                        count += (m == 1) ? 1 : 0;
                        count += (m != 1) ? 1 : 0;
                        if (count == 3) {
                            System.out.println("A " + (i == 1 ? "" : "不") + "是小偷");
                            System.out.println("B " + (j == 1 ? "" : "不") + "是小偷");
                            System.out.println("C " + (k == 1 ? "" : "不") + "是小偷");
                            System.out.println("D " + (m == 1 ? "" : "不") + "是小偷");
                            System.out.println("----");
                        }
                    }
                }
            }
        }
    }
}
