package repository.prescriptions;

import config.ApplicationConnection;
import entity.Prescriptions;
import entity.Prescriptions;

import java.sql.*;

public class PrescriptionsRepositoryImpl implements PrescriptionsRepository {

/*
    @Override
    public Prescriptions lastPrescriptionsId() throws SQLException {
        Prescriptions prescriptions = new Prescriptions();
        String sql = "SELECT prescriptionsId FROM prescriptions ORDER BY prescriptionsId DESC   ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = ps.executeQuery();
        prescriptions.setPrescriptionsIdOrder(resultSet.getInt("prescriptionsId"));
        return prescriptions;
    }*/

    @Override
    public void save(Prescriptions prescriptions) throws SQLException {
        String sql = "insert into prescriptions(patientsname , drugsname , quantity ) values (? , ? , ? )";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, prescriptions.getPatientsName());
        ps.setString(2, prescriptions.getDrugsName());
        ps.setInt(3, prescriptions.getQuantity());
        ps.execute();
        ps.close();
    }

    @Override
    public boolean isPatientexist(String patientsname) throws SQLException {
        String sql = "select patientsname from prescriptions where patientsname = ?";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, patientsname);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    @Override
    public Prescriptions[] priceForEachitem(String patientsname) throws SQLException {
        String sql = "select * from Prescriptions where isconfirm = true and patientsname = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, patientsname);
        ResultSet resultSet;
        resultSet = ps.executeQuery();

        Prescriptions[] prescriptions = new Prescriptions[1000];
        int index = 0;
        while (resultSet.next()) {
            Prescriptions prescriptions1 = new Prescriptions();
            prescriptions1.setPatientsName(resultSet.getString("patientsname"));
            prescriptions1.setDoesExist(resultSet.getBoolean("doesexist"));
            prescriptions1.setConfirm(resultSet.getBoolean("isconfirm"));
            prescriptions1.setDrugsName(resultSet.getString("drugsname"));
            prescriptions1.setQuantity(resultSet.getInt("quantity"));
            prescriptions1.setPrice(resultSet.getInt("price"));
            prescriptions1.setTOTAL_PRICE(prescriptions1.getPrice() * prescriptions1.getQuantity());
            prescriptions[index] = prescriptions1;
            index++;
        }
        return prescriptions;
    }


    @Override
    public void delete(Prescriptions prescriptions) throws SQLException {
        String sql = "DELETE FROM prescriptions WHERE patientsname=?";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, prescriptions.getPatientsName());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void edtit(Prescriptions newPrescriptions, Prescriptions oldPrescriptions) throws SQLException {

        String sql = "update prescriptions set drugsname = ? , quantity = ? where patientsname = ? and drugsname = ?";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, newPrescriptions.getDrugsName());
        ps.setInt(2, newPrescriptions.getQuantity());
        ps.setString(3, oldPrescriptions.getPatientsName());
        ps.setString(4, oldPrescriptions.getDrugsName());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Prescriptions[] showAllPrescriptions() throws SQLException {
        String sql = "select * from Prescriptions where isconfirm = false ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet;
        resultSet = ps.executeQuery();

        Prescriptions[] prescriptions = new Prescriptions[1000];
        int index = 0;
        while (resultSet.next()) {
            Prescriptions prescriptions1 = new Prescriptions();
            prescriptions1.setPatientsName(resultSet.getString("patientsname"));
            prescriptions1.setDoesExist(resultSet.getBoolean("doesexist"));
            prescriptions1.setConfirm(resultSet.getBoolean("isconfirm"));
            prescriptions1.setDrugsName(resultSet.getString("drugsname"));
            prescriptions1.setQuantity(resultSet.getInt("quantity"));
            prescriptions1.setPrice(resultSet.getInt("price"));
            prescriptions1.setTOTAL_PRICE(prescriptions1.getPrice() * prescriptions1.getQuantity());
            prescriptions[index] = prescriptions1;
            index++;
        }
        return prescriptions;
    }

    @Override
    public void adminEdit(Prescriptions newPrescriptions, Prescriptions oldPrescriptions) throws SQLException {
        String sql = " update prescriptions set price = ? , doesexist = ? ,isconfirm = ? where patientsname = ? and drugsname = ?";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,newPrescriptions.getPrice());
        ps.setBoolean(2,newPrescriptions.isDoesExist());
        ps.setBoolean(3,newPrescriptions.isConfirm());
        ps.setString(4, oldPrescriptions.getPatientsName());
        ps.setString(5, oldPrescriptions.getDrugsName());
        ps.executeUpdate();
        ps.close();

    }



}
