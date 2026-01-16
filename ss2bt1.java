import java.util.Scanner;

public class ss2bt1 {
    public static void main(String[] args) {
        int number;
        Scanner Sanner = new Scanner(System.in);
        System.out.println("moi ban nhap vao 1 so nguyen :");
        number = Sanner.nextInt();
        if (number == 0) {
            System.out.printf("so ban nhap %d ko chan cung ko le",number);
        } else if (number % 2 == 1) {
            System.out.println("so ban nhap"+number+ "la so le");
            System.out.printf("So ban nhap %d la so le",number);
        } else {
            System.out.printf("so ban nhap %d la so chan", number);

        }
    }
}
