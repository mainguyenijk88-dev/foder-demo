import java.util.Scanner;

public class ss5bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chuỗi
        System.out.print("Nhập chuỗi: ");
        String text = sc.nextLine();

        // Nhập từ cần tìm
        System.out.print("Nhập từ cần tìm: ");
        String word = sc.nextLine();

        // Tìm không phân biệt hoa thường
        int position = text.toLowerCase().indexOf(word.toLowerCase());

        if (position != -1) {
            System.out.println(
                    "Từ \"" + word + "\" xuất hiện tại vị trí " + position + " trong chuỗi."
            );
        } else {
            System.out.println(
                    "Không tìm thấy từ \"" + word + "\" trong chuỗi."
            );
        }

        sc.close();
    }
}
