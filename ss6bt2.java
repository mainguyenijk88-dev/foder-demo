import java.util.Scanner;
import java.util.regex.Pattern;

public class ss6bt2 {

    // Biến toàn cục lưu thông tin người dùng
    static String hoTen = "";
    static String email = "";
    static String sdt = "";
    static String matKhau = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("******************QUẢN LÝ NGƯỜI DÙNG****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine(); // xóa bộ nhớ đệm

            switch (choice) {
                case 1:
                    nhapThongTin(sc);
                    break;
                case 2:
                    chuanHoaHoTen();
                    break;
                case 3:
                    kiemTraEmail();
                    break;
                case 4:
                    kiemTraSoDienThoai();
                    break;
                case 5:
                    kiemTraMatKhau();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);
    }

    // ================== NHẬP THÔNG TIN ==================
    static void nhapThongTin(Scanner sc) {
        System.out.print("Nhập họ và tên: ");
        hoTen = sc.nextLine();

        System.out.print("Nhập email: ");
        email = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        sdt = sc.nextLine();

        System.out.print("Nhập mật khẩu: ");
        matKhau = sc.nextLine();
    }

    // ================== CHUẨN HÓA HỌ TÊN ==================
    static void chuanHoaHoTen() {
        if (hoTen.isEmpty()) {
            System.out.println("Chưa nhập họ tên!");
            return;
        }

        hoTen = hoTen.trim().toLowerCase();
        String[] tu = hoTen.split("\\s+");
        StringBuilder ketQua = new StringBuilder();

        for (String t : tu) {
            ketQua.append(Character.toUpperCase(t.charAt(0)))
                    .append(t.substring(1))
                    .append(" ");
        }

        hoTen = ketQua.toString().trim();
        System.out.println("Họ tên sau chuẩn hóa: " + hoTen);
    }

    // ================== KIỂM TRA EMAIL ==================
    static void kiemTraEmail() {
        String regexEmail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

        if (Pattern.matches(regexEmail, email)) {
            System.out.println("Email hợp lệ.");
        } else {
            System.out.println("Email KHÔNG hợp lệ.");
        }
    }

    // ================== KIỂM TRA SỐ ĐIỆN THOẠI ==================
    static void kiemTraSoDienThoai() {
        // SĐT di động VN: 03,05,07,08,09 + 8 số
        String regexSDT = "^(03|05|07|08|09)\\d{8}$";

        if (Pattern.matches(regexSDT, sdt)) {
            System.out.println("Số điện thoại hợp lệ.");
        } else {
            System.out.println("Số điện thoại KHÔNG hợp lệ.");
        }
    }

    // ================== KIỂM TRA MẬT KHẨU ==================
    static void kiemTraMatKhau() {
        // Ít nhất 8 ký tự, có chữ hoa, chữ thường, số, ký tự đặc biệt
        String regexMatKhau = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!^&*]).{8,}$";

        if (Pattern.matches(regexMatKhau, matKhau)) {
            System.out.println("Mật khẩu hợp lệ.");
        } else {
            System.out.println("Mật khẩu KHÔNG hợp lệ.");
        }
    }
}
