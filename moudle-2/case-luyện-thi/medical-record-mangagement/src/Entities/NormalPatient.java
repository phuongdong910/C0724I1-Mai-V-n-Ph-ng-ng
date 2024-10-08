package Entities;

public class NormalPatient extends MedicalRecord {
    private double hospitalFee;

    public NormalPatient(int oder, String recordID, String patientId, String patientName, String hospitalIzationDate, String hospitalDischargeDate, String hospitalIzationReason, double hospitalFee) {
        super(oder, recordID, patientId, patientName, hospitalIzationDate, hospitalDischargeDate, hospitalIzationReason);
        this.hospitalFee = hospitalFee;
    }

    public double getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(double hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

    @Override
    public String toString() {
        return "NormalPatient{" +
                "hospitalFee=" + hospitalFee +
                '}' + super.toString();
    }

    @Override
    public String toCsvString() {

    }
}

