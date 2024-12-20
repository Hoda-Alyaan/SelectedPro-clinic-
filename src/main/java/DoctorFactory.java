/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoda Alyaan
 */
public class DoctorFactory {
    public static Doctor createDoctor(String specialization) {
        switch (specialization.toLowerCase()) {
            case "cardiologist":
                return new Cardiologist();
            case "neurologist":
                return new Neurologist();
            case "general practitioner":
                return new GeneralPractitioner();
            default:
                throw new IllegalArgumentException("Invalid specialization");
        }
    }
}

// Base Interface
interface Doctor {
    void displaySpecialization();
}

// Implementations
class Cardiologist implements Doctor {
    public void displaySpecialization() {
        System.out.println("Cardiologist");
    }
}

class Neurologist implements Doctor {
    public void displaySpecialization() {
        System.out.println("Neurologist");
    }
}

class GeneralPractitioner implements Doctor {
    public void displaySpecialization() {
        System.out.println("General Practitioner");
    }
}
