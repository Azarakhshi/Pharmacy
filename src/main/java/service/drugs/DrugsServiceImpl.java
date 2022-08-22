package service.drugs;

import entity.Drugs;
import repository.drugs.DrugsRepository;

import java.sql.SQLException;

public class DrugsServiceImpl implements DrugsService{
    private DrugsRepository drugsRepository;

    public DrugsServiceImpl(DrugsRepository drugsRepository) {
        this.drugsRepository = drugsRepository;
    }
    Drugs drugs = new Drugs();

    @Override
    public boolean drugsContains(String drugName) throws SQLException {
     drugs.setDrugName(drugName);
     return drugsRepository.drugsContains(drugs);
    }
}
