import java.util.Scanner;

/**
 * 
 * @author caoi
 * 
 */
public class QuickSort {

	private static Scanner scanner;

	public static void main(String[] args) {
		System.out
				.println("Please input integers splited by comma (do not input blank): ");
		scanner = new Scanner(System.in);
		String sc = scanner.next();
		String[] ints = sc.split(",");

		int[] arrays = new int[ints.length];
		for (int i = 0; i < ints.length; i++) {
			arrays[i] = Integer.parseInt(ints[i]);
			// System.out.println(arrays[i]);
		}

		QuickSort qs = new QuickSort();
		qs.quickSort(arrays, 0, arrays.length - 1);

		for (int i = 0; i < ints.length; i++) {
			System.out.print(arrays[i] + ", ");
		}

	}

	// 把基准值放到合适的位置后，并返回基准值的 index
	public int moveBase(int[] list, int left, int right) {
		if (list.length == 1 || left == right) {
			return left;
		}
		int baseIndex = left;
		int base = list[baseIndex]; // 数组的第一个作为基准值
		while (left + 1 < right) { // 这里比较的是哨兵的 index，左边哨兵的 index = left + 1
			while (left + 1 < right && list[right] >= base) {
				right--;
			}

			while (left + 1 < right && list[left + 1] <= base) {
				left++;
			}

			int tmp = list[left + 1];
			list[left + 1] = list[right];
			list[right] = tmp;
		}

		// 交换基准值和 left 哨兵位置的值
		list[baseIndex] = list[left + 1];
		list[left + 1] = base;

		return left + 1; // 返回基准值的 index
	}

	/**
	 * 
	 * @param list
	 *            array
	 * @param left
	 *            left index
	 * @param right
	 *            right index
	 */
	public void quickSort(int[] list, int left, int right) {
		if (left < right) {
			int baseIndex = moveBase(list, left, right); // 将 list 数组进行一分为二
			quickSort(list, left, baseIndex - 1); // 对左边的元素排序
			quickSort(list, baseIndex + 1, right); // 对右边的元素排序
		}
	}

}
