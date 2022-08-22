package repository.admin;

import config.ApplicationConnection;
import entity.PharmacyAdmin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositryImpl implements AdminRepository {

    @Override
    public void save(PharmacyAdmin pharmacyAdmin) throws SQLException {
        String sql = " INSERT INTO patient(patientname , patientpassword) VALUES (?,?)";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, pharmacyAdmin.getAdminName());
        ps.setString(2, pharmacyAdmin.getAdminPassword());
        ps.execute();
        ps.close();
    }

    @Override
    public boolean adminNameContains(PharmacyAdmin pharmacyAdmin) throws SQLException {
        String sql = "SELECT patientname from patient WHERE patientname = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, pharmacyAdmin.getAdminName());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    @Override
    public boolean adminContains(PharmacyAdmin pharmacyAdmin) throws SQLException {
        String sql = "SELECT * from patient WHERE patientname = ? and patientpassword = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, pharmacyAdmin.getAdminName());
        ps.setString(2, pharmacyAdmin.getAdminPassword());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

}
