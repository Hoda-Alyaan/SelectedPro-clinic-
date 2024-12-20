
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoda Alyaan
 */
    public class PatientDatabaseManager {
    private static PatientDatabaseManager instance;

    // Simulated database
    private final List<String> patients;

    private PatientDatabaseManager() {
        patients = new ArrayList<>();
    }

    public static synchronized PatientDatabaseManager getInstance() {
        if (instance == null) {
            instance = new PatientDatabaseManager();
        }
        return instance;
    }

    public void addPatient(String patient) {
        patients.add(patient);
    }

    public List<String> getPatients() {
        return patients;
    }
}
