// Ref: https://iridiumcao.github.io/algorithm/chief/content.html

public class Chief {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            int count = 0;
            count += (i != 1) ? 1 : 0;
            count += (i == 3) ? 1 : 0;
            count += (i == 4) ? 1 : 0;
            count += (i != 4) ? 1 : 0;

            if (count == 3) {
                System.out.println("小偷的编号: " + i);
            }
        }
    }
}
