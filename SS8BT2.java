import java.util.ArrayList;

// ===== LỚP TRỪU TƯỢNG =====
abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Phương thức trừu tượng
    public abstract void displayInfo();

    // Phương thức thường
    public void start() {
        System.out.println("Vehicle is starting...");
    }
}

// ===== LỚP CAR =====
class Car extends Vehicle {

    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Name: " + name + ", Speed: " + speed + " km/h");
    }
}

// ===== LỚP BIKE =====
class Bike extends Vehicle {

    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike Name: " + name + ", Speed: " + speed + " km/h");
    }
}

// ===== MAIN =====
public class SS8BT2 {
    public static void main(String[] args) {

        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Honda", 80);

        car.start();
        car.displayInfo();
        System.out.println();

        bike.start();
        bike.displayInfo();
    }
}
