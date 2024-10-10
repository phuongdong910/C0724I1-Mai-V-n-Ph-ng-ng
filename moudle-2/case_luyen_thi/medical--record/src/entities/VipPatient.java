package entities;

import entities.MedicalRecord;

import java.time.LocalDate;

public class VipPatient extends MedicalRecord {
    public VipPatient(String id, String name, int age, String gender, String diagnosis,
                      LocalDate admissionDate, LocalDate dischargeDate, String status) {
        super(id, name, age, gender, diagnosis, admissionDate, dischargeDate, status);
    }
}