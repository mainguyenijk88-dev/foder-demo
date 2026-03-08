import java.util.*;

class ProductItem {
    private static int autoId = 1;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public ProductItem() {
        this.productId = autoId++;
    }

    public ProductItem(String productName, float price, String category, int quantity) {
        this.productId = autoId++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.length() >= 10 && productName.length() <= 50) {
            this.productName = productName;
        } else {
            System.out.println("Tên sản phẩm phải từ 10-50 ký tự");
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Giá phải > 0");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category.length() <= 200) {
            this.category = category;
        } else {
            System.out.println("Category tối đa 200 ký tự");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Số lượng phải >=0");
        }
    }

    public void inputData(Scanner scanner) {

        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50) {
                this.productName = name;
                break;
            } else {
                System.out.println("Tên phải 10-50 ký tự");
            }
        }

        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                this.price = price;
                break;
            } else {
                System.out.println("Giá phải >0");
            }
        }

        while (true) {
            System.out.print("Nhập loại sản phẩm: ");
            String category = scanner.nextLine();
            if (category.length() <= 200) {
                this.category = category;
                break;
            } else {
                System.out.println("Category tối đa 200 ký tự");
            }
        }

        while (true) {
            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity >= 0) {
                this.quantity = quantity;
                break;
            } else {
                System.out.println("Số lượng phải >=0");
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                " | Name: " + productName +
                " | Price: " + price +
                " | Category: " + category +
                " | Quantity: " + quantity;
    }
}

class ProductBusiness {

    static ArrayList<ProductItem> listProducts = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        ProductItem p = new ProductItem();
        p.inputData(scanner);
        listProducts.add(p);
        System.out.println("Thêm sản phẩm thành công");
    }

    public static void displayProducts() {
        if (listProducts.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        for (ProductItem p : listProducts) {
            System.out.println(p);
        }
    }

    public static void updateProduct(Scanner scanner) {

        System.out.print("Nhập ID cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (ProductItem p : listProducts) {

            if (p.getProductId() == id) {

                System.out.print("Nhập tên mới: ");
                p.setProductName(scanner.nextLine());

                System.out.print("Nhập giá mới: ");
                p.setPrice(Float.parseFloat(scanner.nextLine()));

                System.out.print("Nhập category mới: ");
                p.setCategory(scanner.nextLine());

                System.out.print("Nhập số lượng mới: ");
                p.setQuantity(Integer.parseInt(scanner.nextLine()));

                System.out.println("Cập nhật thành công");
                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm");
    }

    public static void deleteProduct(Scanner scanner) {

        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Iterator<ProductItem> iterator = listProducts.iterator();

        while (iterator.hasNext()) {
            ProductItem p = iterator.next();
            if (p.getProductId() == id) {
                iterator.remove();
                System.out.println("Xóa thành công");
                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm");
    }

    public static void searchProduct(Scanner scanner) {

        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().toLowerCase();

        for (ProductItem p : listProducts) {
            if (p.getProductName().toLowerCase().contains(keyword)) {
                System.out.println(p);
            }
        }
    }

    public static void sortPrice() {

        listProducts.sort(Comparator.comparing(ProductItem::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng dần");
    }

    public static void sortQuantity() {

        listProducts.sort((p1, p2) -> p2.getQuantity() - p1.getQuantity());
        System.out.println("Đã sắp xếp theo số lượng giảm dần");
    }
}

public class ss12bt1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n*********** QUẢN LÝ SẢN PHẨM ***********");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo mã");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp theo giá tăng");
            System.out.println("7. Sắp xếp theo số lượng giảm");
            System.out.println("8. Thoát");

            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    ProductBusiness.addProduct(scanner);
                    break;

                case 2:
                    ProductBusiness.displayProducts();
                    break;

                case 3:
                    ProductBusiness.updateProduct(scanner);
                    break;

                case 4:
                    ProductBusiness.deleteProduct(scanner);
                    break;

                case 5:
                    ProductBusiness.searchProduct(scanner);
                    break;

                case 6:
                    ProductBusiness.sortPrice();
                    break;

                case 7:
                    ProductBusiness.sortQuantity();
                    break;

                case 8:
                    System.out.println("Thoát chương trình");
                    System.exit(0);

                default:
                    System.out.println("Vui lòng chọn 1-8");
            }
        }
    }
}