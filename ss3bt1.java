import java.util.Scanner;
public class ss3bt1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap ten khach hang");
        String customerName = sc.nextLine();

        System.out.println("nhap ten san pham");
        String productName = sc.nextLine();

        System.out.println("nhap gia san pham");
        double price = sc.nextDouble();

        System.out.println("nhap so luong mua");
        int quantity = sc.nextInt();

        System.out.println("khach co the thanh vien (true/false):")    ;
        boolean isMember = sc.nextBoolean();

        double thanhTien = price * quantity;

        double giamGia = 0;
        if (isMember) {
            giamGia = thanhTien * 0.10;
        }

        double vat = (thanhTien - giamGia)*0.08;

        double tongThanhToan =thanhTien - giamGia + vat;

        System.out.println("\n===== HOA DON =====");
        System.out.println("Khach Hang: " + customerName);
        System.out.println("San pham: " + productName);
        System.out.println("so luong mua: " + quantity);
        System.out.println("Don gia:" + price + "VND");
        System.out.println("Thanh Tien: " + thanhTien + "VND");
        System.out.println("giam gia: " + giamGia + "VND");
        System.out.println("tien VAT (8%): " + vat + "VND");
        System.out.println("tong thanh toan: " + tongThanhToan + "VND");
    }
}
