package Entities;

public abstract class MedicalRecord {
    private int oder;
    private String recordId;
    private String patientId;
    private String patientName;
    private String hospitalizationDate;
    private String hospitalDischargeDate;
    private String hospitalizationReason;

    public MedicalRecord(int oder, String recordId, String patientId, String patientName, String hospitalizationDate, String hospitalDischargeDate, String hospitalizationReason) {
        this.oder = oder;
        this.recordId = recordId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.hospitalizationDate = hospitalizationDate;
        this.hospitalDischargeDate = hospitalDischargeDate;
        this.hospitalizationReason = hospitalizationReason;
    }

    public int getOder() {
        return oder;
    }

    public void setOder(int oder) {
        this.oder = oder;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(String hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }

    public String getHospitalDischargeDate() {
        return hospitalDischargeDate;
    }

    public void setHospitalDischargeDate(String hospitalDischargeDate) {
        this.hospitalDischargeDate = hospitalDischargeDate;
    }

    public String getHospitalizationReason() {
        return hospitalizationReason;
    }

    public void setHospitalizationReason(String hospitalizationReason) {
        this.hospitalizationReason = hospitalizationReason;
    }


    @Override
    public String toString() {
        return "MedicalRecord{" +
                "oder=" + oder +
                ", recordId='" + recordId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", hospitalizationDate='" + hospitalizationDate + '\'' +
                ", hospitalDischargeDate='" + hospitalDischargeDate + '\'' +
                '}';
    }

    public String toCsvString() {
        return oder + "," + recordId + "," + patientId + "," + patientName + "," + hospitalizationDate + "," + hospitalDischargeDate + "," + hospitalizationReason;
    }
}
