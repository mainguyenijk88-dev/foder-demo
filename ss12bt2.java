import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (appointmentId.length() == 6) {
            this.appointmentId = appointmentId;
        } else {
            System.out.println("Mã phải đúng 6 ký tự");
        }
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if (patientName.length() >= 10 && patientName.length() <= 50) {
            this.patientName = patientName;
        } else {
            System.out.println("Tên bệnh nhân 10-50 ký tự");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^(03|05|07|08|09)\\d{8}$")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        if (doctor.length() <= 200) {
            this.doctor = doctor;
        }
    }

    public void inputData(Scanner sc) {

        while (true) {
            System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
            String id = sc.nextLine();
            if (id.length() == 6) {
                this.appointmentId = id;
                break;
            } else {
                System.out.println("Mã phải đúng 6 ký tự");
            }
        }

        while (true) {
            System.out.print("Nhập tên bệnh nhân: ");
            String name = sc.nextLine();
            if (name.length() >= 10 && name.length() <= 50) {
                this.patientName = name;
                break;
            } else {
                System.out.println("Tên phải 10-50 ký tự");
            }
        }

        while (true) {
            System.out.print("Nhập số điện thoại: ");
            String phone = sc.nextLine();
            if (phone.matches("^(03|05|07|08|09)\\d{8}$")) {
                this.phoneNumber = phone;
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập ngày hẹn (dd/MM/yyyy): ");
                String date = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.appointmentDate = LocalDate.parse(date, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Sai định dạng ngày");
            }
        }

        System.out.print("Nhập bác sĩ phụ trách: ");
        this.doctor = sc.nextLine();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + appointmentId +
                " | Patient: " + patientName +
                " | Phone: " + phoneNumber +
                " | Date: " + appointmentDate.format(formatter) +
                " | Doctor: " + doctor;
    }
}

class AppointmentBusiness {

    static ArrayList<Appointment> list = new ArrayList<>();

    public static void addAppointment(Scanner sc) {
        Appointment a = new Appointment();
        a.inputData(sc);
        list.add(a);
        System.out.println("Thêm lịch hẹn thành công");
    }

    public static void display() {

        if (list.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        list.sort(Comparator.comparing(Appointment::getAppointmentDate));

        list.forEach(System.out::println);
    }

    public static void search(Scanner sc) {

        System.out.print("Nhập tên bệnh nhân: ");
        String keyword = sc.nextLine().toLowerCase();

        List<Appointment> result = list.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(keyword))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy");
        } else {
            result.forEach(System.out::println);
        }
    }

    public static void update(Scanner sc) {

        System.out.print("Nhập ID cần cập nhật: ");
        String id = sc.nextLine();

        Optional<Appointment> opt = list.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        opt.ifPresentOrElse(a -> {

            System.out.print("Tên mới: ");
            a.setPatientName(sc.nextLine());

            System.out.print("SĐT mới: ");
            a.setPhoneNumber(sc.nextLine());

            try {
                System.out.print("Ngày mới (dd/MM/yyyy): ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                a.setAppointmentDate(LocalDate.parse(sc.nextLine(), formatter));
            } catch (Exception e) {
                System.out.println("Sai định dạng ngày");
            }

            System.out.print("Bác sĩ mới: ");
            a.setDoctor(sc.nextLine());

            System.out.println("Cập nhật thành công");

        }, () -> System.out.println("Không tìm thấy lịch hẹn"));
    }

    public static void delete(Scanner sc) {

        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();

        Optional<Appointment> opt = list.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        opt.ifPresentOrElse(a -> {

            System.out.print("Xác nhận xóa (Y/N): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                list.remove(a);
                System.out.println("Đã xóa");
            }

        }, () -> System.out.println("Không tìm thấy"));
    }

    public static void statistic() {

        System.out.println("Tổng số lịch hẹn: " + list.size());

        Map<String, Long> map = new HashMap<>();

        for (Appointment a : list) {
            map.put(a.getDoctor(), map.getOrDefault(a.getDoctor(), 0L) + 1);
        }

        System.out.println("Số lịch theo từng bác sĩ:");

        map.forEach((doctor, count) ->
                System.out.println(doctor + ": " + count));
    }
}

public class ss12bt2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n*********** QUẢN LÝ LỊCH HẸN ***********");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm kiếm theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn");
            System.out.println("5. Xóa lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");

            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1 -> AppointmentBusiness.addAppointment(sc);
                case 2 -> AppointmentBusiness.display();
                case 3 -> AppointmentBusiness.search(sc);
                case 4 -> AppointmentBusiness.update(sc);
                case 5 -> AppointmentBusiness.delete(sc);
                case 6 -> AppointmentBusiness.statistic();
                case 7 -> System.exit(0);

                default -> System.out.println("Chọn 1-7");
            }
        }
    }
}