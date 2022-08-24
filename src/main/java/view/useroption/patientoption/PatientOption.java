package view.useroption.patientoption;

import entity.Prescriptions;
import repository.drugs.DrugsRepositoryImpl;
import repository.prescriptions.PrescriptionsRepositoryImpl;
import service.drugs.DrugsService;
import service.drugs.DrugsServiceImpl;
import service.prescriptions.PrescriptionsService;
import service.prescriptions.PrescriptionsServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class PatientOption {
    Scanner scanner = new Scanner(System.in);
    Prescriptions prescriptions = new Prescriptions();
    DrugsService drugsService = new DrugsServiceImpl
            (new DrugsRepositoryImpl());
    PrescriptionsService prescriptionsService = new PrescriptionsServiceImpl
            (new PrescriptionsRepositoryImpl());

    public void patientOptions(String patientName) throws SQLException {
        while (true) {
            System.out.println("1- Add prescription. ");
            System.out.println("2- See confirmed price for each item. ");
            System.out.println("3- See confirmed total price. ");
            System.out.println("4- Edit drug prescription. ");
            System.out.println("5- Delete prescription. ");
            System.out.println("exit");
            String input = scanner.next();
            if (input.equals("1")) {
                addDrugToprescription(patientName);
            } else if (input.equals("2")) {
                prescriptionsService.priceForEachitem(patientName);
            } else if (input.equals("3")) {
                System.out.println(prescriptionsService.totalPrice(patientName));
            } else if (input.equals("4")) {
                editDrugToprescription(patientName);
            } else if (input.equals("5")) {
                prescriptionsService.deleteprescription(patientName);
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("your input is invalid. ");
            }
        }
    }

    public void createDrugToprescription() throws SQLException {

        while (true) {
            System.out.println("please enter the drugs name: ");
            String drugsName = scanner.next();
            if (drugsService.drugsContains(drugsName) && drugsName.length() <= 50) {
                prescriptions.setDrugsName(drugsName);
                break;
            } else {
                System.out.println("your input is invalid. ");
            }
        }
        while (true) {
            System.out.println("please enter the quantity: ");
            String quantity = scanner.next();
            if (quantity.matches("[^a-zA-z]*")) {
                prescriptions.setQuantity(Integer.parseInt(quantity));
                break;
            } else {
                System.out.println("your input is invalid. ");
            }
        }

    }

    public void addDrugToprescription(String patientName) throws SQLException {

        if(prescriptionsService.isPatientexist(patientName)){
            System.out.println("your account use the pharmacy. ");
            System.out.println("please sign up new account to add prescription");
            return;
        }
        prescriptions.setPatientsName(patientName);
        //use patient name login or signup
        for (int i = 1; i <= 10; i++) {
            createDrugToprescription();
            prescriptionsService.addDrugtoPrescriptions(prescriptions);
            System.out.println("your drugs add to prescription");
            System.out.println("if you couldn't add please enter the 'exit' ");
            System.out.println("or not enter the everything. ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")){
                break;
            }
        }

    }
    public void editDrugToprescription(String patientName) throws SQLException{
       prescriptions.setPatientsName(patientName);
        while (true) {
            System.out.println("please enter the drugs old name: ");
            String drugsName = scanner.next();
            if (drugsService.drugsContains(drugsName) && drugsName.length() <= 50) {
                prescriptions.setDrugsName(drugsName);
                break;
            } else {
                System.out.println("your input is invalid. ");
            }
        }
        Prescriptions prescriptions1 = new Prescriptions();
        while (true) {
            System.out.println("please enter the drugs new name: ");
            String drugsName = scanner.next();
            if (drugsService.drugsContains(drugsName) && drugsName.length() <= 50) {
                prescriptions1.setDrugsName(drugsName);
                break;
            } else {
                System.out.println("your input is invalid. ");
            }
        }
        while (true) {
            System.out.println("please enter the new quantity: ");
            String quantity = scanner.next();
            if (quantity.matches("[^a-zA-z]*")) {
                prescriptions1.setQuantity(Integer.parseInt(quantity));
                break;
            } else {
                System.out.println("your input is invalid. ");
            }
        }
        prescriptionsService.editPrescriptionsDrug(prescriptions1,prescriptions);

    }

}
