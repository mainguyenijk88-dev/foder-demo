package Session1;
import java.util.Scanner;
public class ss1bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// cho ng dung nhap vao giong nhu prompt
        System.out.print("Nhap vao ban kinh r:");
        String ketqua = "ket qua";
        int r = sc.nextInt();
        float PI = 3.14f;
        float A = PI * r * r;
        System.out.printf(" %s A voi r la %d = %f" ,ketqua,r, A);

    }
}
