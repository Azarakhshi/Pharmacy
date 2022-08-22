package service.admin;

import entity.PharmacyAdmin;
import repository.admin.AdminRepository;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();

    private boolean adminNameContains(String adminName) throws SQLException {
        pharmacyAdmin.setAdminName(adminName);
        return adminRepository.adminContains(pharmacyAdmin);
    }
    @Override
    public void signUp(String adminName, String adminPassword) throws SQLException {
        if (adminNameContains(adminName)) {
            System.out.println("sign up failed. ");
            System.out.println("this name is exist. please enter the another name.");
        } else {
            pharmacyAdmin.setAdminName(adminName);
            pharmacyAdmin.setAdminPassword(adminPassword);
            adminRepository.save(pharmacyAdmin);
            System.out.println("sign up is successfully. ");
            //show patient menu
        }
    }

    @Override
    public void logIn(String adminName, String adminPassword) throws SQLException {
        pharmacyAdmin.setAdminName(adminName);
        pharmacyAdmin.setAdminPassword(adminPassword);
        if (adminRepository.adminNameContains(pharmacyAdmin)) {
            //show patient menu
        }else{
            System.out.println("your account is not exist. ");
        }
    }

}
