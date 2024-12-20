/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoda Alyaan
 */
public class MedicalRecordFactory {
    public static MedicalRecord createMedicalRecord(String type) {
        switch (type.toLowerCase()) {
            case "history" -> {
                return new PatientHistory();
            }
            case "prescription" -> {
                return new Prescription();
            }
            case "lab result" -> {
                return new LabResult();
            }
            default -> throw new IllegalArgumentException("Invalid record type");
        }
    }
}

// Base Interface
interface MedicalRecord {
    void displayRecord();
}

// Implementations
class PatientHistory implements MedicalRecord {
    @Override
    public void displayRecord() {
        System.out.println("Patient History Record");
    }
}

class Prescription implements MedicalRecord {
    @Override
    public void displayRecord() {
        System.out.println("Prescription Record");
    }
}

class LabResult implements MedicalRecord {
    @Override
    public void displayRecord() {
        System.out.println("Lab Result Record");
    }
}
