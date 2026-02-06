public class ss5bt5 {

    public static void main(String[] args) {

        int loop = 1_000_000;

        // 1. String
        long startTime = System.currentTimeMillis();

        String str = "Hello";
        for (int i = 0; i < loop; i++) {
            str += " World";
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String: "
                + (endTime - startTime) + " ms");

        // 2. StringBuilder
        startTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < loop; i++) {
            sb.append(" World");
        }

        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: "
                + (endTime - startTime) + " ms");

        //  3. StringBuffer
        startTime = System.currentTimeMillis();

        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < loop; i++) {
            sbf.append(" World");
        }

        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: "
                + (endTime - startTime) + " ms");

        // Nhận xét
        System.out.println("\nNhận xét:");
        System.out.println("- String: Chậm nhất vì mỗi lần nối tạo ra một đối tượng mới.");
        System.out.println("- StringBuilder: Nhanh nhất, phù hợp khi xử lý chuỗi nhiều trong 1 luồng.");
        System.out.println("- StringBuffer: An toàn đa luồng nhưng chậm hơn StringBuilder.");
    }
}

