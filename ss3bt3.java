import java.util.ArrayList;
import java.util.Scanner;

public class ss3bt3 {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Long> salaries = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("***************MENU NHẬP LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputSalary();
                    break;
                case 2:
                    showStatistics();
                    break;
                case 3:
                    calculateBonus();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    static void inputSalary() {
        System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");

        while (true) {
            System.out.print("Nhập lương: ");
            long salary = scanner.nextLong();

            if (salary == -1) {
                break;
            }

            if (salary < 0 || salary > 500_000_000) {
                System.out.println("Lương không hợp lệ. Nhập lại.");
                continue;
            }

            salaries.add(salary);

            if (salary < 5_000_000) {
                System.out.println("→ Thu nhập thấp");
            } else if (salary <= 15_000_000) {
                System.out.println("→ Thu nhập trung bình");
            } else if (salary <= 50_000_000) {
                System.out.println("→ Thu nhập khá");
            } else {
                System.out.println("→ Thu nhập cao");
            }
        }
    }

    static void showStatistics() {
        if (salaries.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }

        int count = salaries.size();
        long total = 0;
        long max = salaries.get(0);
        long min = salaries.get(0);

        for (long s : salaries) {
            total += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }

        double average = (double) total / count;

        System.out.println("Số nhân viên: " + count);
        System.out.println("Lương trung bình: " + average);
        System.out.println("Lương cao nhất: " + max);
        System.out.println("Lương thấp nhất: " + min);
        System.out.println("Tổng tiền lương: " + total);
    }

    static void calculateBonus() {
        if (salaries.isEmpty()) {
            System.out.println("Chưa có dữ liệu để tính thưởng");
            return;
        }

        double totalBonus = 0;

        for (long salary : salaries) {
            if (salary < 5_000_000) {
                totalBonus += salary * 0.05;
            } else if (salary <= 15_000_000) {
                totalBonus += salary * 0.10;
            } else if (salary <= 50_000_000) {
                totalBonus += salary * 0.15;
            } else if (salary <= 100_000_000) {
                totalBonus += salary * 0.20;
            } else {
                totalBonus += salary * 0.25;
            }
        }

        System.out.println("Tổng tiền thưởng cho nhân viên: " +(long) + totalBonus +"vnd");
    }
}
