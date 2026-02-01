import java.util.Arrays;
import java.util.Scanner;
public class ss4bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap kich thuoc mang: ");
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("kich thuoc rong");
            return;
        }
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        System.out.println("nhap phan tu arr["+ i + "]: ");
        arr[i] = sc.nextInt();
    }
        System.out.println("mang ban dau: ");
    for(int i=0;i<n;i++){
        System.out.println(arr[i]+" ");
    }
    for(int i=0;i<n/2;i++){
int temp=arr[i];
arr[i]=arr[n-i-1];
arr[n-i-1]=temp;
    }
        System.out.println("mang sau khi dao nguoc: ");
    for(int i=0;i<n;i++){
        System.out.println(arr[i]+" ");
    }
        System.out.println(Arrays.toString(arr));
    }
}
