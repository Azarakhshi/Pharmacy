package repository.drugs;

import config.ApplicationConnection;
import entity.Drugs;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugsRepositoryImpl implements DrugsRepository{

    @Override
    public boolean drugsContains(Drugs drugs) throws SQLException {
        String sql = "SELECT drugname from drugs WHERE drugname = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, drugs.getDrugName());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
