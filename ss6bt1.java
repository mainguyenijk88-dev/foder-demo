import java.util.Scanner;
import java.util.Arrays;

public class ss6bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] diemSV = new double[0];
        int choice;

        do {
            System.out.println("******************QUẢN LÝ ĐIỂM SV****************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    diemSV = new double[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
                        diemSV[i] = sc.nextDouble();
                    }
                    break;

                case 2:
                    System.out.println("Danh sách điểm sinh viên:");
                    for (double d : diemSV) {
                        System.out.print(d + "  ");
                    }
                    System.out.println();
                    break;

                case 3:
                    double tong = 0;
                    for (double d : diemSV) {
                        tong += d;
                    }
                    System.out.println("Điểm trung bình: " + (tong / diemSV.length));
                    break;

                case 4:
                    double max = diemSV[0];
                    double min = diemSV[0];
                    for (double d : diemSV) {
                        if (d > max) max = d;
                        if (d < min) min = d;
                    }
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (double d : diemSV) {
                        if (d >= 5) dat++;
                        else truot++;
                    }
                    System.out.println("Số SV đạt: " + dat);
                    System.out.println("Số SV trượt: " + truot);
                    break;

                case 6:
                    Arrays.sort(diemSV);
                    System.out.println("Danh sách điểm sau khi sắp xếp tăng dần:");
                    for (double d : diemSV) {
                        System.out.print(d + "  ");
                    }
                    System.out.println();
                    break;

                case 7:
                    int gioiXuatSac = 0;
                    for (double d : diemSV) {
                        if (d >= 8) gioiXuatSac++;
                    }
                    System.out.println("Số sinh viên giỏi và xuất sắc: " + gioiXuatSac);
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 8);
    }
}
