package Session1;
import java.util.Scanner;
public class ss1bt5 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Nhập phân số thứ nhất
            System.out.print("Nhap tu so phan so 1: ");
            int a = sc.nextInt();
            System.out.print("Nhap mau so phan so 1: ");
            int b = sc.nextInt();

            // Nhập phân số thứ hai
            System.out.print("Nhap tu so phan so 2: ");
            int c = sc.nextInt();
            System.out.print("Nhap mau so phan so 2: ");
            int d = sc.nextInt();

            // Tính tổng hai phân số
            int tuSo = a * d + b * c;
            int mauSo = b * d;

            // In kết quả
            System.out.println("Ket qua: " + tuSo + "/" + mauSo);
        }


}
