public class ss7bt2 {

    // Lớp Book đặt bên trong (không public)
    static class Book {

        // Thuộc tính private
        private String title;
        private String author;
        private double price;

        // Constructor
        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            setPrice(price); // dùng setter để kiểm tra
        }

        // Getter & Setter cho title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // Getter & Setter cho author
        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        // Getter cho price
        public double getPrice() {
            return price;
        }

        // Setter cho price (kiểm tra không âm)
        public void setPrice(double price) {
            if (price >= 0) {
                this.price = price;
            } else {
                System.out.println("Gia khong duoc am.");
            }
        }
    }

    // Hàm main để kiểm thử
    public static void main(String[] args) {

        // Tạo đối tượng Book
        Book book1 = new Book("Java Programing", "John Doe", 29.99);

        // In thông tin
        System.out.println("Tieu de: " + book1.getTitle());
        System.out.println("Tac gia: " + book1.getAuthor());
        System.out.println("Gia: " + book1.getPrice());

        // Thay đổi giá hợp lệ
        book1.setPrice(35.50);
        System.out.println("Gia moi: " + book1.getPrice());

        // Thay đổi giá không hợp lệ
        book1.setPrice(-5.00);
        System.out.println("Gia ko duoc am" );
    }
}
