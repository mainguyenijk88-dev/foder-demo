import java.util.Scanner;

// ===== CLASS CATEGORY =====
class Category {
    private int id;
    private String name;
    private String description;

    // Constructor rỗng
    public Category() {
    }

    // Constructor full
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Description: " + description);
    }
}

// ===== INTERFACE ICRUD =====
interface ICRUD {
    Category[] findAll();
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteById(int id);
}

// ===== CATEGORY MANAGEMENT =====
class CategoryManagement implements ICRUD {

    private Category[] categories = new Category[100];
    private int size = 0;

    @Override
    public Category[] findAll() {
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        if (size < categories.length) {
            categories[size++] = category;
            System.out.println("Thêm thành công!");
        }
    }

    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < size; i++) {
            if (categories[i].getId() == category.getId()) {
                categories[i] = category;
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy ID!");
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < size; i++) {
            if (categories[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    categories[j] = categories[j + 1];
                }
                categories[--size] = null;
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy ID!");
    }

    public int getSize() {
        return size;
    }
}

// ===== MAIN CLASS =====
public class SS8BT5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CategoryManagement manager = new CategoryManagement();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm danh mục");
            System.out.println("2. Hiển thị danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập Name: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập Description: ");
                    String des = sc.nextLine();
                    manager.addCategory(new Category(id, name, des));
                    break;

                case 2:
                    Category[] list = manager.findAll();
                    for (int i = 0; i < manager.getSize(); i++) {
                        list[i].display();
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần cập nhật: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập Name mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhập Description mới: ");
                    String newDes = sc.nextLine();
                    manager.updateCategory(new Category(updateId, newName, newDes));
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    manager.deleteById(deleteId);
                    break;

                case 5:
                    System.out.println("Thoát chương trình!");
                    break;
            }

        } while (choice != 5);
    }
}
