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
    public static double[][] product(double[][] a, double[][] b) {
        int rows = a.length;
        int columns = b[0].length;
        double[][] c = new double[rows][columns];
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double[] row = a[i];
                double[] col = new double[columns];
                for (int k = 0; k < b.length; k++) {
                    col[k] = b[k][j];
                }
    
                // c[i][j] = a[i][*] b[*][j]
                c[i][j] = dotProduct(row, col);
            }
        }
        return c;
    }

    public static double[][] productV2(double[][] a, double[][] b) {
        int rows = a.length;
        int columns = b[0].length;
        double[][] c = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void product(double[][] a, double[][] b, double[][] r) {
        int rows = a.length;
        int columns = b[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double[] row = a[i];
                double[] col = new double[columns];
                for (int k = 0; k < b.length; k++) {
                    col[k] = b[k][j];
                }

                // c[i][j] = a[i][*] b[*][j]
                r[i][j] = dotProduct(row, col);
            }
        }
    }

    public static double dotProduct(double[] a, double[] b) {
        double dp = 0.0;
        for (int i = 0; i < a.length; i++) {
            dp += a[i] * b[i];
        }
        return dp;
    }

    public static void print(double[][] a) {
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
        double[][] a = new double[][]{
                {1, 2}, {3, 4}, {5, 6}
        };

        // B:
        // 7, 8
        // 9, 10
        double[][] b = new double[][]{
                {7, 8}, {9, 10}
        };

        // C:
        // 25, 28
        // 57, 64
        // 89, 100
        print(product(a, b));

        System.out.println("-------------");

        double[][] r = new double[a.length][b[0].length];
        product(a, b, r);
        print(r);

        System.out.println("-------------");

        print(productV2(a, b));
    }
}
