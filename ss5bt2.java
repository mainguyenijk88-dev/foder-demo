public class ss5bt2 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello, Java World!");

        System.out.println("Chuỗi ban đầu: " + str);
        str.delete(5, 10);

        System.out.println("Chuỗi sau khi xóa: " + str);

        int start = str.indexOf("World");
        int end = start + "World".length();

        str.replace(start, end, "Universe");

        System.out.println("Chuỗi sau khi thay thế: " + str);
    }
}
