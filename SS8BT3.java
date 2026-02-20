// ===== INTERFACE =====
interface Colorable {
    void setColor(String color);
}

// ===== LỚP CIRCLE =====
class Circle implements Colorable {

    private String color;


    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Circle Color: " + color);
    }
}

// ===== LỚP RECTANGLE =====
class Rectangle implements Colorable {

    private String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Rectangle Color: " + color);
    }
}

// ===== LỚP SQUARE =====
class Square implements Colorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Square Color: " + color);
    }
}

// ===== MAIN =====
public class SS8BT3 {
    public static void main(String[] args) {

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square(3);

        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        circle.displayInfo();
        rectangle.displayInfo();
        square.displayInfo();
    }
}
