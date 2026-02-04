import java.util.Scanner;

public class SS5BT3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        String result = input.replaceAll("\\d", "*");

        System.out.println("Chuỗi sau khi thay thế: " + result);

        sc.close();
    }
}
