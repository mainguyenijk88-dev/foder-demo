import java.util.Scanner;

public class ss2bt3 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("moi ban nhap vao 1 so nguyen duong");
        number = sc.nextInt();
        int sum = 0;
        for(int i =1;i<=number;i++ ){
            sum = sum + i;
        }if(number > 0){
        System.out.printf("tong cac so tu 1 den %d la: %d", number, sum );
    }else if(number < 0){
            System.out.println("so nhap vao ko hop le");
        }else {
            System.out.println("nhap vao ko hop le");
        }
}
}
