import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ss11bt4 {

    // Class Product
    static class Product {
        private String id;
        private String name;
        private double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Price: " + price;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Product> products = new HashMap<>();
        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Lọc sản phẩm giá > 100");
            System.out.println("6. Tính tổng giá trị sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();

                    if (products.containsKey(id)) {
                        System.out.println("ID đã tồn tại!");
                        break;
                    }

                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(sc.nextLine());

                    products.put(id, new Product(id, name, price));
                    System.out.println("Đã thêm sản phẩm!");
                    break;

                case 2:
                    System.out.print("Nhập ID cần sửa: ");
                    String editId = sc.nextLine();

                    if (products.containsKey(editId)) {
                        Product p = products.get(editId);

                        System.out.print("Nhập tên mới: ");
                        p.setName(sc.nextLine());

                        System.out.print("Nhập giá mới: ");
                        p.setPrice(Double.parseDouble(sc.nextLine()));

                        System.out.println("Đã cập nhật!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    String deleteId = sc.nextLine();

                    if (products.remove(deleteId) != null) {
                        System.out.println("Đã xóa sản phẩm!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;

                case 4:
                    System.out.println("=== DANH SÁCH SẢN PHẨM ===");
                    products.values().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("=== SẢN PHẨM GIÁ > 100 ===");
                    products.values().stream()
                            .filter(p -> p.getPrice() > 100)
                            .forEach(System.out::println);
                    break;

                case 6:
                    double total = products.values().stream()
                            .mapToDouble(Product::getPrice)
                            .sum();

                    System.out.println("Tổng giá trị sản phẩm: " + total);
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}