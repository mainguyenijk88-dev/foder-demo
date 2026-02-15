import java.util.ArrayList;
import java.util.Scanner;

public class ss7bt4 {

    // Lớp Student
    static class Student {
        private String name;
        private int age;
        private String className;
        private double avgScore;

        // Constructor
        public Student(String name, int age, String className, double avgScore) {
            this.name = name;
            this.age = age;
            this.className = className;
            this.avgScore = avgScore;
        }

        // Getter
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getClassName() {
            return className;
        }

        public double getAvgScore() {
            return avgScore;
        }

        // Hiển thị thông tin
        public void display() {
            System.out.println("Ten: " + name +
                    " Tuoi: " + age +
                    " Lop: " + className +
                    " Diem trung binh: " + avgScore);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Tạo danh sách sinh viên có sẵn
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("An", 20, "IT1", 7.5));
        list.add(new Student("Binh", 21, "IT2", 8.2));
        list.add(new Student("Chi", 19, "IT1", 6.8));
        list.add(new Student("Dung", 22, "IT3", 9.0));
        list.add(new Student("Hoa", 20, "IT2", 5.5));

        // Nhập min và max
        System.out.println("Nhap diem min:");
        double min = sc.nextDouble();

        System.out.println("Nhap diem max:");
        double max = sc.nextDouble();

        System.out.println("\nDanh sach sinh vien co diem trong khoang:");

        boolean found = false;

        // Lọc sinh viên
        for (Student s : list) {
            if (s.getAvgScore() >= min && s.getAvgScore() <= max) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co sinh vien nao trong khoang diem nay.");
        }

        sc.close();
    }
}
