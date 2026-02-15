import java.util.ArrayList;
import java.util.Scanner;

public class ss7bt6 {

    // Lớp Category
    static class Category {
        private String id;
        private String name;
        private String description;

        public Category(String id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Category> list = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them danh muc");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Cap nhat danh muc");
            System.out.println("4. Xoa danh muc");
            System.out.println("5. Tim kiem theo ten");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = sc.nextInt();
            sc.nextLine(); // tránh lỗi trôi dòng

            switch (choice) {

                case 1:
                    // Thêm mới
                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nhap Name: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap Description: ");
                    String description = sc.nextLine();

                    list.add(new Category(id, name, description));
                    System.out.println("Them thanh cong!");
                    break;

                case 2:
                    // Hiển thị
                    if (list.isEmpty()) {
                        System.out.println("Danh sach rong!");
                    } else {
                        for (Category c : list) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    // Cập nhật
                    System.out.print("Nhap ID can cap nhat: ");
                    String updateId = sc.nextLine();
                    boolean foundUpdate = false;

                    for (Category c : list) {
                        if (c.getId().equals(updateId)) {
                            System.out.print("Nhap name moi: ");
                            String newName = sc.nextLine();

                            System.out.print("Nhap description moi: ");
                            String newDesc = sc.nextLine();

                            c.setName(newName);
                            c.setDescription(newDesc);

                            System.out.println("Cap nhat thanh cong!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Khong tim thay danh muc!");
                    }
                    break;

                case 4:
                    // Xóa
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
                        System.out.println("Khong tim thay danh muc!");
                    }
                    break;

                case 5:
                    // Tìm kiếm theo tên
                    System.out.print("Nhap ten can tim: ");
                    String searchName = sc.nextLine();
                    boolean foundSearch = false;

                    for (Category c : list) {
                        if (c.getName().toLowerCase().contains(searchName.toLowerCase())) {
                            c.display();
                            foundSearch = true;
                        }
                    }

                    if (!foundSearch) {
                        System.out.println("Khong tim thay danh muc phu hop!");
                    }
                    break;

                case 6:
                    System.out.println("Thoat chuong trinh.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
