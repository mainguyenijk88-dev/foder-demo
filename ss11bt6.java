import java.util.ArrayList;
import java.util.List;

public class ss11bt6 {

    // ===== Product =====
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + "}";
        }
    }

    // ===== Interface =====
    interface ProductProcessor {

        double calculateTotalValue(List<Product> products);

        static void printProductList(List<Product> products) {
            System.out.println("Danh sách sản phẩm:");
            for (Product p : products) {
                System.out.println(p);
            }
        }

        default boolean hasExpensiveProduct(List<Product> products) {
            return products.stream().anyMatch(p -> p.getPrice() > 100);
        }
    }

    // ===== Implementation =====
    static class ProductProcessorImpl implements ProductProcessor {

        @Override
        public double calculateTotalValue(List<Product> products) {
            return products.stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        }
    }

    // ===== Main =====
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 50));
        products.add(new Product("Keyboard", 80));
        products.add(new Product("Monitor", 300));
        products.add(new Product("USB", 20));

        ProductProcessor processor = new ProductProcessorImpl();

        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Các sản phẩm có giá > 100:");
            products.stream()
                    .filter(p -> p.getPrice() > 100)
                    .forEach(System.out::println);
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        double total = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị sản phẩm: " + total);

        ProductProcessor.printProductList(products);
    }
}