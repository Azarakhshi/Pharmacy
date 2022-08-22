package service.admin;

import java.sql.SQLException;

public interface AdminService {

    void signUp(String adminName, String adminPassword) throws SQLException;
    void logIn(String adminName, String adminPassword) throws SQLException;
}
