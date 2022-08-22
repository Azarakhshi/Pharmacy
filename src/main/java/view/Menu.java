package view;

import repository.admin.AdminRepositryImpl;
import repository.patient.PatientRepositoryImpl;
import service.admin.AdminServiceImpl;
import service.patient.PatientServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserMenu userMenu = new UserMenu(new PatientServiceImpl(new PatientRepositoryImpl()),
            new AdminServiceImpl(new AdminRepositryImpl()));
    public void guestMenu() throws SQLException {

        while (true) {
            System.out.println("Welcome");
            System.out.println("please enter the Menu: ");
            System.out.println("1_patient. ");
            System.out.println("2_admin. ");
            System.out.println("exit ");

            String input = scanner.next();
            if(input.equals("1") || input.equals("2")){
                patientOrAdmainMenu(input);
            }else if(input.equals("exit")){
                break;
            }else{
                System.out.println("your input is invalid. ");
                System.out.println("**********");
            }
        }
    }

    public void patientOrAdmainMenu(String enter) throws SQLException {
        while (true) {
            System.out.println("1_Log in  ");
            System.out.println("2_sign up ");
            System.out.println("exit");
            String input = scanner.next();
            if(input.equals("1")){
                userMenu.userlogin(enter);
            }else if(input.equals("2")){
                userMenu.userSignUp(enter);
            } else if(input.equals("exit")){
                break;
            }else{
                System.out.println("your input is invalid. ");
            }
        }
    }
}
