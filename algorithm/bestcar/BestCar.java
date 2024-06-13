/**
 * 
 * 四名专家对四款赛车进行了评论： 
 * A说：2号赛车是最好的。 
 * B说：4号赛车是最好的。 
 * C说：3号赛车不是最好的。 
 * D说：B说错了。
 * 
 * 事实上只有一款赛车最佳，且只有一名专家的评论是正确的。
 * 
 * 那个赛车最好？
 * 
 * Ref: https://iridiumcao.github.io/algorithm/bestcar/content.html
 * 
 */
public class BestCar {

	public static void main(String[] args) {
		int[] first = { 0, 1 };// 1号车, 0表示不是最好，1表示为最好
		int[] second = { 0, 1 };// 2号车,
		int[] third = { 0, 1 };// 3号车，
		int[] forth = { 0, 1 };// 4号车
		int count = 0; // 所有人说对话的总数
		for (int i : first) {
			for (int j : second) {
				for (int k : third) {
					for (int m : forth) {
						if (i + j + k + m == 1) {//只有一个车是最好的
							count = 0;
							count += ((j == 1) ? 1 : 0);// 2号赛车是最好的
							count += ((m == 1) ? 1 : 0);// 4号赛车是最好的
							count += ((k != 1) ? 1 : 0);// 3号赛车不是最好的
							count += ((m != 1) ? 1 : 0);// 4号赛车不是最好的
							if (count == 1) {//只有一个人说的对的
								System.out.println("1号车：" + ((i == 1) ? "最好" : "不是最好"));
								System.out.println("2号车：" + ((j == 1) ? "最好" : "不是最好"));
								System.out.println("3号车：" + ((k == 1) ? "最好" : "不是最好"));
								System.out.println("4号车：" + ((m == 1) ? "最好" : "不是最好"));
							}
						}
					}
				}
			}
		}
	}
}
