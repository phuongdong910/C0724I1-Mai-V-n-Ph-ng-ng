package Management;

import java.util.Scanner;

public class DeleteMedicalRecord {
    private Scanner scanner;

    public DeleteMedicalRecord() {
        this.scanner = new Scanner(System.in);
    }

    public void deleteRecord() {
        try {
            System.out.print("Nhập mã bệnh án cần xóa (BA-XXX): ");
            String recordId = scanner.nextLine();

            if (!recordId.matches("BA-\\d{3}")) {
                throw new IllegalArgumentException("Mã bệnh án không hợp lệ.");
            }

            if (!FileService.isRecordIdExists(recordId)) {
                throw new IllegalArgumentException("Không tìm thấy bệnh án với mã " + recordId);
            }

            System.out.print("Bạn có chắc chắn muốn xóa bệnh án này? (yes/no): ");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                boolean deleted = FileService.deleteMedicalRecord(recordId);
                if (deleted) {
                    System.out.println("Đã xóa bệnh án thành công.");
                } else {
                    throw new RuntimeException("Có lỗi xảy ra khi xóa bệnh án.");
                }
            } else if (confirmation.equals("no")) {
                System.out.println("Hủy xóa bệnh án.");
            } else {
                throw new IllegalArgumentException("Lựa chọn không hợp lệ. Vui lòng nhập 'yes' hoặc 'no'.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}