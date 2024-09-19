package Menu;

import Management.AddNewMedicalRecord;
import Management.DeleteMedicalRecord;
import Management.ViewMedicalRecords;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUI {
    private Scanner scanner;
    private AddNewMedicalRecord addNewMedicalRecord;
    private DeleteMedicalRecord deleteMedicalRecord;
    private ViewMedicalRecords viewMedicalRecords;

    public MenuUI() {
        this.scanner = new Scanner(System.in);
        this.addNewMedicalRecord = new AddNewMedicalRecord();
        this.deleteMedicalRecord = new DeleteMedicalRecord();
        this.viewMedicalRecords = new ViewMedicalRecords();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n\t--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--\n");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = getIntInput();

                switch (choice) {
                    case 1:
                        addNewMedicalRecord.addNewRecord();
                        break;
                    case 2:
                        deleteMedicalRecord.deleteRecord();
                        break;
                    case 3:
                        viewMedicalRecords.displayMedicalRecords();
                        break;
                    case 4:
                        System.out.println("Tạm biệt!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập một số nguyên: ");
            }
        }
    }
}