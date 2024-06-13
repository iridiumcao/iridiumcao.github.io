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
 * 这是 BestCar 的一个简化版本
 */
public class BestCar2 {

	public static void main(String[] args) {

		for (int i = 1; i <= 4; i++) {
			int count = 0; // 所有人所对话的总数
			count += ((i == 2) ? 1 : 0);// 2号赛车是最好的
			count += ((i == 4) ? 1 : 0);// 4号赛车是最好的
			count += ((i != 3) ? 1 : 0);// 3号赛车不是最好的
			count += ((i != 4) ? 1 : 0);// 4号赛车不是最好的

			if (count == 1) {// 只有一个人说的对的
				System.out.println(i + "号车是最好的");
				if (i == 2) {
					System.out.println("A说的对");
				}
				if (i == 4) {
					System.out.println("B说的对");
				}
				if (i != 3) {
					System.out.println("C说的对");
				}
				if (i != 4) {
					System.out.println("D说的对");
				}
			}
		}

	}
}
