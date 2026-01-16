import java.util.Scanner;

public class ss2bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = -1; // khởi tạo để dùng cho do-while

        do {
            System.out.println("Nhap tuoi cua ban (so nguyen > 0):");

            if (sc.hasNextInt()) {
                age = sc.nextInt();

                if (age <= 0) {
                    System.err.println("Tuoi phai lon hon 0!");
                }
            } else {
                System.err.println("Vui long nhap so nguyen!");
                sc.next(); // xóa dữ liệu sai
            }

        } while (age <= 0);

        System.out.printf("Tuoi cua ban la: %d", age);
        sc.close();
    }
}
