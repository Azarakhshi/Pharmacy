package view;

import service.admin.AdminService;
import service.patient.PatientService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {

    private final PatientService patientService;
    private AdminService adminService;
    Scanner scanner = new Scanner(System.in);

    public UserMenu(PatientService patientService, AdminService adminService) {
        this.patientService = patientService;
        this.adminService = adminService;
    }

    public void userlogin(String userType) throws SQLException {
        String name = null;
        while (true) {
            System.out.println("please enter the user name: ");
            name = scanner.next();
            if (name.length() <= 25) {
                break;
            } else {
                System.out.println("your input length is bigger than 25. ");
            }
        }
        String password = null;
        while (true) {
            System.out.println("please enter the password: ");
            password = scanner.next();
            if (password.length() <= 20) {
                break;
            } else {
                System.out.println("your input length is bigger than 20. ");
            }
        }
        if (userType.equals("1")) {
            patientService.logIn(name, password);
        } else {
            adminService.logIn(name, password);
        }
    }

    public void userSignUp(String userType) throws SQLException {
        String name;
        while (true) {
            System.out.println("please enter the user name: ");
            name = scanner.next();
            if (name.length() <= 25) {
                break;
            } else {
                System.out.println("your input length is bigger than 25. ");
            }
        }

        String password;
        while (true) {
            System.out.println("please enter the password: ");
            password = scanner.next();
            if (password.length() <= 20) {
                break;
            } else {
                System.out.println("your input length is bigger than 20. ");
            }
        }
        if (userType.equals("1")) {
            patientService.signUp(name,password);
        }else {
            adminService.signUp(name,password);
        }

    }

}
