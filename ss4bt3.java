import java.util.Arrays;
import java.util.Scanner;
public class ss4bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhap kich thuoc mang
        System.out.println("nhap so phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine());// sd nextLine de ep kieu ve so
        int [] arr = new int[n];
        // nhap cac phan tu cua mang
            for(int i=0;i<n;i++){
                System.out.println("nhap phan tu thu " +i + ": ");
                arr[i] = sc.nextInt();
            }
            // thuat toan sap xep noi bot giam dan
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // in mang sau khi sap xep
        System.out.println("mang sau khi sap xep giam dan: ");
        for(int i=0;i<n;i++){

            System.out.println(arr[i]+" ");
        }
        System.out.println(Arrays.toString(arr));// cach in ra 1 mang co ngoac []
    }
}
