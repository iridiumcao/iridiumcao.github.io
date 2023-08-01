import java.util.Scanner;

public class BubbleSort {

    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Please input 5 integers splited by comma (do not input blank): ");
        scanner = new Scanner(System.in);
        String sc = scanner.next();
        String[] ints = sc.split(",");
        int[] arrays = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            arrays[i] = Integer.parseInt(ints[i]);
            // System.out.println(arrays[i]);
        }

        int[] sortedArrays = bubbleSort(arrays);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(sortedArrays[i]);
        }
    }

    private static int[] bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        return arrays;
    }
}