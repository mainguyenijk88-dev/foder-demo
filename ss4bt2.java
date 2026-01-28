import java.util.Scanner;

public class ss4bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        int sum = 0; // biến lưu tổng

        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // nhập phần tử
            sum += a[i];         // cộng vào tổng
        }

        System.out.println("Tổng các phần tử trong mảng là: " + sum);
    }
}
