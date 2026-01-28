
import java.util.Scanner;
public class ss4bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhap kich thuoc mang
        System.out.print("nhap kich thuoc mang");
        int n = sc.nextInt();
        int [] a = new int [n];

        // nhap cac phan tu
        System.out.println("nhap cac phan tu cho mang");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
//sap xep giam dan
        for (int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if (a[i] < a[j]){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
                }
            }
        }
        // in mang sau khi sap xep
        System.out.print("mang sau khi sap xep thu tu giam dan: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        // phan tu lon nhat
        System.out.println("\n phan tu lon nhat trong mang la: " + a[0]);
    }
}
