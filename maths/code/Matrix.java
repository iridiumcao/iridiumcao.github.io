public class Matrix {

    /**
     * Assume A has m rows and n columns, B has n rows and p columns,
     * so AB has m rows and p columns.
     * <p>
     * Assume AB = C,
     * <p>
     * c[i][j] is the dot product of the i-th row in A and j-th column in B:
     * c[i][j] = a[i][*] b[*][j]
     *
     * @param a, the left matrix A
     * @param b, the right matrix B
     * @return AB
     */
    public static int[][] product(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = b[0].length;
        int[][] c = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int[] row = a[i];
                int[] col = new int[columns];
                for (int k = 0; k < b.length; k++) {
                    col[k] = b[k][j];
                }

                // c[i][j] = a[i][*] b[*][j]
                c[i][j] = dotProduct(row, col);
            }
        }
        return c;
    }

    public static void product(int[][] a, int[][] b, int[][] r) {
        int rows = a.length;
        int columns = b[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int[] row = a[i];
                int[] col = new int[columns];
                for (int k = 0; k < b.length; k++) {
                    col[k] = b[k][j];
                }

                // c[i][j] = a[i][*] b[*][j]
                r[i][j] = dotProduct(row, col);
            }
        }
    }

    public static int dotProduct(int[] a, int[] b) {
        int dp = 0;
        for (int i = 0; i < a.length; i++) {
            dp += a[i] * b[i];
        }
        return dp;
    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // A:
        // 1 2
        // 3 4
        // 5 6
        int[][] a = new int[][]{
                {1, 2}, {3, 4}, {5, 6}
        };

        // B:
        // 7, 8
        // 9, 10
        int[][] b = new int[][]{
                {7, 8}, {9, 10}
        };

        // C:
        // 25, 28
        // 57, 64
        // 89, 100
        print(product(a, b));

        System.out.println("-------------");

        int[][] r = new int[a.length][b[0].length];
        product(a, b, r);
        print(r);
    }
}
