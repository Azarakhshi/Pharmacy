package repository.prescriptions;

import config.ApplicationConnection;
import entity.Prescriptions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionsRepositoryImpl implements PrescriptionsRepository {
    @Override
    public int lastPrescriptionsId() throws SQLException {
        String sql = "SELECT prescriptionsId FROM prescriptions ORDER BY prescriptionsId DESC LIMIT 1";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs.getInt(1);
    }

    @Override
    public void save(Prescriptions prescriptions) throws SQLException {
        String sql = "insert into prescriptions(patientsname , drugsname , quantity , prescriptionsid) values (? , ? , ? , ? )";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, prescriptions.getPatientsName());
        ps.setString(2, prescriptions.getDrugsName());
        ps.setInt(3,prescriptions.getQuantity());
        ps.setInt(4,prescriptions.getPrescriptionsIdOrder());
        ps.execute();
        ps.close();
    }

}
