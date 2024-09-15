import java.util.ArrayList;

import java.util.Scanner;

public class FootBallFieldManager {
    private ArrayList<FootballField> fields = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //Thêm sân bóng
    public void addField() {
        System.out.print("Tên sân: ");
        String name = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Giá: ");
        double price = scanner.nextDouble();
        System.out.println("Tình trạng ( 1 = trống, 0 = đã đặt): ");
        boolean isAvailable = scanner.nextInt() == 1;
        scanner.nextLine();
        fields.add(new FootballField(name, address, price, isAvailable));
        System.out.println("Thêm sân thành công!");
    }

    //Hiển thị danh sách sân bóng
    public void showFields() {
        if (fields.isEmpty()){
            System.out.println("Chưa có sân bóng nào");
        }else {
            for (FootballField field: fields){
                System.out.println(field);
            }
        }
    }

    // Xóa sân bóng
    public  void removeField(){
        System.out.println("Nhập tên sân bóng cần xóa");
        String name = scanner.nextLine();
        fields.removeIf(field -> field.getName().equalsIgnoreCase(name));
        System.out.println("Xóa sân thành công");
    }
    // Tìm kiếm sân bóng

}
