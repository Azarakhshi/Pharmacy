package service.prescriptions;

import entity.Prescriptions;

import java.sql.SQLException;

public interface PrescriptionsService {
    /*
    Prescriptions findPrescriptionsId() throws SQLException;*/
    void addDrugtoPrescriptions(Prescriptions prescriptions) throws SQLException;
    boolean isPatientexist(String patientsname) throws SQLException;
    void priceForEachitem(String patientsname)throws SQLException;
    int totalPrice(String patientsname)throws SQLException;
    void deleteprescription(String patientsname) throws  SQLException;
    void editPrescriptionsDrug(Prescriptions newPrescriptions , Prescriptions oldPrescriptions) throws SQLException;
    void showAllPrescriptions()throws SQLException;
    void adminEdit(Prescriptions newPrescriptions, Prescriptions oldPrescriptions)throws SQLException;

}
