package Entities;

public class NormalPatient extends MedicalRecord {
    private double hospitalFee;

    public NormalPatient(int oder, String recordId, String patientId, String patientName, String hospitalizationDate, String hospitalDischargeDate, String hospitalizationReason, double hospitalFee) {
        super(oder, recordId, patientId, patientName, hospitalizationDate, hospitalDischargeDate, hospitalizationReason);
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
                "} " + super.toString();
    }

    @Override
    public String toCsvString() {
        return super.toCsvString() + "," + hospitalFee;
    }
}
