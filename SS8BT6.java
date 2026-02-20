import java.util.Scanner;

// ===== CLASS BOOK =====
class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getDetails() {
        return "Title: " + title +
                " | Author: " + author +
                " | ISBN: " + isbn +
                " | Year: " + year;
    }

    public String getIsbn() {
        return isbn;
    }
}

// ===== INTERFACE IBOOKMANAGER =====
interface IBookManager {
    void addBook(Book book);
    void removeBook(String isbn);
    void displayBooks();
}

// ===== CLASS BOOK MANAGER =====
class BookManager implements IBookManager {

    private Book[] books = new Book[100];
    private int size = 0;

    @Override
    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
            System.out.println("Thêm sách thành công!");
        }
    }

    @Override
    public void removeBook(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < size - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--size] = null;
                System.out.println("Xóa sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }

    @Override
    public void displayBooks() {
        if (size == 0) {
            System.out.println("Danh sách sách trống!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(books[i].getDetails());
        }
    }
}

// ===== MAIN CLASS =====
public class SS8BT6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tiêu đề: ");
                    String title = sc.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = sc.nextLine();
                    System.out.print("Nhập ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int year = Integer.parseInt(sc.nextLine());

                    manager.addBook(new Book(title, author, isbn, year));
                    break;

                case 2:
                    System.out.print("Nhập ISBN cần xóa: ");
                    String removeIsbn = sc.nextLine();
                    manager.removeBook(removeIsbn);
                    break;

                case 3:
                    manager.displayBooks();
                    break;

                case 4:
                    System.out.println("Thoát chương trình!");
                    break;
            }

        } while (choice != 4);
    }
}
