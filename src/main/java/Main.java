/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoda Alyaan
 */
public class Main {
    public static void main(String[] args) {
        // Step 1: Get the Singleton instance of PatientDatabaseManager
        PatientDatabaseManager manager = PatientDatabaseManager.getInstance();

        // Step 2: Add patients
        manager.addPatient("John Doe");
        manager.addPatient("Jane Smith");

        // Step 3: Retrieve and print the list of patients
        System.out.println("Patients:");
        for (String patient : manager.getPatients()) {
            System.out.println(patient);
        }
             // Step 1: Get the Singleton instance of AppointmentScheduler
        AppointmentScheduler scheduler = AppointmentScheduler.getInstance();

        // Step 2: Schedule appointments
        scheduler.scheduleAppointment("Appointment with Dr. Smith at 10:00 AM");
        scheduler.scheduleAppointment("Appointment with Dr. Brown at 2:00 PM");

        // Step 3: Retrieve and print the list of scheduled appointments
        System.out.println("Scheduled Appointments:");
        for (String appointment : scheduler.getAppointments()) {
            System.out.println(appointment);
 }
        
          // Step 1: Use the factory to create different medical record types
        MedicalRecord historyRecord = MedicalRecordFactory.createMedicalRecord("history");
        MedicalRecord prescriptionRecord = MedicalRecordFactory.createMedicalRecord("prescription");
        MedicalRecord labResultRecord = MedicalRecordFactory.createMedicalRecord("lab result");

        // Step 2: Display each record
        System.out.println("Displaying Medical Records:");
        historyRecord.displayRecord();
        prescriptionRecord.displayRecord();
        labResultRecord.displayRecord();

        
        
        
        // Step 1: Use the factory to create different types of doctors
        Doctor cardiologist = DoctorFactory.createDoctor("cardiologist");
        Doctor neurologist = DoctorFactory.createDoctor("neurologist");
        Doctor generalPractitioner = DoctorFactory.createDoctor("general practitioner");

        // Step 2: Display the specializations
        System.out.println("Doctors and Their Specializations:");
        cardiologist.displaySpecialization();
        neurologist.displaySpecialization();
        generalPractitioner.displaySpecialization();

        
        
        
        }
    }