package repository.patient;

import entity.Patient;

import java.sql.SQLException;

public interface PatientRepository {
    void save(Patient patient) throws SQLException;
    boolean patientNameContains(Patient patient) throws SQLException;
    boolean patientContains(Patient patient) throws SQLException;
}
