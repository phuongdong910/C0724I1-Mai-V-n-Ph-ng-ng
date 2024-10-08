package Entities;

public abstract class MedicalRecord {
private int oder;
private  String recordID;
private String patientId;
private  String patientName;
private String hospitalIzationDate;
private String hospitalDischargeDate;
private String hospitalIzationReason;

    public MedicalRecord(int oder, String recordID, String patientId, String patientName, String hospitalIzationDate, String hospitalDischargeDate, String hospitalIzationReason) {
        this.oder = oder;
        this.recordID = recordID;
        this.patientId = patientId;
        this.patientName = patientName;
        this.hospitalIzationDate = hospitalIzationDate;
        this.hospitalDischargeDate = hospitalDischargeDate;
        this.hospitalIzationReason = hospitalIzationReason;
    }

    public int getOder() {
        return oder;
    }

    public void setOder(int oder) {
        this.oder = oder;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
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

    public String getHospitalIzationDate() {
        return hospitalIzationDate;
    }

    public void setHospitalIzationDate(String hospitalIzationDate) {
        this.hospitalIzationDate = hospitalIzationDate;
    }

    public String getHospitalDischargeDate() {
        return hospitalDischargeDate;
    }

    public void setHospitalDischargeDate(String hospitalDischargeDate) {
        this.hospitalDischargeDate = hospitalDischargeDate;
    }

    public String getHospitalIzationReason() {
        return hospitalIzationReason;
    }

    public void setHospitalIzationReason(String hospitalIzationReason) {
        this.hospitalIzationReason = hospitalIzationReason;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "oder=" + oder +
                ", recordID='" + recordID + '\'' +
                ", patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", hospitalIzationDate='" + hospitalIzationDate + '\'' +
                ", hospitalDischargeDate='" + hospitalDischargeDate + '\'' +
                ", hospitalIzationReason='" + hospitalIzationReason + '\'' +
                '}';
    }

    public  String toCsvString(){
        return  oder + "," + recordID + "," + patientId + "," + patientName + "," + hospitalIzationDate + "," + hospitalDischargeDate + "," + hospitalIzationReason;
    }
}
