import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ss11bt3 {

    // Class Message
    static class Message {
        private String sender;
        private String content;
        private LocalDateTime timestamp;

        public Message(String sender, String content, LocalDateTime timestamp) {
            this.sender = sender;
            this.content = content;
            this.timestamp = timestamp;
        }

        public String getSender() {
            return sender;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "[" + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    + "] " + sender + ": " + content;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== CHAT MENU =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem toàn bộ lịch sử");
            System.out.println("3. Lọc tin nhắn theo người gửi");
            System.out.println("4. Lọc tin nhắn theo ngày (yyyy-MM-dd)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập tên người gửi: ");
                    String sender = sc.nextLine();

                    System.out.print("Nhập nội dung: ");
                    String content = sc.nextLine();

                    messages.add(new Message(sender, content, LocalDateTime.now()));
                    System.out.println("Đã gửi tin nhắn!");
                    break;

                case 2:
                    System.out.println("=== LỊCH SỬ CHAT ===");
                    messages.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Nhập tên người cần lọc: ");
                    String filterSender = sc.nextLine();

                    List<Message> filteredBySender = messages.stream()
                            .filter(m -> m.getSender().equalsIgnoreCase(filterSender))
                            .collect(Collectors.toList());

                    filteredBySender.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Nhập ngày (yyyy-MM-dd): ");
                    String dateInput = sc.nextLine();

                    try {
                        LocalDate date = LocalDate.parse(dateInput);

                        List<Message> filteredByDate = messages.stream()
                                .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                                .collect(Collectors.toList());

                        filteredByDate.forEach(System.out::println);

                    } catch (DateTimeParseException e) {
                        System.out.println("Sai định dạng ngày! Phải nhập yyyy-MM-dd");
                    }

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