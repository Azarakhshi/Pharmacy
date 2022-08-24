package service.prescriptions;

import entity.Prescriptions;
import repository.prescriptions.PrescriptionsRepository;

import java.sql.SQLException;

public class PrescriptionsServiceImpl implements PrescriptionsService {
    private PrescriptionsRepository prescriptionsRepository;

    public PrescriptionsServiceImpl(PrescriptionsRepository prescriptionsRepository) {
        this.prescriptionsRepository = prescriptionsRepository;
    }
/*
    @Override
    public Prescriptions findPrescriptionsId() throws SQLException {
        return (prescriptionsRepository.lastPrescriptionsId());
    }*/

    @Override
    public void addDrugtoPrescriptions(Prescriptions prescriptions) throws SQLException {
        prescriptionsRepository.save(prescriptions);
    }

    @Override
    public boolean isPatientexist(String patientsname) throws SQLException {
        return prescriptionsRepository.isPatientexist(patientsname);
    }

    @Override
    public void priceForEachitem(String patientsname) throws SQLException {
        Prescriptions[] prescriptions;
        prescriptions = prescriptionsRepository.priceForEachitem(patientsname);
        while (true){
            if(prescriptions.length == 0 || prescriptions[0]==null){
                System.out.println("you have not prescription confirmed. please wait ");
                break;
            }else{
                for (int i = 0 ; i < prescriptions.length ; i++){
                    if(prescriptions[i] != null){
                        System.out.println((i+1) + " _  " + prescriptions[i]);
                    }
                }
            }
            break;
        }
    }

    @Override
    public int totalPrice(String patientsname) throws SQLException {
        int sum = 0;
        Prescriptions[] prescriptions;
        prescriptions = prescriptionsRepository.priceForEachitem(patientsname);
        while (true){
            if(prescriptions.length == 0 || prescriptions[0]==null){
                System.out.println("you have not prescription confirmed. please wait ");
                break;
            }else{
                for (int i = 0 ; i < prescriptions.length ; i++){
                    if(prescriptions[i] != null){
                         sum += prescriptions[i].getPrice() * prescriptions[i].getQuantity();
                    }
                }
            }
            break;
        }
        return sum;
    }


    @Override
    public void deleteprescription(String patientsname) throws SQLException {
        Prescriptions prescriptions = new Prescriptions();
        prescriptions.setPatientsName(patientsname);
        prescriptionsRepository.delete(prescriptions);
    }

    @Override
    public void editPrescriptionsDrug(Prescriptions newPrescriptions , Prescriptions oldPrescriptions) throws SQLException {
        prescriptionsRepository.edtit(newPrescriptions , oldPrescriptions);
    }

    @Override
    public void showAllPrescriptions() throws SQLException {
        Prescriptions[] prescriptions;
        prescriptions = prescriptionsRepository.showAllPrescriptions();
        while (true){
            if(prescriptions.length == 0 || prescriptions[0]==null){
                System.out.println("you have not prescription confirmed. please wait ");
                break;
            }else{
                for (int i = 0 ; i < prescriptions.length ; i++){
                    if(prescriptions[i] != null){
                        System.out.println((i+1) + " _  " + prescriptions[i]);
                    }
                }
            }
            break;
        }
    }

    @Override
    public void adminEdit(Prescriptions newPrescriptions, Prescriptions oldPrescriptions) throws SQLException {
        prescriptionsRepository.adminEdit(newPrescriptions , oldPrescriptions);
    }
}
