package service.admin;

import entity.PharmacyAdmin;
import repository.admin.AdminRepository;
import view.useroption.adminoption.AdminOption;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();

    public boolean adminNameContains(String adminName) throws SQLException {
        pharmacyAdmin.setAdminName(adminName);
        return adminRepository.adminNameContains(pharmacyAdmin);
    }
    AdminOption adminOption = new AdminOption();
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
            adminOption.adminOptions();
        }
    }

    @Override
    public void logIn(String adminName, String adminPassword) throws SQLException {
        pharmacyAdmin.setAdminName(adminName);
        pharmacyAdmin.setAdminPassword(adminPassword);
        if (adminRepository.adminNameContains(pharmacyAdmin)) {
            adminOption.adminOptions();
        }else{
            System.out.println("your account is not exist. ");
        }
    }

}
