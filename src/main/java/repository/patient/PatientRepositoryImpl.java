package repository.patient;

import config.ApplicationConnection;
import entity.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRepositoryImpl {

    public void save(Patient patient) throws SQLException {
        String sql = " INSERT INTO patient(patientname , patientpassword) VALUES (?,?)";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, patient.getPatientName());
        ps.setString(2, patient.getPatientPassword());
        ps.execute();
        ps.close();
    }

    public boolean patientNameContains(Patient patient) throws SQLException {
        String sql = "SELECT patientname from patient WHERE patientname = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, patient.getPatientName());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public boolean patientContains(Patient patient) throws SQLException {
        String sql = "SELECT * from patient WHERE patientname = ? and patientpassword = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, patient.getPatientName());
        ps.setString(2, patient.getPatientPassword());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
