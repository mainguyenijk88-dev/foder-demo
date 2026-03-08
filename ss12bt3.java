import java.util.*;

class Order {

    private static int autoId = 1;

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private String status;

    public Order() {
        this.orderId = autoId++;
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {

        while (true) {
            System.out.print("Nhập tên khách hàng (6-100 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 100) {
                this.customerName = name;
                break;
            }
            System.out.println("Tên không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine();
            if (phone.matches("^(03|05|07|08|09)\\d{8}$")) {
                this.phoneNumber = phone;
                break;
            }
            System.out.println("SĐT không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập địa chỉ: ");
            String addr = scanner.nextLine();
            if (!addr.trim().isEmpty()) {
                this.address = addr;
                break;
            }
            System.out.println("Địa chỉ không được trống!");
        }

        while (true) {
            try {
                System.out.print("Nhập giá trị đơn hàng: ");
                float amount = Float.parseFloat(scanner.nextLine());
                if (amount > 0) {
                    this.orderAmount = amount;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Phải nhập số!");
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + orderId +
                " | Name: " + customerName +
                " | Phone: " + phoneNumber +
                " | Address: " + address +
                " | Amount: " + orderAmount +
                " | Status: " + status;
    }
}

public class ss12bt3 {

    static List<Order> orders = new ArrayList<>();

    static Order findById(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) {
                return o;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("************* QUẢN LÝ ĐƠN HÀNG *************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Xóa đơn hàng");
            System.out.println("5. Tìm kiếm theo tên khách");
            System.out.println("6. Tổng số đơn hàng");
            System.out.println("7. Doanh thu đơn Delivered");
            System.out.println("8. Thống kê trạng thái");
            System.out.println("9. Đơn hàng giá trị lớn nhất");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    Order order = new Order();
                    order.inputData(scanner);
                    orders.add(order);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    orders.stream()
                            .sorted((o1, o2) -> Float.compare(o2.getOrderAmount(), o1.getOrderAmount()))
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Nhập mã đơn: ");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    Order o1 = findById(idUpdate);

                    if (o1 == null) {
                        System.out.println("Không tìm thấy!");
                        break;
                    }

                    if (o1.getStatus().equals("Pending")) {
                        o1.setStatus("Shipped");
                    } else if (o1.getStatus().equals("Shipped")) {
                        o1.setStatus("Delivered");
                    } else {
                        System.out.println("Đã giao xong!");
                        break;
                    }

                    System.out.println("Cập nhật thành công!");
                    break;

                case 4:
                    System.out.print("Nhập mã đơn cần xóa: ");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    Order o2 = findById(idDelete);

                    if (o2 == null) {
                        System.out.println("Không tìm thấy!");
                        break;
                    }

                    if (!o2.getStatus().equals("Pending")) {
                        System.out.println("Chỉ xóa đơn Pending!");
                        break;
                    }

                    orders.remove(o2);
                    System.out.println("Xóa thành công!");
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String name = scanner.nextLine().toLowerCase();

                    orders.stream()
                            .filter(o -> o.getCustomerName().toLowerCase().contains(name))
                            .forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Tổng đơn: " + orders.size());
                    break;

                case 7:
                    float sum = 0;
                    for (Order o : orders) {
                        if (o.getStatus().equals("Delivered")) {
                            sum += o.getOrderAmount();
                        }
                    }
                    System.out.println("Doanh thu Delivered: " + sum);
                    break;

                case 8:
                    int p = 0, s = 0, d = 0;

                    for (Order o : orders) {
                        switch (o.getStatus()) {
                            case "Pending": p++; break;
                            case "Shipped": s++; break;
                            case "Delivered": d++; break;
                        }
                    }

                    System.out.println("Pending: " + p);
                    System.out.println("Shipped: " + s);
                    System.out.println("Delivered: " + d);
                    break;

                case 9:
                    orders.stream()
                            .max(Comparator.comparing(Order::getOrderAmount))
                            .ifPresent(System.out::println);
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}