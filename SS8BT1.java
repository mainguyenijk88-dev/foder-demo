import java.util.ArrayList;

public class SS8BT1 {

    // LỚP CHA
    static class Animals {
        private String name;
        private int age;

        public Animals(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void displayInfo() {
            System.out.println("Tên: " + name + ", Tuổi: " + age);
        }

        public void makeSound() {
            System.out.println("Âm thanh: ...");
        }
    }

    // LỚP DOG
    static class Dog extends Animals {
        private String breed;

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Giống chó: " + breed);
        }

        @Override
        public void makeSound() {
            System.out.println("Âm thanh: Woof Woof");
        }
    }

    // LỚP CAT
    static class Cat extends Animals {
        private String furColor;

        public Cat(String name, int age, String furColor) {
            super(name, age);
            this.furColor = furColor;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Màu lông: " + furColor);
        }

        @Override
        public void makeSound() {
            System.out.println("Âm thanh: Meow Meow");
        }
    }

    // MAIN
    public static void main(String[] args) {

        ArrayList<Animals> list = new ArrayList<>();

        list.add(new Dog("Buddy", 3, "Golden Retriever"));
        list.add(new Cat("Whiskers", 2, "Ghi"));

        for (Animals animal : list) {
            animal.displayInfo();
            animal.makeSound();
            System.out.println();
        }
    }
}
