package repository.drugs;

import entity.Drugs;


import java.sql.SQLException;

public interface DrugsRepository {
    boolean drugsContains(Drugs drugs) throws SQLException;
}
