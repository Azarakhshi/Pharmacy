package view.useroption.adminoption;

import java.sql.SQLException;


import entity.Prescriptions;
import repository.drugs.DrugsRepositoryImpl;
import repository.patient.PatientRepositoryImpl;
import repository.prescriptions.PrescriptionsRepositoryImpl;
import service.admin.AdminService;
import service.admin.AdminServiceImpl;
import service.drugs.DrugsService;
import service.drugs.DrugsServiceImpl;
import service.patient.PatientServiceImpl;
import service.prescriptions.PrescriptionsService;
import service.prescriptions.PrescriptionsServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminOption {
    Scanner scanner = new Scanner(System.in);
    PatientServiceImpl patientService = new PatientServiceImpl(new PatientRepositoryImpl());
    Prescriptions prescriptions = new Prescriptions();
    DrugsService drugsService = new DrugsServiceImpl
            (new DrugsRepositoryImpl());
    PrescriptionsService prescriptionsService = new PrescriptionsServiceImpl
            (new PrescriptionsRepositoryImpl());

    public void adminOptions() throws SQLException {

        while (true) {
            System.out.println("1- see all prescriptions. ");
            System.out.println("2- edit drug for patient prescriptions. ");
            System.out.println("exit.");
            String enter = scanner.next();
            if (enter.equals("1")) {
                prescriptionsService.showAllPrescriptions();
            } else if (enter.equals("2")) {
                AdminEditDrug();
            } else if (enter.equals("exit.")) {
                break;
            } else {
                System.out.println("your input is invalid. ");

            }
        }
    }
    Prescriptions newPrescriptions = new Prescriptions();
    Prescriptions oldPrescriptions = new Prescriptions();

    public void AdminEditDrug()throws SQLException{
        while (true){
            System.out.println("please enter the name of patients Prescription: ");
            String input = scanner.next();
            if(patientService.patientNameContains(input) && input.length() <= 25){
                oldPrescriptions.setPatientsName(input);
                break;
            }else{
                System.out.println("your input is invalid. ");
            }
        }
        while (true){
            System.out.println("please enter the name of drug: ");
            String input = scanner.next();
            if(drugsService.drugsContains(input) && input.length() <= 50 ){
                oldPrescriptions.setDrugsName(input);
                break;
            }else{
                System.out.println("your input is invalid. ");
            }
        }
        while (true){
            System.out.println("plese enter the Confirm: true or false: ");
            String input = scanner.next();
            if(input.equals("true")){
                newPrescriptions.setConfirm(true);
                break;
            }else if(input.equals("false")){
                newPrescriptions.setConfirm(false);
                break;
            }else{
                System.out.println("your input is invalid. ");
            }
        }
        while (true){
            System.out.println("plese enter the exist: true or false: ");
            String input = scanner.next();
            if(input.equals("true")){
                newPrescriptions.setDoesExist(true);
                break;
            }else if(input.equals("false")){
                newPrescriptions.setDoesExist(false);
                break;
            }else{
                System.out.println("your input is invalid. ");
            }
        }
        while (true){
            System.out.println("please enter the price: ");
            String input = scanner.next();
            if(input.matches("[^a-zA-z]*")){
               newPrescriptions.setPrice(Integer.parseInt(input));
               break;
            }else{
                System.out.println("your input is invalid. ");
            }
        }
        prescriptionsService.adminEdit(newPrescriptions,oldPrescriptions);


    }

}
