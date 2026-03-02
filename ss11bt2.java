import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ss11bt2 {

    // Đặt Student bên trong class chính → KHÔNG BAO GIỜ lỗi trùng class
    static class Student {
        private String name;
        private int age;
        private double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return name + " - Age: " + age + " - Grade: " + grade;
        }
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("An", 20, 8.5));
        students.add(new Student("Binh", 22, 6.8));
        students.add(new Student("Chi", 19, 7.5));
        students.add(new Student("Dung", 21, 9.0));
        students.add(new Student("Em", 20, 5.5));
        students.add(new Student("Hanh", 23, 7.8));
        students.add(new Student("Khanh", 20, 8.0));
        students.add(new Student("Linh", 21, 6.0));
        students.add(new Student("Mai", 19, 8.9));
        students.add(new Student("Nam", 22, 7.2));

        List<Student> result = students.stream()
                .filter(s -> s.getGrade() > 7.0)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("Danh sách sinh viên có điểm > 7.0 sau khi sắp xếp:");
        result.forEach(System.out::println);
    }
}