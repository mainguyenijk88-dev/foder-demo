import java.util.Arrays;
import java.util.List;

public class ss11bt1 {
    public static void main(String[] args) {

        // Tạo danh sách số nguyên
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);

        //  In ra tất cả số chẵn bằng Lambda Expression
        System.out.println("Danh sách số chẵn:");
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        //  Tính tổng tất cả các số bằng Lambda Expression
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Tổng tất cả các số là: " + sum);
    }
}