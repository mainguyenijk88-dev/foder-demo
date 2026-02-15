import java.util.Scanner;

public class ss7bt3 {

    // Lớp Person
    static class Person {
        private String name;
        private int age;

        // Getter cho name
        public String getName() {
            return name;
        }

        // Setter cho name
        public void setName(String name) {
            this.name = name;
        }

        // Getter cho age
        public int getAge() {
            return age;
        }

        // Setter cho age
        public void setAge(int age) {
            if (age >= 0) {
                this.age = age;
            } else {
                System.out.println("Tuoi khong hop le!");
            }
        }
    }

    // Hàm main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Tạo 2 đối tượng Person
        Person p1 = new Person();
        Person p2 = new Person();

        // Nhập thông tin cho Person 1
        System.out.println("Nhap ten nguoi thu 1:");
        p1.setName(sc.nextLine());

        System.out.println("Nhap tuoi nguoi thu 1:");
        p1.setAge(sc.nextInt());
        sc.nextLine(); // tránh lỗi trôi dòng

        // Nhập thông tin cho Person 2
        System.out.println("Nhap ten nguoi thu 2:");
        p2.setName(sc.nextLine());

        System.out.println("Nhap tuoi nguoi thu 2:");
        p2.setAge(sc.nextInt());

        // So sánh tuổi
        if (p1.getAge() > p2.getAge()) {
            System.out.println(p1.getName() + " lon tuoi hon.");
        } else if (p1.getAge() < p2.getAge()) {
            System.out.println(p2.getName() + " lon tuoi hon " + p1.getName());
        } else {
            System.out.println("Hai nguoi bang tuoi nhau.");
        }

        sc.close();
    }
}
