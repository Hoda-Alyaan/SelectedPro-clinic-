
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
public class AppointmentScheduler {
    private static AppointmentScheduler instance;

    private final List<String> appointments;

    private AppointmentScheduler() {
        appointments = new ArrayList<>();
    }

    public static synchronized AppointmentScheduler getInstance() {
        if (instance == null) {
            instance = new AppointmentScheduler();
        }
        return instance;
    }

    public void scheduleAppointment(String appointment) {
        appointments.add(appointment);
    }

    public List<String> getAppointments() {
        return appointments;
    }
}
