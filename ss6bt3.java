import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ss6bt3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> danhSachBienSo = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n*****QUẢN LÝ BIỂN SỐ XE*****");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themBienSo(sc, danhSachBienSo);
                    break;
                case 2:
                    hienThi(danhSachBienSo);
                    break;
                case 3:
                    timChinhXac(sc, danhSachBienSo);
                    break;
                case 4:
                    timTheoMaTinh(sc, danhSachBienSo);
                    break;
                case 5:
                    sapXep(danhSachBienSo);
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);
    }

    // 1. Thêm biển số

    public static void themBienSo(Scanner sc, ArrayList<String> list) {

        System.out.print("Nhập số lượng biển số muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập biển số thứ " + (i + 1) + ": ");
            String bienSo = sc.nextLine();

            // Kiểm tra định dạng đơn giản
            if (bienSo.matches("\\d{2}[A-Z]-\\d{3}\\.\\d{2}")) {
                list.add(bienSo);
                System.out.println("Thêm thành công!");
            } else {
                System.out.println("Sai định dạng! Ví dụ đúng: 30F-123.45");
                i--; // nhập lại
            }
        }
    }

    // 2. Hiển thị

    public static void hienThi(ArrayList<String> list) {

        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        System.out.println("Danh sách biển số:");
        for (String bienSo : list) {
            System.out.println(bienSo);
        }
    }

    // 3. Tìm chính xác

    public static void timChinhXac(Scanner sc, ArrayList<String> list) {

        System.out.print("Nhập biển số cần tìm: ");
        String bienSoCanTim = sc.nextLine();

        if (list.contains(bienSoCanTim)) {
            System.out.println("Tìm thấy biển số!");
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    // 4. Tìm theo mã tỉnh

    public static void timTheoMaTinh(Scanner sc, ArrayList<String> list) {

        System.out.print("Nhập mã tỉnh (VD: 30, 51...): ");
        String maTinh = sc.nextLine();

        boolean found = false;

        for (String bienSo : list) {

            // Lấy 2 ký tự đầu
            String ma = bienSo.substring(0, 2);

            if (ma.equals(maTinh)) {
                System.out.println(bienSo);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có biển số thuộc mã tỉnh này!");
        }
    }

    // 5. Sắp xếp tăng dần

    public static void sapXep(ArrayList<String> list) {

        Collections.sort(list);
        System.out.println("Đã sắp xếp tăng dần!");
    }
}
