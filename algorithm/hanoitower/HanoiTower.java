
/**
 * Compile:
 * javac -encoding UTF8 HanoiTower.java
 * Run:
 * java HanoiTower
 */
public class HanoiTower {

    public static void hanoi(int i, String a, String b, String c) { // 以 b 为中转, 将 i 个盘子从 a 移动到 c
        if (i == 1) {
            move(a, c); // 直接将 a 移动到 c
        }
        if (i > 1) {
            hanoi(i - 1, a, c, b); // 以 c 为中转, 将 i-1 个盘子从 a 移动到 b
            move(a, c); // 直接将 a 移动到 c, 此时移动的就是最底下的那个盘子
            hanoi(i - 1, b, a, c); // 以 a 为中转, 将 i-1 个盘子从 b 移动到 c
        }
    }

    public static void move(String src, String dst) {
        System.out.println(src + " -> " + dst);
    }

    public static void main(String[] args) {
        hanoi(5, "A", "B", "C");
    }
}