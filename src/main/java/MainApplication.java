/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoda Alyaan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplication {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Medical Clinic Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Main menu panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton managePatientsButton = new JButton("Manage Patients");
        JButton scheduleAppointmentsButton = new JButton("Schedule Appointments");
        JButton viewRecordsButton = new JButton("View Medical Records");
        JButton assignDoctorsButton = new JButton("Assign Doctors");

        panel.add(managePatientsButton);
        panel.add(scheduleAppointmentsButton);
        panel.add(viewRecordsButton);
        panel.add(assignDoctorsButton);

        frame.add(panel);

        // Button actions
        managePatientsButton.addActionListener(e -> {
            String patient = JOptionPane.showInputDialog("Enter patient name:");
            if (patient != null && !patient.isEmpty()) {
                PatientDatabaseManager.getInstance().addPatient(patient);
                JOptionPane.showMessageDialog(frame, "Patient added: " + patient);
            }
        });

        scheduleAppointmentsButton.addActionListener(e -> {
            String appointment = JOptionPane.showInputDialog("Enter appointment details:");
            if (appointment != null && !appointment.isEmpty()) {
                AppointmentScheduler.getInstance().scheduleAppointment(appointment);
                JOptionPane.showMessageDialog(frame, "Appointment scheduled: " + appointment);
            }
        });

        viewRecordsButton.addActionListener(e -> {
            String type = JOptionPane.showInputDialog("Enter record type (History, Prescription, Lab Result):");
            if (type != null) {
                MedicalRecord record = MedicalRecordFactory.createMedicalRecord(type);
                record.displayRecord();
                JOptionPane.showMessageDialog(frame, "Displayed record: " + type);
            }
        });

        assignDoctorsButton.addActionListener(e -> {
            String specialization = JOptionPane.showInputDialog("Enter doctor specialization (Cardiologist, Neurologist, General Practitioner):");
            if (specialization != null) {
                Doctor doctor = DoctorFactory.createDoctor(specialization);
                doctor.displaySpecialization();
                JOptionPane.showMessageDialog(frame, "Assigned doctor: " + specialization);
            }
        });

        frame.setVisible(true);
        
        
          // 1. Use PatientDatabaseManager Singleton
        PatientDatabaseManager patientManager = PatientDatabaseManager.getInstance();
        patientManager.addPatient("John Doe");
        patientManager.addPatient("Jane Smith");

        System.out.println("Patients in the system:");
        for (String patient : patientManager.getPatients()) {
            System.out.println(patient);
        }

        System.out.println();

  // 2. Use AppointmentScheduler Singleton
        AppointmentScheduler appointmentScheduler = AppointmentScheduler.getInstance();
        appointmentScheduler.scheduleAppointment("Appointment with Dr. Cardiologist at 10:00 AM");
        appointmentScheduler.scheduleAppointment("Appointment with Dr. Neurologist at 2:00 PM");

        System.out.println("Scheduled Appointments:");
        for (String appointment : appointmentScheduler.getAppointments()) {
            System.out.println(appointment);
        }

        System.out.println();

           // 3. Use MedicalRecordFactory to create and display medical records
        MedicalRecord historyRecord = MedicalRecordFactory.createMedicalRecord("history");
        MedicalRecord prescriptionRecord = MedicalRecordFactory.createMedicalRecord("prescription");
        MedicalRecord labResultRecord = MedicalRecordFactory.createMedicalRecord("lab result");

        System.out.println("Medical Records:");
        historyRecord.displayRecord();
        prescriptionRecord.displayRecord();
        labResultRecord.displayRecord();

        System.out.println();

        
                // 4. Use DoctorFactory to create and display doctor specializations
        Doctor cardiologist = DoctorFactory.createDoctor("cardiologist");
        Doctor neurologist = DoctorFactory.createDoctor("neurologist");
        Doctor generalPractitioner = DoctorFactory.createDoctor("general practitioner");

        System.out.println("Doctors and Their Specializations:");
        cardiologist.displaySpecialization();
        neurologist.displaySpecialization();
        generalPractitioner.displaySpecialization();


    }
}
