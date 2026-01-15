package Session1;

import java.util.Scanner;

public class ss1bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap chieu cao cua hinh chu nhat:");
        double height= sc.nextDouble();
        System.out.println("nhap chieu rong cua hinh chu nhat:");
        double width = sc.nextDouble();
        double dienTich = height * width;
        double chuVi = 2*(height+width);
        System.out.printf("chieu cao: %.2f va chieu rong: %.2f%n", height, width);
        System.out.printf("chu Vi : %.2f va dien tich : %.2f", chuVi, dienTich);

    }
}
