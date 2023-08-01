public class HelloAlgrithm001 {

	public static void main(String[] args) {
		int[] a = { 3, 7, 8, 9, 10 };
		int[] b = genNewArray(a);
		for (int element : b) {
			System.out.println(element);
		}
	}

	public static int[] genNewArray(int[] a) {
		if (a[0] != 0) {
			for (int i = a.length - 1; i >= 0; i--) {
				a[i] /= a[0];
			}
		}
		return a;
	}

	public static int[] genNewArray1(int[] a) {
		int[] b = new int[a.length];
		if (a[0] != 0) {
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i] / a[0];
			}
		}
		return b;
	}

	public static void genNewArrray(int[] a) {
		if (a[0] != 0) {
			for (int i = a.length - 1; i >= 0; i--) {
				a[i] /= a[0];
			}
		}
	}

}
