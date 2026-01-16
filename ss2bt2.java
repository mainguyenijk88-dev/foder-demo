import java.util.Scanner;

public class ss2bt2 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("hay nhap vao ngay trong tuan (1-7)");
        int Date = sc.nextInt();
        switch(Date){
            case 1:
                System.out.println("Chủ nhật");
                break;
            case 2:
                System.out.println("thu hai");
                break;
            case 3:
                System.out.println("thu ba");
                break;
            case 4:
                System.out.println("thu tu");
                break;
            case 5:
                System.out.println("thu 5");
                break;
            case 6:
                System.out.println("thu 6");
                break;
            case 7:
                System.out.println("thu 7");
                break;
            default:
                System.out.println("Số nhập vào không hợp lệ");
                break;

        }
    }
}
