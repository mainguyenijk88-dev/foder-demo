public class ss7bt1 {

    // thuộc tính
    double chieuDai;
    double chieuRong;

    // constructor mặc định
    ss7bt1() {
        chieuDai = 1;
        chieuRong = 1;
    }

    // constructor có tham số
    ss7bt1(double l, double w) {
        chieuDai = l;
        chieuRong = w;
    }

    // tính diện tích
    double getArea() {
        return chieuDai * chieuRong;
    }

    // tính chu vi
    double getPerimeter() {
        return 2 * (chieuDai + chieuRong);
    }

    // hiển thị thông tin
    void display() {
        System.out.println("Chieu dai: " + chieuDai);
        System.out.println("chieu rong: " + chieuRong);
        System.out.println("dien tich: " + getArea());
        System.out.println("chu vi: " + getPerimeter());
        System.out.println("-------------------");
    }

    // main method
    public static void main(String[] args) {

        // đối tượng mặc định
        ss7bt1 r1 = new ss7bt1();
        System.out.println("hinh chu nhat 1:");
        r1.display();

        // đối tượng có tham số
        ss7bt1 r2 = new ss7bt1(5, 3);
        System.out.println("hinh chu nhat 2:");
        r2.display();
    }
}
