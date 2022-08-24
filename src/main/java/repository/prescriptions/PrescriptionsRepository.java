package repository.prescriptions;

import entity.Prescriptions;

import java.sql.SQLException;

public interface PrescriptionsRepository {
    //Prescriptions lastPrescriptionsId() throws SQLException;
    void save(Prescriptions prescriptions) throws SQLException;

    boolean isPatientexist(String patientsname) throws SQLException;

    Prescriptions[] priceForEachitem(String patientsname) throws SQLException;

    //Prescriptions[] totalPrice(String patientsname)throws SQLException;
    void delete(Prescriptions prescriptions) throws SQLException;

    void edtit(Prescriptions newPrescriptions, Prescriptions oldPrescriptions) throws SQLException;

    Prescriptions[] showAllPrescriptions() throws SQLException;

    void adminEdit(Prescriptions newPrescriptions, Prescriptions oldPrescriptions)throws SQLException;
}
