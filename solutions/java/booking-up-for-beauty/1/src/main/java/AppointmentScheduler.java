import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy HH:mm:ss");
        LocalDateTime result = LocalDateTime.parse(appointmentDateDescription, formatter);
        return result;   
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime current = LocalDateTime.now();
        return appointmentDate.isBefore(current) ? true: false;
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime start = LocalTime.of(12,0);
        LocalTime end = LocalTime.of(18,0);
        LocalTime appointment = appointmentDate.toLocalTime();
        boolean isInRange =  ( appointment.equals(start)||appointment.isAfter(start)) && appointment.isBefore(end);
        return isInRange;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        String dayOfWeek = appointmentDate.getDayOfWeek().toString().toLowerCase();
        String capDayOfWeek = dayOfWeek.substring(0,1).toUpperCase() + dayOfWeek.substring(1);
        String date = appointmentDate.format(DateTimeFormatter.ofPattern("MMMM d, yyyy",Locale.ENGLISH));
        String time = appointmentDate.format(DateTimeFormatter.ofPattern("h:mm a",Locale.ENGLISH));

        return String.format("You have an appointment on %s, %s, at %s.", capDayOfWeek, date, time);

    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(2025, 9, 15);
    }
}
