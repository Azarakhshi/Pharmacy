package service.patient;

import entity.Patient;

import java.sql.SQLException;

public interface PatientService {

    void signUp(String patientName, String patientPassword) throws SQLException;

    void logIn(String patientName, String patientPassword) throws SQLException;

}
