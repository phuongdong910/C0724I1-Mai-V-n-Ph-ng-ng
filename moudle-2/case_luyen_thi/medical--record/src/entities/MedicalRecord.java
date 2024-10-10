package entities;

import java.time.LocalDate;

public class MedicalRecord {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String diagnosis;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String status;

    public MedicalRecord(String id, String name, int age, String gender, String diagnosis,
                         LocalDate admissionDate, LocalDate dischargeDate, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public String getStatus() {
        return status;
    }

    public String toCsvString() {
        return id + "," + name + "," + age + "," + gender + "," + diagnosis + "," +
                admissionDate + "," + dischargeDate + "," + status;
    }
}
