/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoda Alyaan
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainApplicationGUI extends javax.swing.JFrame {
    private PatientDatabaseManager patientManager = PatientDatabaseManager.getInstance();
    private AppointmentScheduler appointmentScheduler = AppointmentScheduler.getInstance();
    private List<Doctor> doctors = new ArrayList<>();

    public MainApplicationGUI() {
        initComponents();
    }

    private void initComponents() {
        // Tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // --- Tab 1: Patient Management ---
        JPanel patientPanel = new JPanel();
        JTextField patientTextField = new JTextField(20);
        JButton addPatientButton = new JButton("Add Patient");
        JList<String> patientList = new JList<>();
        JScrollPane patientScrollPane = new JScrollPane(patientList);

        addPatientButton.addActionListener(e -> {
            String patientName = patientTextField.getText();
            if (!patientName.isEmpty()) {
                patientManager.addPatient(patientName);
                updatePatientList(patientList);
                patientTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a patient name!");
            }
        });

        patientPanel.add(new JLabel("Enter Patient Name:"));
        patientPanel.add(patientTextField);
        patientPanel.add(addPatientButton);
        patientPanel.add(new JLabel("Patients:"));
        patientPanel.add(patientScrollPane);
        tabbedPane.addTab("Patients", patientPanel);

        // --- Tab 2: Appointment Scheduling ---
        JPanel appointmentPanel = new JPanel();
        JTextField appointmentTextField = new JTextField(20);
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        JList<String> appointmentList = new JList<>();
        JScrollPane appointmentScrollPane = new JScrollPane(appointmentList);

        scheduleAppointmentButton.addActionListener(e -> {
            String appointmentDetail = appointmentTextField.getText();
            if (!appointmentDetail.isEmpty()) {
                appointmentScheduler.scheduleAppointment(appointmentDetail);
                updateAppointmentList(appointmentList);
                appointmentTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter appointment details!");
            }
        });

        appointmentPanel.add(new JLabel("Enter Appointment Details:"));
        appointmentPanel.add(appointmentTextField);
        appointmentPanel.add(scheduleAppointmentButton);
        appointmentPanel.add(new JLabel("Scheduled Appointments:"));
        appointmentPanel.add(appointmentScrollPane);
        tabbedPane.addTab("Appointments", appointmentPanel);

        // --- Tab 3: Medical Records ---
        JPanel recordPanel = new JPanel();
        JComboBox<String> recordTypeComboBox = new JComboBox<>(new String[]{"History", "Prescription", "Lab Result"});
        JButton createRecordButton = new JButton("Create Record");
        JTextArea recordTextArea = new JTextArea(5, 20);
        JScrollPane recordScrollPane = new JScrollPane(recordTextArea);

        createRecordButton.addActionListener(e -> {
            String recordType = (String) recordTypeComboBox.getSelectedItem();
            MedicalRecord record = MedicalRecordFactory.createMedicalRecord(recordType.toLowerCase());
            recordTextArea.setText(recordType + ":");
            record.displayRecord();
        });

        recordPanel.add(new JLabel("Select Record Type:"));
        recordPanel.add(recordTypeComboBox);
        recordPanel.add(createRecordButton);
        recordPanel.add(recordScrollPane);
        tabbedPane.addTab("Medical Records", recordPanel);

        // --- Tab 4: Doctor Management ---
        JPanel doctorPanel = new JPanel();
        JComboBox<String> doctorSpecializationComboBox = new JComboBox<>(new String[]{"Cardiologist", "Neurologist", "General Practitioner"});
        JButton addDoctorButton = new JButton("Add Doctor");
        JList<String> doctorList = new JList<>();
        JScrollPane doctorScrollPane = new JScrollPane(doctorList);

        addDoctorButton.addActionListener(e -> {
            String specialization = (String) doctorSpecializationComboBox.getSelectedItem();
            Doctor doctor = DoctorFactory.createDoctor(specialization.toLowerCase());
            doctors.add(doctor);
            updateDoctorList(doctorList);
        });

        doctorPanel.add(new JLabel("Select Doctor Specialization:"));
        doctorPanel.add(doctorSpecializationComboBox);
        doctorPanel.add(addDoctorButton);
        doctorPanel.add(doctorScrollPane);
        tabbedPane.addTab("Doctors", doctorPanel);

        // Add TabbedPane to Frame
        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    // Helper Methods
    private void updatePatientList(JList<String> patientList) {
        patientList.setListData(patientManager.getPatients().toArray(new String[0]));
    }

    private void updateAppointmentList(JList<String> appointmentList) {
        appointmentList.setListData(appointmentScheduler.getAppointments().toArray(new String[0]));
    }

    private void updateDoctorList(JList<String> doctorList) {
        List<String> doctorNames = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorNames.add(doctor.getClass().getSimpleName());
        }
        doctorList.setListData(doctorNames.toArray(new String[0]));
    }

    public static void main(String[] args) {
        new MainApplicationGUI();
}
}