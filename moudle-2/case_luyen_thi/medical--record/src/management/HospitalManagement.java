package management;

import entities.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class HospitalManagement {
    private List<MedicalRecord> patients;

    public HospitalManagement() {
        patients = FileService.readMedicalRecords(); // Load existing records from file
    }

    public void addPatient(MedicalRecord patient) {
        patients.add(patient);
        FileService.saveMedicalRecord(patient); // Save to file
    }

    public void removePatient(String id) {
        if (FileService.deleteMedicalRecord(id)) {
            patients.removeIf(patient -> patient.getId().equals(id));
            System.out.println("Patient with ID " + id + " removed.");
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        for (MedicalRecord patient : patients) {
            System.out.println("ID: " + patient.getId() + ", Name: " + patient.getName() +
                    ", Age: " + patient.getAge() + ", Gender: " + patient.getGender() +
                    ", Diagnosis: " + patient.getDiagnosis() +
                    ", Admission Date: " + patient.getAdmissionDate() +
                    ", Discharge Date: " + patient.getDischargeDate() +
                    ", Status: " + patient.getStatus());
        }
    }

    public List<MedicalRecord> getPatients() {
        return patients;
    }
}
