import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ss11bt5 {

    static class Event {
        private String name;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return "Event{name='" + name + "', startDate="
                    + startDate.format(formatter)
                    + ", endDate="
                    + endDate.format(formatter) + "}";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Event> events = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        while (true) {

            System.out.println("Nhập tên sự kiện (hoặc 'exit' để thoát):");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (name.trim().isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            LocalDateTime startDate = null;
            LocalDateTime endDate = null;

            // Nhập start date
            while (true) {
                System.out.println("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm):");
                String startInput = sc.nextLine();
                try {
                    startDate = LocalDateTime.parse(startInput, formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            // Nhập end date
            while (true) {
                System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm):");
                String endInput = sc.nextLine();
                try {
                    endDate = LocalDateTime.parse(endInput, formatter);

                    if (endDate.isBefore(startDate)) {
                        System.out.println("End date must be after start date");
                        continue;
                    }

                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            events.add(new Event(name, startDate, endDate));
        }

        System.out.println("Danh sách sự kiện:");
        events.forEach(System.out::println);

        sc.close();
    }
}