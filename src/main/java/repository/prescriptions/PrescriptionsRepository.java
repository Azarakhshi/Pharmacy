package repository.prescriptions;

import entity.Prescriptions;

import java.sql.SQLException;

public interface PrescriptionsRepository {
    int lastPrescriptionsId() throws SQLException;
    void save(Prescriptions prescriptions) throws SQLException;
}
