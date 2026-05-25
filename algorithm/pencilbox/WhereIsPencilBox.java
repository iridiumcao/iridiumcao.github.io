/*
 * 明明找不到铅笔盒了，妈妈对他说：“我把铅笔盒放到三个抽屉中的一个抽屉里了，每个抽屉上都写了一句话。不过，其中只有一句话是真的。”
 * 明明看到的三句话是：
 * 左边抽屉：“铅笔盒不在这里”；
 * 中间抽屉：“铅笔盒不在这里”；
 * 右边抽屉：“铅笔盒在左边的抽屉”；
 * 
 * Ref: http://sites.google.com/site/iridiumsite/it/algorithms/whereispencilbox
 * 
 */
public class WhereIsPencilBox {

	public static void main(String[] args) {
		// 假设左中右的三个抽屉的编号依次为：1, 2, 3
		// 这个问题很明确的一点是，铅笔盒只能放在某一个抽屉里，以下按抽屉编号循环判断
		for (int i = 1; i <= 3; i++) {
			int count = 0;
			count += (i != 1) ? 1 : 0;// 铅笔盒不在左边的抽屉
			count += (i != 2) ? 1 : 0;// 铅笔盒不在中间的抽屉
			count += (i == 1) ? 1 : 0;// 铅笔盒在左边的抽屉

			if (count == 1) { // 只有一句话是真的
				System.out.println("放铅笔盒的抽屉编号是" + i);
			}
		}
	}

}
