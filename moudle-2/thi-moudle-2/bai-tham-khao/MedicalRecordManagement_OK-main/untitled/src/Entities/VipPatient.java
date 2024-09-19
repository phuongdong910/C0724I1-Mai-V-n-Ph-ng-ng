package Entities;

public class VipPatient extends MedicalRecord {
    private String vipType;
    private String vipExpirationDate;

    public VipPatient(int oder, String recordId, String patientId, String patientName, String hospitalizationDate, String hospitalDischargeDate, String hospitalizationReason, String vipType, String vipExpirationDate) {
        super(oder, recordId, patientId, patientName, hospitalizationDate, hospitalDischargeDate, hospitalizationReason);
        this.vipType = vipType;
        this.vipExpirationDate = vipExpirationDate;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getVipExpirationDate() {
        return vipExpirationDate;
    }

    public void setVipExpirationDate(String vipExpirationDate) {
        this.vipExpirationDate = vipExpirationDate;
    }

    @Override
    public String toString() {
        return "VipPatient{" +
                "vipType='" + vipType + '\'' +
                ", vipExpirationDate='" + vipExpirationDate + '\'' +
                "} " + super.toString();
    }

    @Override
    public String toCsvString() {
        return super.toCsvString() + "," + vipType + "," + vipExpirationDate;
    }
}