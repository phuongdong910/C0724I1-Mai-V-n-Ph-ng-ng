public class Example1 {
    public static void main(String[] args) {
        String s1 = "I love you";
        String s2 = "I LOVE YOu";
        String s3 = "I love you";

        // Hàm equals ==> so sánh 2 chuỗi giống nhau, có phân biệt hoa thường.
        System.out.println("SO sánh s1 va s2: " +s1.equals(s2));
        System.out.println("SO sánh s1 va s3: " +s1.equals(s3));

        // Hàm CompareTo so sánh sắp xếp.
        String student1 = "Mai Van Anh Quan";
        String student2 = "Mai Van Phuong Dong";
        String student3 = "Le Thi Anh Thu";
        String student4 = "Mai Van Anh Quan";

        System.out.println("student1 compareTo student2: " + student1.compareTo(student2));
        System.out.println("student1 compareTo student3: " + student1.compareTo(student3));
        System.out.println("student 1 compareTo student4: " + student1.compareTo(student4));

        // Hàm regionMatches ==> so sánh một đoạn
        String rm1 = "PhuongDong";
        String rm2 = "PhuongDong";
        String rm3 = "Dong";
        String rm4 = "DONG";
        boolean check = rm1.regionMatches(0, rm2, 0, 3);
        boolean check1 = rm1.regionMatches(6, rm3, 0, 4);
        boolean check3 = rm1.regionMatches(false,6,rm4, 0, 4);
        System.out.println(check);
        System.out.println(check1);
        System.out.println(check3);

        // hàm startsWith và hàm endsWith

        String phonenumber1 = "0905383793";
        String phonenumber2 = "0941606814";
        System.out.println(phonenumber1.startsWith("0905"));
        System.out.println(phonenumber2.startsWith("0905"));
        // endsWith
        String fileName1 = "I lovve your son.jpg";
        String fileName2 = "Clean Code.pdf";

        if (fileName1.endsWith(".jpg")){
            System.out.println("File 1 là hinh ảnh");
        }else if(fileName1.endsWith(".pdf")){
            System.out.println("File  1 là pdf");
        }

        if (fileName2.endsWith(".jpg")){
            System.out.println("File 2 là hinh ảnh");
        }else if(fileName2.endsWith(".pdf")){
            System.out.println("File 2 là pdf");
        }

    }
}
