import java.util.Scanner;

public class SS4BT5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số hàng: ");

        int rows = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập số cột: ");

        int cols = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[rows][cols];

        System.out.println("Nhập các phần tử cho mảng (theo từng hàng):");

        for (int i = 0; i < rows; i++) {

            System.out.print("Hàng " + (i + 1) + ": ");

            String [] values = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {

                arr[i][j] = Integer.parseInt(values[j]);
            }
        }

        int sumEven = 0;

        int sumOdd = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (arr[i][j] % 2 == 0) {

                    sumEven += arr[i][j];
                } else {

                    sumOdd += arr[i][j];
                }
            }
        }

        System.out.println("Tổng các số chẵn là: " + sumEven);
        System.out.println("Tổng các số lẻ là: " + sumOdd);
    }
}
