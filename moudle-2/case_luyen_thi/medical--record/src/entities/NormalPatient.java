package entities;

import entities.MedicalRecord;

import java.time.LocalDate;

public class NormalPatient extends MedicalRecord {
    public NormalPatient(String id, String name, int age, String gender, String diagnosis,
                         LocalDate admissionDate, LocalDate dischargeDate, String status) {
        super(id, name, age, gender, diagnosis, admissionDate, dischargeDate, status);
    }
}