package repository.admin;

import entity.Patient;
import entity.PharmacyAdmin;

import java.sql.SQLException;

public interface AdminRepository {
    void save(PharmacyAdmin pharmacyAdmin) throws SQLException;
    boolean adminNameContains(PharmacyAdmin pharmacyAdmin) throws SQLException;
    boolean adminContains(PharmacyAdmin pharmacyAdmin) throws SQLException;
}
