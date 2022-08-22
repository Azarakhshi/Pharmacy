package service.drugs;

import entity.Drugs;

import java.sql.SQLException;

public interface DrugsService {
    boolean drugsContains(String drugName) throws SQLException;
}
