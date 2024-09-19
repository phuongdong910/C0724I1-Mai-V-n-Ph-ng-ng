package Management;

import Entities.NormalPatient;
import Entities.VipPatient;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class AddNewMedicalRecord {
    private Scanner scanner;

    public AddNewMedicalRecord() {
        this.scanner = new Scanner(System.in);
    }

    public void addNewRecord() {
        try {
            System.out.println("Chọn loại bệnh án:");
            System.out.println("1. Bệnh án thường");
            System.out.println("2. Bệnh án VIP");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice != 1 && choice != 2) {
                throw new IllegalArgumentException("Lựa chọn không hợp lệ.");
            }

            int oder = FileService.getLastOder() + 1;
            String recordId = inputRecordId();

            if (FileService.isRecordIdExists(recordId)) {
                throw new IllegalArgumentException("Bệnh án đã tồn tại. Vui lòng thử lại với mã bệnh án khác.");
            }

            String patientId = inputPatientId();
            String patientName = inputPatientName();
            String hospitalizationDate = inputDate("Ngày nhập viện");
            String hospitalDischargeDate = inputDate("Ngày xuất viện", hospitalizationDate);
            String hospitalizationReason = inputHospitalizationReason();

            if (choice == 1) {
                double hospitalFee = inputHospitalFee();
                NormalPatient patient = new NormalPatient(oder, recordId, patientId, patientName, hospitalizationDate, hospitalDischargeDate, hospitalizationReason, hospitalFee);
                FileService.saveMedicalRecord(patient);
            } else {
                String vipType = inputVipType();
                String vipExpirationDate = inputDate("Ngày hết hạn VIP");
                VipPatient patient = new VipPatient(oder, recordId, patientId, patientName, hospitalizationDate, hospitalDischargeDate, hospitalizationReason, vipType, vipExpirationDate);
                FileService.saveMedicalRecord(patient);
            }

            System.out.println("Đã thêm bệnh án mới thành công.");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên cho lựa chọn.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    private String inputRecordId() {
        while (true) {
            System.out.print("Nhập mã bệnh án (BA-XXX): ");
            String recordId = scanner.nextLine();
            if (recordId.matches("BA-\\d{3}")) {
                return recordId;
            }
            System.out.println("Mã bệnh án không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private String inputPatientId() {
        while (true) {
            System.out.print("Nhập mã bệnh nhân (BN-XXX): ");
            String patientId = scanner.nextLine();
            if (patientId.matches("BN-\\d{3}")) {
                return patientId;
            }
            System.out.println("Mã bệnh nhân không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private String inputPatientName() {
        System.out.print("Nhập tên bệnh nhân: ");
        return scanner.nextLine();
    }

    private String inputDate(String prompt) {
        return inputDate(prompt, null);
    }

    private String inputDate(String prompt, String startDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print(prompt + " (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            if (!dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
                continue;
            }
            try {
                Date date = sdf.parse(dateStr);
                if (startDate != null) {
                    Date start = sdf.parse(startDate);
                    if (date.before(start)) {
                        System.out.println("Ngày xuất viện phải sau ngày nhập viện. Vui lòng nhập lại.");
                        continue;
                    }
                }
                String[] parts = dateStr.split("/");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 9999) {
                    System.out.println("Ngày, tháng, hoặc năm không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }
                return dateStr;
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    private double inputHospitalFee() {
        while (true) {
            System.out.print("Nhập phí nằm viện: ");
            try {
                double fee = Double.parseDouble(scanner.nextLine());
                if (fee < 0) {
                    throw new IllegalArgumentException("Phí nằm viện không thể là số âm.");
                }
                return fee;
            } catch (NumberFormatException e) {
                System.out.println("Phí nằm viện không hợp lệ. Vui lòng nhập lại.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại.");
            }
        }
    }

    private String inputVipType() {
        while (true) {
            System.out.print("Nhập loại VIP (VIP I, VIP II, VIP III): ");
            String vipType = scanner.nextLine().toUpperCase();
            if (vipType.equals("VIP I") || vipType.equals("VIP II") || vipType.equals("VIP III")) {
                return vipType;
            }
            System.out.println("Loại VIP không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private String inputHospitalizationReason() {
        System.out.print("Nhập lý do nhập viện: ");
        return scanner.nextLine();
    }
}