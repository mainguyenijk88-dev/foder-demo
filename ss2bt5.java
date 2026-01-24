import java.util.Scanner;

public class ss2bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hay nhap vao so thang trong nam (1-12)");
        int month = sc.nextInt();

        switch (month) {
            case 1:
                System.out.println("thang 1 co 31 ngay");
                break;
            case 2:
                System.out.println("thang 1 co 28 or 29 ngay");
                break;
            case 3:
                System.out.println("thang 1 co 31 ngay");
                break;
            case 4:
                System.out.println("thang 1 co 30 ngay");
                break;
            case 5:
                System.out.println("thang 1 co 31 ngay");
                break;
            case 6:
                System.out.println("thang 1 co 30 ngay");
                break;
            case 7:
                System.out.println("thang 1 co 31 ngay");
                break;
            case 8:
                System.out.println("thang 1 co 31 ngay");
                break;
            case 9:
                System.out.println("thang 1 co 30 ngay");
                break;
            case 10:
                System.out.println("thang 1 co 31 ngay");
                break;
            case 11:
                System.out.println("thang 1 co 30 ngay");
                break;
            case 12:
                System.out.println("thang 1 co 31 ngay");
                break;
            default:
                System.out.println("Tháng không hợp lệ !");
                break;
        }
    }
}
