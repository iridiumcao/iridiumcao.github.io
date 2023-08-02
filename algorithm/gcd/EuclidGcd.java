public class EuclidGcd {

	public static void main(String[] args) {
		EuclidGcd e = new EuclidGcd();
		System.out.println(e.calculateGcd(21, 30));
		System.out.println(e.calculateGcd2(21, 30));// 這是一個錯誤值
		System.out.println(e.calculateGcd2(21, 30));
	}

	// 非遞歸實現
	int calculateGcd(int m, int n) {
		if (m < n) {
			int a = m;
			m = n;
			n = a;
		}
		int r = m % n;
		while (r != 0) {
			m = n;
			n = r;
			r = m % n;
		}
		return n;
	}

	// 遞歸的一個錯誤實現，遞歸調用棧機制導致最終返回了錯誤的值。
	// 如 m = 21, n = 30 就可以得到錯誤的值。
	int calculateGcd2(int m, int n) {
		if (m < n) {
			int a = m;
			m = n;
			n = a;
		}
		int r = m % n;
		if (r != 0) {
			m = n;
			n = r;
			r = calculateGcd2(m, n);
		}
		return n;
	}

	// 遞歸實現之二
	int calculateGcd3(int a, int b) {
		if (b == 0) {
			return a;
		}
		return this.calculateGcd3(b, a % b);
	}
}
