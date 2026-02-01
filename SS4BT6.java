import java.util.Arrays;
import java.util.Scanner;

public class SS4BT6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];

        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: " + Arrays.toString(arr));

        System.out.print("Nhập số cần tìm: ");
        int x = Integer.parseInt(sc.nextLine());

        int linearIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                linearIndex = i;
                break;
            }
        }

        if (linearIndex != -1) {
            System.out.println("Tìm kiếm tuyến tính: Phần tử " + x + " tìm thấy tại chỉ số: " + linearIndex);
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy phần tử " + x);
        }


        int left = 0;
        int right = n - 1;
        int binaryIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                binaryIndex = mid;
                break;
            } else if (arr[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (binaryIndex != -1) {
            System.out.println("Tìm kiếm nhị phân: Phần tử " + x + " tìm thấy tại chỉ số: " + binaryIndex);
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy phần tử " + x);
        }
    }
}
