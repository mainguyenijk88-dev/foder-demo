import java.util.Scanner;

public class ss3bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        double total = 0;
        double max = -1;
        double min = 11;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập điểm: ");
                        double diem = sc.nextDouble();

                        if (diem == -1) {
                            break;
                        }

                        if (diem < 0 || diem > 10) {
                            System.out.println("Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }

                        // cập nhật thống kê
                        count++;
                        total += diem;
                        if (diem > max) max = diem;
                        if (diem < min) min = diem;

                        // xếp loại
                        if (diem < 5) {
                            System.out.println("Học lực: Yếu");
                        } else if (diem < 7) {
                            System.out.println("Học lực: Trung bình");
                        } else if (diem < 8) {
                            System.out.println("Học lực: Khá");
                        } else if (diem < 9) {
                            System.out.println("Học lực: Giỏi");
                        } else {
                            System.out.println("Học lực: Xuất sắc");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- KẾT QUẢ ---");
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("Số học viên đã nhập: " + count);
                        System.out.printf("Điểm trung bình: %.2f\n", total / count);
                        System.out.printf("Điểm cao nhất: %.2f\n", max);
                        System.out.printf("Điểm thấp nhất: %.2f\n", min);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        }
    }
}
