import java.util.Scanner;

public class ss5bt6 {
    public static void main(String[] args) {

        // 1. Tạo Scanner để nhập dữ liệu
        Scanner sc = new Scanner(System.in);

        // 2. Nhập mật khẩu
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

        // 3. Biểu thức chính quy kiểm tra mật khẩu
        String passwordRegex =
                "^(?=.*[a-z])" +      // ít nhất 1 chữ thường
                        "(?=.*[A-Z])" +       // ít nhất 1 chữ hoa
                        "(?=.*\\d)" +         // ít nhất 1 chữ số
                        "(?=.*[@#$%^&+=!])" + // ít nhất 1 ký tự đặc biệt
                        ".{8,}$";              // tối thiểu 8 ký tự

        // 4. Kiểm tra mật khẩu
        if (password.matches(passwordRegex)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }

        // 5. Đóng Scanner
        sc.close();
    }
}
