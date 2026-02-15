import java.util.ArrayList;
import java.util.Scanner;

public class ss7bt5 {

    // Lớp Product
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

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            if (price >= 0) {
                this.price = price;
            } else {
                System.out.println("Gia khong hop le!");
            }
        }

        public void display() {
            System.out.println("ID: " + id +
                    " | Name: " + name +
                    " | Price: " + price);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Cap nhat san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = sc.nextInt();
            sc.nextLine(); // tránh lỗi trôi dòng

            switch (choice) {

                case 1:
                    // Thêm sản phẩm
                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nhap Name: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    list.add(new Product(id, name, price));
                    System.out.println("Them thanh cong!");
                    break;

                case 2:
                    // Hiển thị danh sách
                    if (list.isEmpty()) {
                        System.out.println("Danh sach rong!");
                    } else {
                        for (Product p : list) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    // Cập nhật sản phẩm
                    System.out.print("Nhap ID can cap nhat: ");
                    String updateId = sc.nextLine();
                    boolean foundUpdate = false;

                    for (Product p : list) {
                        if (p.getId().equals(updateId)) {
                            System.out.print("Nhap name moi: ");
                            String newName = sc.nextLine();

                            System.out.print("Nhap price moi: ");
                            double newPrice = sc.nextDouble();
                            sc.nextLine();

                            p.setName(newName);
                            p.setPrice(newPrice);

                            System.out.println("Cap nhat thanh cong!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;

                case 4:
                    // Xóa sản phẩm
                    System.out.print("Nhap ID can xoa: ");
                    String deleteId = sc.nextLine();
                    boolean foundDelete = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getId().equals(deleteId)) {
                            list.remove(i);
                            System.out.println("Xoa thanh cong!");
                            foundDelete = true;
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;

                case 5:
                    System.out.println("Thoat chuong trinh.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
