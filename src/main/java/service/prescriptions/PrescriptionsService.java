package service.prescriptions;

import entity.Prescriptions;

import java.sql.SQLException;

public interface PrescriptionsService {
    int findPrescriptionsId() throws SQLException;
    void addDrugtoPrescriptions(Prescriptions prescriptions) throws SQLException;

}
