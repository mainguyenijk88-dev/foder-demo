import java.util.Scanner;

public class ss2bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhap so nguyen n
        System.out.println("hay nhap so ban muon tinh tong");
        int n = sc.nextInt();
        // neu n la so am chuyen -> duong
        n = Math.abs(n);
        int sum = 0;
        // tach tung so roi cong lai
       while (n > 0){
//           int kh = n%10;
           int digit = n % 10;
           sum  += digit;
           n = n/10;
           // in ket qua
           System.out.printf("tong cac chu so la: %d ", + sum);
           sc.close();

        }
    }
}
